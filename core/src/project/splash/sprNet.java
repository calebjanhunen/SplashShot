package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class sprNet extends Sprite implements InputProcessor {
    int width, height;
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    String sNet;
    Texture tx;
    Sprite arSprNet[] = new Sprite[10];

    public sprNet(){
        for (int i = 0; i < 9; i++) {
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite (textureRegion);
        }
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
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
