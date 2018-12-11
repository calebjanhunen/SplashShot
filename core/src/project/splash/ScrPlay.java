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
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;


public class ScrPlay implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    private BitmapFont font;
    OrthographicCamera camera;
    Polygon polyBotNet, polyTopNet, polyBall;
    ShapeRenderer shaperenderer;
    Vector2 v2balllocation;
    int nMouseY, nMouseY2, nMouseDy, iSpr, nMouseX, nMouseX2, nMouseDx, iDiv, nBotNetCount = 1;
    boolean isOverlappingBotNet, isOverlappingTopNet, isShot, isOverlapping = true;
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
        sprBall  = new SprBall(200, 500, 75, 75);
        polyBall = new Polygon(new float[]{sprBall.getX(),sprBall.getY(),sprBall.getX() + sprBall.nW,sprBall.getY(),sprBall.getX() + sprBall.nW, sprBall.getY() + sprBall.nH,sprBall.getX(),sprBall.getY() + sprBall.nH});
        sprNet1 = new SprNet(100,100,250,250);
        sprCurNet = new Sprite();
        sprCurNet = sprNet1.update(0, 250, 250);
        polyBotNet = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY() + 155,sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY() + 155,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight() - 13,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight() - 13});
        polyTopNet = new Polygon(new float[]{sprNet1.getX() + 20,sprNet1.getY() + 236,sprNet1.getX() + sprCurNet.getWidth() - 20,sprNet1.getY() + 236,sprNet1.getX() + sprCurNet.getWidth() - 20, sprNet1.getY() + sprCurNet.getHeight()- 2,sprNet1.getX() + 20,sprNet1.getY() + sprCurNet.getHeight() - 2});
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        System.out.println(sprBall.getWidth() + " " + sprBall.getHeight());
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (isOverlappingBotNet) {
            sprCurNet = sprNet1.update(iSpr, 250, 250);
        }
        v2balllocation = sprBall.update();

        batch.begin();
        if (isOverlappingBotNet) {
            sprBall.setRotation(nMouseDx);
            polyBotNet.setRotation(nMouseDx);
            polyBall.setRotation(nMouseDx);
            sprCurNet.setRotation(nMouseDx);
            polyTopNet.setRotation(nMouseDx);
        }

        sprBall.draw(batch);
        sprCurNet.draw(batch);
        polyBotNet.setOrigin(sprCurNet.getWidth()/2, sprCurNet.getHeight());
        polyBotNet.setPosition(sprCurNet.getX(), sprCurNet.getY());
        polyTopNet.setOrigin(sprCurNet.getWidth()/2, sprCurNet.getHeight());
        polyTopNet.setPosition(sprCurNet.getX(), sprCurNet.getY());
        polyBall.setOrigin(sprBall.getWidth()/2, sprBall.getHeight());
        polyBall.setPosition(v2balllocation.x, v2balllocation.y);
        sprBall.setOrigin(sprBall.getWidth() / 2, sprBall.getHeight());
        sprBall.setPosition(v2balllocation.x, v2balllocation.y);

        batch.end();

        shaperenderer.begin(ShapeRenderer.ShapeType.Line);
        shaperenderer.rect(sprBall.getWidth() / 2, sprBall.getHeight(), 10 ,10);
        shaperenderer.setProjectionMatrix(camera.combined);
//        shaperenderer.setColor(Color.PINK);
//        shaperenderer.polygon(polyBotNet.getTransformedVertices());
//        shaperenderer.setColor(Color.BROWN);
//        shaperenderer.polygon(polyTopNet.getTransformedVertices());
//        shaperenderer.setColor(Color.ORANGE);
//        shaperenderer.polygon(polyBall.getTransformedVertices());
        shaperenderer.end();

        HandleHitDetection();
        HandleShooting();
    }

    public void HandleHitDetection(){ // https://stackoverflow.com/questions/30554629/how-can-i-rotate-rectangles-in-libgdx  // https://github.com/TimCatana/gamegravity
        isOverlappingBotNet = Intersector.overlapConvexPolygons(polyBall, polyBotNet);
        isOverlappingTopNet = Intersector.overlapConvexPolygons(polyBall, polyTopNet);
        if (isOverlapping) {
            if (isOverlappingTopNet) {
                if (isOverlappingBotNet) {
                    sprBall.setV2ballgravity(new Vector2((float) 0, (float) 0));
                    sprBall.setV2ballvelocity(new Vector2((float) 0.0, (float) 0.0));
                    v2balllocation.y = sprCurNet.getY() + 160;
                    v2balllocation.x = sprCurNet.getX() + 90;
                }
            }
        }
        if (isOverlappingBotNet){
            sprBall.setV2ballvelocity(new Vector2((float) 0.0, (float) 10));
        }
        if (!isOverlappingBotNet){
            isOverlapping = true;
            isShot = false;
        }
//        System.out.println(nMouseDy/9);
    }

    public void HandleShooting(){
        if (isShot && isOverlappingBotNet && (nMouseDy/9) >= 6.0){
            isOverlapping = false;
            sprBall.setV2ballgravity(new Vector2((float) 0, (float) -0.5));
            sprBall.setV2ballvelocity(new Vector2((float) -(nMouseDx/3), (float) nMouseDy/9));
            if (Math.abs(nMouseDx) > 60){
                sprBall.setV2ballvelocity(new Vector2((float) -(nMouseDx/2), (float) nMouseDy/9));
            }
            if (sprBall.getX() <= Gdx.graphics.getWidth(){
               sprBall.setV2ballvelocity(new Vector2((float) (nMouseDx/3), (float) nMouseDy/9));
            }

        }
        System.out.println(sprBall.getX());
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
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        iSpr = 0;
        isShot = true;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        isLaunched = false;
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
        if (nMouseDy >= 225){
            nMouseDy = 225;
        }

        //net x direction
        nMouseX2 = Gdx.input.getX();
        nMouseDx = nMouseX2 - nMouseX;
        if (nMouseDx >= 90){
            nMouseDx = 90;
        } else if (nMouseDx <= -90){
            nMouseDx = -90;
        }
        return true;
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

