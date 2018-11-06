package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


public class ScrPlay implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    private BitmapFont font;
    OrthographicCamera camera;
    Polygon polyNet, polyBall;
    ShapeRenderer shaperenderer;
    Texture txtball;
    Vector2 balllocation;
    int nMouseY, nMouseY2, nMouseDy, iSpr, nMouseX, nMouseX2, nMouseDx, iDiv;
    SprNet sprNet1;
    Sprite sprCurNet;
    SprBall sprBall;

    public ScrPlay(GamMain game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor((this));
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        shaperenderer = new ShapeRenderer();
        txtball = new Texture("basketball.png");
        sprBall  = new SprBall(txtball,300, 500, 100, 100);
        polyBall = new Polygon(new float[]{0,0,sprBall.getWidth(),0,sprBall.getWidth(),sprBall.getHeight(),0,sprBall.getHeight()});
        sprNet1 = new SprNet(100,100, 250, 250);
        sprCurNet = new Sprite();
        polyNet = new Polygon(new float[]{0,0,sprCurNet.getWidth(),0,sprCurNet.getWidth(),sprCurNet.getHeight(),0,sprCurNet.getHeight()});
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sprCurNet = sprNet1.update(iSpr);
        balllocation = sprBall.update();

        batch.begin();
        sprCurNet.setRotation(nMouseDx); //need the rectangle net hitbox to rotate as well
        sprCurNet.draw(batch);
        batch.draw(sprBall, balllocation.x, balllocation.y, sprBall.width, sprBall.height);
//        polyNet.setOrigin(arSprNet[i].getWidth()/2, arSprNet[i].getHeight()/2);
//        polyNet.setRotation(nMouseDx);
//        polyNet.setPosition(sprCurNet.getX(), sprCurNet.getY());
        batch.end();

        shaperenderer.begin(ShapeRenderer.ShapeType.Line);
        shaperenderer.setColor(Color.RED);
        shaperenderer.polygon(polyBall.getTransformedVertices());
        shaperenderer.polygon(polyNet.getTransformedVertices());//the y coordinate of the bottom of the net needs to be constantly updated as the net stretches to create a hitbox there
        shaperenderer.end();

        HandleHitDetection();
    }


    public void HandleHitDetection(){ // https://stackoverflow.com/questions/30554629/how-can-i-rotate-rectangles-in-libgdx

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        nMouseY = Gdx.input.getY();
        nMouseX = Gdx.input.getX();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        iSpr = 0;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // net y direction
        nMouseY2 = Gdx.input.getY();
        nMouseDy = nMouseY2 - nMouseY;
        iDiv = nMouseDy / 20;
        iSpr = iDiv;
        if (iDiv > 9) {
            iSpr = 9;
        } else if (iDiv < 0){
            iSpr = 0;
        }

        //net x direction
        nMouseX2 = Gdx.input.getX();
        nMouseDx = nMouseX2 - nMouseX;
        if (nMouseDx >= 90){
            nMouseDx = 90;
        } else if (nMouseDx <= -90){
            nMouseDx = -90;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

