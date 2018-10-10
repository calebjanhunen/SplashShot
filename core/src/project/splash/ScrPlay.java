package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ScrPlay implements Screen {
	GamMain game;
	SpriteBatch batch;
	Texture txtball;
	Sprite sprBall;
	Vector2 balllocation, ballvelocity, ballgravity;
	int nBallWidth = 100, nBallHeight = 100;

	public ScrPlay(GamMain game) {
		this.game = game;
		batch = new SpriteBatch();
		txtball = new Texture("basketball.png");
		sprBall = new Sprite(txtball);
		balllocation = new Vector2(300,300);
		ballvelocity = new Vector2((float)8.0,(float)10.0);
		ballgravity = new Vector2(0,(float) 0.5);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(txtball, balllocation.x, balllocation.y, nBallWidth, nBallHeight); //ball
		batch.end();

		HandleBouncing();
	}

	public void HandleBouncing(){
		balllocation.y += ballvelocity.y;  //  https://www.openprocessing.org/sketch/67284#
		ballvelocity.y -= ballgravity.y;

		if (balllocation.y < 0) {
			ballvelocity.y = (float)(ballvelocity.y * -0.9);
			balllocation.y = 0;
		}
	}

    @Override
	public void show () {

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
		txtball.dispose();
	}

}
