package project.splash;

import com.badlogic.gdx.Game;
import project.splash.Screens.ScrMenu;

public class GamMain extends Game {

    @Override
    public void create() {
        this.setScreen(new ScrMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }
}

