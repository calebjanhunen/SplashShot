package project.splash.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import project.splash.GamMain;
import project.splash.Objects.SprBall;
import project.splash.Objects.SprNet;
import project.splash.RandomXCoordinate;

import java.util.Random;


public class ScrPlay implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    private BitmapFont font;
    OrthographicCamera camera;
    Random r;
    public int nMouseY, nMouseY2, nMouseDy, nMouseDy2, iSpr, nMouseX, nMouseX2, nMouseDx, iDiv, nCount = 0;
    SprNet sprNet1, sprNet2;
    Sprite sprCurNet, sprCurNet2;
    SprBall sprBall;
    Polygon polyBotNet1, polyTopNet1, polyTopNet2, polyBotNet2, polyBall;
    Vector2 v2balllocation;
    boolean isOverlappingBotNet1, isOverlappingTopNet1, isOverlappingBotNet2, isOverlappingTopNet2, isShot, isOverlappingNets, isTouchingWall;
    float ballVelX, ballVelY;
    RandomXCoordinate ranX1 = new RandomXCoordinate();
    ShapeRenderer shaperenderer = new ShapeRenderer();

    public ScrPlay(GamMain game) {
        this.game = game;
        Gdx.input.setInputProcessor((this));
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);
        camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        r = new Random();
        isOverlappingNets = true;
        isTouchingWall = false;

        sprNet1 = new SprNet(190,100, 150, 150); //First Net
        sprNet2 = new SprNet(ranX1.getNranX2(),500, 150, 150); // Second Net
        sprBall  = new SprBall(0, 500, 43, 43);
        polyBall = new Polygon(new float[]{sprBall.getX(),sprBall.getY(),sprBall.getX() + sprBall.nW,sprBall.getY(),sprBall.getX() + sprBall.nW, sprBall.getY() + sprBall.nH,sprBall.getX(),sprBall.getY() + sprBall.nH});
        sprCurNet = new Sprite();
        sprCurNet = sprNet1.update(0, 150, 150);
        sprCurNet2 = new Sprite();
        sprCurNet2 = sprNet2.update(0, 150, 150);
        //hitboxes for first net
        polyBotNet1 = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY() + 93,sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY() + 93,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight() - 8,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight() - 8});
        polyTopNet1 = new Polygon(new float[]{sprNet1.getX() + 12,sprNet1.getY() + 141,sprNet1.getX() + sprCurNet.getWidth() - 12,sprNet1.getY() + 141,sprNet1.getX() + sprCurNet.getWidth() - 12, sprNet1.getY() + sprCurNet.getHeight()- 1,sprNet1.getX() + 12,sprNet1.getY() + sprCurNet.getHeight() - 1});
        //hitboxes for second net
        polyBotNet2 = new Polygon(new float[]{sprNet2.getX(),sprNet2.getY() + 93,sprNet2.getX() + sprCurNet2.getWidth(),sprNet2.getY() + 93,sprNet2.getX() + sprCurNet2.getWidth(), sprNet2.getY() + sprCurNet2.getHeight() - 8,sprNet2.getX(),sprNet2.getY() + sprCurNet2.getHeight() - 8});
        polyTopNet2 = new Polygon(new float[]{sprNet2.getX() + 12,sprNet2.getY() + 141,sprNet2.getX() + sprCurNet2.getWidth() - 12,sprNet2.getY() + 141,sprNet2.getX() + sprCurNet2.getWidth() - 12, sprNet2.getY() + sprCurNet2.getHeight()- 1,sprNet2.getX() + 12,sprNet2.getY() + sprCurNet2.getHeight() - 1});
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        nCount++;
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (nCount >=60){
            camera.position.set(Gdx.graphics.getWidth()/2, sprBall.getY() + 303, 0);
        }
            if (isOverlappingBotNet1) {
            sprCurNet = sprNet1.update(iSpr, 210, 210);
        } else if (isOverlappingBotNet2) {
            sprCurNet2 = sprNet2.update(iSpr, 210, 210);
        }
        camera.update();
        v2balllocation = sprBall.update();


        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        if (isOverlappingBotNet1) {
            sprBall.setRotation(nMouseDx);
            polyBall.setRotation(nMouseDx);
            sprCurNet.setRotation(nMouseDx);
            polyTopNet1.setRotation(nMouseDx);
            polyBotNet1.setRotation(nMouseDx);

        }

        else if (isOverlappingBotNet2){
            sprBall.setRotation(nMouseDx);
            polyBall.setRotation(nMouseDx);
            sprCurNet2.setRotation(nMouseDx);
            polyTopNet2.setRotation(nMouseDx);
            polyBotNet2.setRotation(nMouseDx);
            sprCurNet2.setRotation(nMouseDx);
        }


        sprBall.draw(batch);
        sprCurNet.draw(batch);
        sprCurNet2.draw(batch);
        //hitboxes for first net
        polyBotNet1.setOrigin(sprCurNet.getWidth()/2, sprCurNet.getHeight());
        polyBotNet1.setPosition(sprCurNet.getX(), sprCurNet.getY());
        polyTopNet1.setOrigin(sprCurNet.getWidth()/2, sprCurNet.getHeight());
        polyTopNet1.setPosition(sprCurNet.getX(), sprCurNet.getY());
        //hitboxes for second net
        polyBotNet2.setOrigin(sprCurNet2.getWidth()/2, sprCurNet2.getHeight());
        polyBotNet2.setPosition(sprCurNet2.getX(), sprCurNet2.getY());
        polyTopNet2.setOrigin(sprCurNet2.getWidth()/2, sprCurNet2.getHeight());
        polyTopNet2.setPosition(sprCurNet2.getX(), sprCurNet2.getY());
        polyBall.setOrigin(sprBall.getWidth()/2, sprBall.getHeight());
        polyBall.setPosition(v2balllocation.x, v2balllocation.y);
        sprBall.setOrigin(sprBall.getWidth() / 2, sprBall.getHeight());
        sprBall.setPosition(v2balllocation.x, v2balllocation.y);
        batch.end();

        HandleHitDetection();
        HandleShooting();
        HandleWallHit();


        shaperenderer.begin(ShapeRenderer.ShapeType.Line);
        shaperenderer.setProjectionMatrix(camera.combined);
       // shaperenderer.rect(sprBall.getWidth() / 2, sprBall.getHeight(), 10 ,10);
        //hitboxes for first net
//        shaperenderer.setColor(Color.PINK);
//        shaperenderer.polygon(polyBotNet1.getTransformedVertices());
//        shaperenderer.setColor(Color.BROWN);
//        shaperenderer.polygon(polyTopNet1.getTransformedVertices());
//        //hitboxes for second net
//        shaperenderer.setColor(Color.PINK);
//        shaperenderer.polygon(polyBotNet2.getTransformedVertices());
//        shaperenderer.setColor(Color.BROWN);
//        shaperenderer.polygon(polyTopNet2.getTransformedVertices());
//        shaperenderer.setColor(Color.ORANGE);
//        shaperenderer.polygon(polyBall.getTransformedVertices());
        shaperenderer.end();

        shaperenderer.begin(ShapeRenderer.ShapeType.Filled);
        shaperenderer.setProjectionMatrix(camera.combined);
        PowerBar();
        shaperenderer.end();

        if (sprBall.getY() <= camera.position.y - 500){ //initiates game over screen
            game.setScreen(new ScrGameOver(game));
        }
        //System.out.println(ranX1.getNranX1() + " " + sprCurNet.getX() + " " + sprBall.getX());
        //System.out.println(sprCurNet2.getX() + " " + sprCurNet2.getY());
//        System.out.println((v2balllocation.y+1) - v2balllocation.y);
    }

    public void HandleHitDetection() { // https://stackoverflow.com/questions/30554629/how-can-i-rotate-rectangles-in-libgdx  // https://github.com/TimCatana/gamegravity
        isOverlappingBotNet1 = Intersector.overlapConvexPolygons(polyBall, polyBotNet1);
        isOverlappingTopNet1 = Intersector.overlapConvexPolygons(polyBall, polyTopNet1);
        isOverlappingBotNet2 = Intersector.overlapConvexPolygons(polyBall, polyBotNet2);
        isOverlappingTopNet2 = Intersector.overlapConvexPolygons(polyBall, polyTopNet2);
        if (isOverlappingNets) {
            if (isOverlappingTopNet1) {
                    sprBall.setV2ballgravity (new Vector2((float) 0.0, (float) 0.0));
                    sprBall.setV2ballvelocity(new Vector2((float) 0.0, (float) 0.0));
                    v2balllocation.y = sprCurNet.getY() + 96;
                    v2balllocation.x = sprCurNet.getX() + 54;
                    ballVelX = ballVelX * -1;
            }
            if (isOverlappingTopNet2) {
                    sprBall.setV2ballgravity (new Vector2((float) 0.0, (float) 0.0));
                    sprBall.setV2ballvelocity(new Vector2((float) 0.0, (float) 0.0));
                    v2balllocation.y = sprCurNet2.getY() + 96;
                    v2balllocation.x = sprCurNet2.getX() + 54;
            }
        }

//            if (isOverlappingBotNet1 || isOverlappingBotNet2) {
//                sprBall.setV2ballvelocity(new Vector2(ballVelX, -ballVelY));
//            }

            if (!isOverlappingBotNet1 && !isOverlappingBotNet2) {
                isOverlappingNets = true;
                isShot = false;
            }
        }

    public void HandleShooting(){
        if (isShot && isOverlappingBotNet1 && (nMouseDy/9) >= 4.0) {
            if (sprBall.getX() > 0 && sprBall.getX() < Gdx.graphics.getWidth()) {
                ballVelX = -(nMouseDx/3);
                ballVelY = nMouseDy / 9;
                isOverlappingNets = false;
                sprBall.setV2ballgravity (new Vector2((float) 0.0, (float) -0.5));
                sprBall.setV2ballvelocity(new Vector2(ballVelX, ballVelY));
            }
        } else if (isShot && isOverlappingBotNet2 && (nMouseDy/9) >= 4.0) {
            if (sprBall.getX() > 0 && sprBall.getX() < Gdx.graphics.getWidth()) {
                ballVelX = -(nMouseDx/3);
                ballVelY = nMouseDy / 9;
                isOverlappingNets = false;
                sprBall.setV2ballgravity (new Vector2((float) 0.0, (float) -0.5));
                sprBall.setV2ballvelocity(new Vector2(ballVelX, ballVelY));
            }
        }
    }

    public void HandleWallHit(){
        if (sprBall.getX() >= Gdx.graphics.getWidth() || sprBall.getX() <= 0){
            isTouchingWall = true;
        } else {
            isTouchingWall = false;
        }

        if (isTouchingWall){
            ballVelY /= 3;
        }
        //if ball hits right side of window
        if (sprBall.getX() >= Gdx.graphics.getWidth()-sprBall.getWidth()/2 && ballVelX == -(nMouseDx/3)){
            ballVelX = (nMouseDx/3);
            sprBall.setV2ballvelocity(new Vector2(ballVelX, ballVelY));
        } else if (sprBall.getX() >= Gdx.graphics.getWidth()-sprBall.getWidth()/2 && ballVelX == (nMouseDx/3)) {
            ballVelX = -(nMouseDx/3);
            sprBall.setV2ballvelocity(new Vector2(ballVelX,  ballVelY));
        }
        //if ball hits left side of window
        if (sprBall.getX() <= 0 && ballVelX == -(nMouseDx / 3)) {
            ballVelX = (nMouseDx/3);
            sprBall.setV2ballvelocity(new Vector2(ballVelX,  ballVelY));
        } else if (sprBall.getX() <= 0 && ballVelX == (nMouseDx / 3)) {
            ballVelX = -(nMouseDx/3);
            sprBall.setV2ballvelocity(new Vector2(ballVelX,  ballVelY));
        }

        if (sprBall.getY() <= 10){
            v2balllocation.y = sprCurNet.getY() + 96;
            v2balllocation.x = sprCurNet.getX() + 54;
        }
    }

    private void PowerBar(){
        if (iSpr >= 9){
            nMouseDy = 180;
        } else if (nMouseDy <=0) {
            nMouseDy = 0;
        }

        if (iSpr >= 9){
            nMouseDy2 = 180;
        } else if (nMouseDy2 <=0) {
            nMouseDy2 = 0;
        }

        shaperenderer.setColor(Color.BLACK);
        shaperenderer.rect(5,camera.position.y - 90,10,180); // black bar
        shaperenderer.setColor(249/255f, 146/255f, 7/255f, 0.5f);
        shaperenderer.rect(5,camera.position.y - 90,10,nMouseDy2); //yellow bar
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
        nMouseDy2 = 0; //resets the power bar when released
        return false;
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

        //needed for powerbar

        nMouseDy2 = nMouseY2 - nMouseY;

        iDiv = nMouseDy2 / 20;
        iSpr = iDiv;
        if (iDiv > 9) {
            iSpr = 9;
        } else if (iDiv < 0){
            iSpr = 0;
        }
        if (nMouseDy2 >= 225){
            nMouseDy2 = 225;
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



