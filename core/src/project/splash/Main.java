package project.splash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture txtball;
	Sprite sprBall;
	int nBallX = 100, nBallY = 200, nBallWidth = 100, nBallHeight = 100, nCountJump = 0;
	double dGravity = 0.5, dFallSpeed = 0, dJumpSpeed = 20;
	boolean bCanFall = true, bCanJump = true;

	@Override
	public void create () {
		batch = new SpriteBatch();
		txtball = new Texture("basketball.png");
		sprBall = new Sprite(txtball);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(txtball, nBallX, nBallY, nBallWidth, nBallHeight); //ball
		batch.end();
		HandleJumping();
		HandleFalling();
	}

	public void HandleJumping() {
		if (bCanJump) {
			nCountJump++;
			nBallY += dJumpSpeed;
			dJumpSpeed -= dGravity;

			if (nCountJump >= 40) {
				bCanJump = false;
				bCanFall = true;
				dJumpSpeed = 20;
				nCountJump = 0;
			}
		}
	}

	public void HandleFalling() {
		if (bCanFall) {
			nBallY -= dFallSpeed;
			dFallSpeed += dGravity;
		}
		if (nBallY <= 100) {
			bCanJump = true;
			bCanFall = false;
     		dFallSpeed = 0;
		}

//		if (nBallY > 100) {    //trying to create energy loss in the ball everytime it touches ground
//			dFallSpeed *= -1;
//		} else dFallSpeed += dGravity;
	}


	@Override
	public void dispose () {
		batch.dispose();
		txtball.dispose();
	}
}
