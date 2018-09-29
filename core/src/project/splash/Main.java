package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

public class Main extends ApplicationAdapter implements InputProcessor {
    SpriteBatch batch;
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    SpriteSheet basketballNet;
    Sprite bballNet;
    private BitmapFont font;
    int currentFrame = 1;
    int maxFrames = 10;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
        textureRegion = textureAtlas.findRegion("Net1");
        bballNet = new Sprite(textureRegion);
        bballNet.setPosition(100, 100);
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
        bballNet.draw(batch);

		batch.end();
	}

    @Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}

    @Override
    public boolean keyDown(int keycode) {
	    if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){

        }
        return true;
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
