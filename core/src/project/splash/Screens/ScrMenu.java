package project.splash.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gdx.game.Buttons;
import project.splash.GamMain;


public class ScrMenu implements Screen, InputProcessor {

    SpriteBatch batch;
    Texture txtbackground;
    Buttons btnPlay;
    GamMain game;

    public ScrMenu(GamMain game) {
        this.game = game;
        batch = new SpriteBatch();
        txtbackground = new Texture("menu.png");
        btnPlay = new Buttons(150, 500, 300, 100, "playbutton.png");
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
        HandleButtons();
        batch.end();

    }

    public void HandleButtons() {
        if (Gdx.input.isTouched()) {             //Learning how to switch screens: https://github.com/weihanli101/Cygnus-Strike/blob/MasterWithMenu/core/src/com/mygdx/game/MyGame.java
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
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }
}