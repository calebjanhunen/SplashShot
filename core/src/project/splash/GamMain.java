package project.splash;

import com.badlogic.gdx.Game;
import project.splash.Screens.ScrPlay;

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
