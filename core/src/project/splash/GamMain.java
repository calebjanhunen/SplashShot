package project.splash;

import com.badlogic.gdx.Game;

public class GamMain extends Game {

    @Override
    public void create() {
        this.setScreen(new ScrPlay(this));
    }

    @Override
    public void render() {
        super.render();
    }
}