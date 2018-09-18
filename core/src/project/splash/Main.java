package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.spash.gfx.bufferedImageLoader;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
    BufferedImage spriteSheet = null;
	
	@Override
	public void create () {
        bufferedImageLoader loader = new bufferedImageLoader();
        try{
            spriteSheet = loader.loadImage("/NetSpriteSheet.png");
        }catch(IOException e){
            e.printStackTrace();
        }
        img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
        create();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
