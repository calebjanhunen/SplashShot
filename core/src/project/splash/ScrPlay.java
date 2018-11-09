package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;


public class ScrPlay implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    private BitmapFont font;
    OrthographicCamera camera;
    Random r = new Random();
    int nMouseY, nMouseY2, nMouseDy, iSpr, nMouseX, nMouseX2, nMouseDx, iDiv, ranX1, ranX2;
    int nMinX = 200, nMaxX = 400;
    SprNet sprNet1, sprNet2;
    Sprite sprCurNet = new Sprite(), sprCurNet2 = new Sprite();

    public ScrPlay(GamMain game) {
        this.game = game;
        Gdx.input.setInputProcessor((this));
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        ranX1 = r.nextInt(nMaxX - nMinX); // random x coordinate for first net
        ranX2 = r.nextInt(nMaxX - nMinX); // random x coordinate for second net
        while (ranX1 - ranX2 <= 150 && ranX1 - ranX2 >= -150){
            ranX1 = r.nextInt(nMaxX - nMinX); // random x coordinate for first net
            ranX2 = r.nextInt(nMaxX - nMinX); // random x coordinate for second net
        }
        sprNet1 = new SprNet(ranX1,100, 100, 100); //First Net
        sprNet2 = new SprNet(ranX2,400, 100, 100); // Second Net
        System.out.println(ranX1 + " " + ranX2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sprCurNet = sprNet1.update(iSpr);
        sprCurNet2 = sprNet2.update(iSpr);
        batch.begin();
        sprCurNet.setRotation(nMouseDx);
        sprCurNet2.setRotation(nMouseDx);
        sprCurNet.draw(batch);
        sprCurNet2.draw(batch);
        batch.end();
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

