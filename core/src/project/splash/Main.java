package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

//import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
    TextureAtlas textureAtlas;
    SpriteSheet basketballNet;
    TextureRegion textureRegion;
    Sprite arSprNet[] = new Sprite[10];
    String sNet;
    private BitmapFont font;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        for (int i = 1; i < 11; i++){
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i-1] = new Sprite (textureRegion);
        }
        //basketballNet = new SpriteSheet (textureAtlas.findRegion("Net1"), 100, 100, 144, 156);
        Gdx.input.setInputProcessor(this);
        font = new BitmapFont();
        font.setColor(Color.BLACK);
    }

    @Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            for (int i = 1; i < 11; i++) {
                arSprNet[i - 1].draw(batch);
            }
        }
		batch.end();
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
