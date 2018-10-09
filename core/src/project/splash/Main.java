package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    OrthographicCamera camera;
    int nCounter = 0;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        for (int i = 0; i < 10; i++){
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite (textureRegion);
        }
        //basketballNet = new SpriteSheet (textureAtlas.findRegion("Net1"), 100, 100, 144, 156);
        Gdx.input.setInputProcessor(this);
        font = new BitmapFont();
        font.setColor(Color.BLACK);
    }

    public int mousePressed(){
	    int nY = 0;
	    if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                nY = Gdx.input.getY();
        }
        return nY;
    }

    public int mouseDragged(){
	    int nY2, nDy = 0, iSpr, nY = mousePressed();
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            nY2 = Gdx.input.getY() + 1;
            nDy = nY2 - mousePressed();
            iSpr = nDy / 50;
        }
	    return nDy;
    }

    @Override
	public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
            for (int i = 0; i < 10; i++) {
                arSprNet[i].draw(batch);
        }
        System.out.println(mousePressed() + "   " + mouseDragged());
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
