package project.splash.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.splash.GamMain;


public class ScrMenu implements Screen, InputProcessor {

    SpriteBatch batch;
    Texture txtbackground;
    Input.Buttons btnPlay, btnInfo;
    GamMain game;

    public ScrMenu(GamMain game) {
        this.game = game;
        batch = new SpriteBatch();
        txtbackground = new Texture("menuscreen.png");
        btnPlay = new Buttons(175, 400, 250, 250, "playbutton.png");
        btnInfo = new Buttons(30, 200, 180, 180, "infobutton.png");
    }

    @Override
    public void show() {
        return;
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(txtbackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        btnPlay.draw(batch);
        btnInfo.draw(batch);
        HandleButtons();
        batch.end();

    }

    public void HandleButtons() {
        if (Gdx.input.isTouched()) {                          //Learning how to switch screens: https://github.com/weihanli101/Cygnus-Strike/blob/MasterWithMenu/core/src/com/mygdx/game/MyGame.java
            if (btnPlay.isMousedOver()) {
                game.setScreen(new ScrPlay(game));
            }
        }
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