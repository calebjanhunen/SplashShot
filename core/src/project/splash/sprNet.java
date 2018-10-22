package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class sprNet extends Sprite implements InputProcessor {
    int width, height;
    SpriteBatch batch;
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    String sNet;
    Texture tx;
    Sprite arSprNet[] = new Sprite[10];
    int nY, nY2, nDy, iSpr, nX, nX2, nDx;

    public sprNet(){
        for (int i = 0; i < 9; i++) {
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite (textureRegion);
        }
    }

    public void update(){
        Gdx.input.setInputProcessor(this);
        System.out.println(nDy + "    " + nDx + "    " + iSpr);

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
        nY = Gdx.input.getY();
        nX = Gdx.input.getX();
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
        nY2 = Gdx.input.getY();
        nDy = nY2 - nY;
        if (nDy < 29){
            iSpr = 0;
        }else if (nDy >= 29 && nDy < 48){
            iSpr = 1;
        }else if (nDy >= 49 && nDy < 68){
            iSpr = 2;
        }else if (nDy >= 69 && nDy < 88){
            iSpr = 3;
        }else if (nDy >= 89 && nDy < 108){
            iSpr = 4;
        }else if (nDy >= 109 && nDy < 128){
            iSpr = 5;
        }else if (nDy >= 129 && nDy < 148){
            iSpr = 6;
        }else if (nDy >= 149 && nDy < 168){
            iSpr = 7;
        }else if (nDy >= 169 && nDy < 188){
            iSpr = 8;
        }else if (nDy >= 189 && nDy < 208){
            iSpr = 9;
        } else if (nDy >= 208){
            iSpr = 9;
        } else if (nDy >= 208){
            iSpr = 9;
        }

        //net x direction
        nX2 = Gdx.input.getX();
        nDx = nX2 - nX;
        if (nDx >= 90){
            nDx = 90;
        } else if (nDx <= -90){
            nDx = -90;
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
