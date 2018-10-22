package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.
import project.splash.sprNet;

public class ScrPlay implements InputProcessor, Screen {
    GamMain game;
	SpriteBatch batch;
    sprNet basketballNet;
    TextureRegion textureRegion;
    Sprite arSprNet[] = new Sprite[10];
    private BitmapFont font;
    OrthographicCamera camera;
    int nY, nY2, nDy, iSpr, nX, nX2, nDx;
    Texture tx;
    sprNet net = new sprNet();

    public ScrPlay (GamMain game){
        this.game = game;
        tx = new Texture ("NetSpriteSheet.png");
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //for (int i = 0; i < 10; i++){
        //arSprNet2 = new sprNet (, 100, 100, 144, 156);
        //arSprNet[i] = new Sprite (textureRegion);
        //arSprNet[i].setPosition(100,100);
        //arSprNet[i].setOrigin(arSprNet[i].getWidth()/2, arSprNet[i].getHeight());
        //}
        Gdx.input.setInputProcessor(this);
        font = new BitmapFont();
        font.setColor(Color.BLACK);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        for (float i = 0; i < 10; i++) {
        //arSprNet2[iSpr].setRotation(nDx);
        //arSprNet[iSpr].draw(batch);
        //arSprNet2.draw(batch);
//        }


        batch.end();
        net.update();
      //  System.out.println(nDy + "    " + nDx + "    " + iSpr);
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
    public void dispose () {
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
//        nY = Gdx.input.getY();
//        nX = Gdx.input.getX();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //iSpr = 0;
        //nDx = 0;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        // net y direction
//        nY2 = Gdx.input.getY();
//        nDy = nY2 - nY;
//        if (nDy < 29){
//            iSpr = 0;
//        }else if (nDy >= 29 && nDy < 48){
//            iSpr = 1;
//        }else if (nDy >= 49 && nDy < 68){
//            iSpr = 2;
//        }else if (nDy >= 69 && nDy < 88){
//            iSpr = 3;
//        }else if (nDy >= 89 && nDy < 108){
//            iSpr = 4;
//        }else if (nDy >= 109 && nDy < 128){
//            iSpr = 5;
//        }else if (nDy >= 129 && nDy < 148){
//            iSpr = 6;
//        }else if (nDy >= 149 && nDy < 168){
//            iSpr = 7;
//        }else if (nDy >= 169 && nDy < 188){
//            iSpr = 8;
//        }else if (nDy >= 189 && nDy < 208){
//            iSpr = 9;
//        } else if (nDy >= 208){
//            iSpr = 9;
//        } else if (nDy >= 208){
//            iSpr = 9;
//        }
//
//        //net x direction
//        nX2 = Gdx.input.getX();
//        nDx = nX2 - nX;
//        if (nDx >= 90){
//            nDx = 90;
//        } else if (nDx <= -90){
//            nDx = -90;
//        }
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
