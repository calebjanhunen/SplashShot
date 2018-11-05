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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class ScrPlay implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    private BitmapFont font;
    OrthographicCamera camera;
    Rectangle rectNet, rectBall;
    ShapeRenderer shaperenderer;
    Texture txtball;
    Vector2 v2balllocation, v2ballvelocity, v2ballgravity;
    int nMouseY, nMouseY2, nMouseDy, iSpr, nMouseX, nMouseX2, nMouseDx, iDiv;
    int nBallWidth = 70, nBallHeight = 70;
    SprNet sprNet1 = new SprNet(100,100, 250, 250);
    Sprite sprCurNet = new Sprite();
    Sprite sprBall;

    public ScrPlay(GamMain game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor((this));
        font = new BitmapFont();
        font.setColor(Color.BLACK);

        shaperenderer = new ShapeRenderer();
        v2balllocation = new Vector2(300,600);
        v2ballvelocity = new Vector2((float)8.0,(float)10.0);
        v2ballgravity = new Vector2(0,(float) 0.5);
        txtball = new Texture("basketball.png");
        sprBall = new Sprite(txtball);
        sprBall.setSize(nBallWidth, nBallHeight);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sprCurNet = sprNet1.update(iSpr);
        batch.begin();
        sprCurNet.setRotation(nMouseDx); //need the rectangle net hitbox to rotate as well
        sprCurNet.draw(batch);

        sprBall.setPosition(v2balllocation.x, v2balllocation.y);
        sprBall.draw(batch);
        batch.end();

        shaperenderer.begin(ShapeRenderer.ShapeType.Line);
        shaperenderer.setColor(Color.RED);
        shaperenderer.rect(sprBall.getX(),sprBall.getY(),sprBall.getWidth(), sprBall.getHeight());
        shaperenderer.rect(sprCurNet.getX(),sprCurNet.getY(),sprCurNet.getWidth(), sprCurNet.getHeight());   //the y coordinate of the bottom of the net needs to be constantly updated as the net stretches to create a hitbox there
        shaperenderer.end();

        HandleBouncing();
        HandleHitDetection();
    }

    public void HandleBouncing(){
        v2balllocation.y += v2ballvelocity.y;  //  https://www.openprocessing.org/sketch/67284#
        v2ballvelocity.y -= v2ballgravity.y;

        if (v2balllocation.y < 0) {
            v2ballvelocity.y = (float)(v2ballvelocity.y * -0.9);
            v2balllocation.y = 0;
        }
    }

    public void HandleHitDetection(){
        sprBall.getBoundingRectangle();
        rectBall = new Rectangle(sprBall.getX(), sprBall.getY(), sprBall.getWidth(), sprBall.getHeight());
        rectNet = new Rectangle(sprCurNet.getX(), sprCurNet.getY(), sprCurNet.getWidth(), sprCurNet.getHeight());
        boolean isOverlapping = rectBall.overlaps(rectNet);
        if (isOverlapping) {
            System.out.println("overlapping");
        }
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

