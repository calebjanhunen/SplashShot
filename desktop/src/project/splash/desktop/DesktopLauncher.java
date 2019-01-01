package project.splash.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import project.splash.GamMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GamMain(), config);
		config.title = "Splash Shot";
		config.height = 1000;
		config.width = 600;
		new LwjglApplication(new GamMain(), config);
	}
}
