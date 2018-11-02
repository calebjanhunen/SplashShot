package project.splash;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprBall extends Sprite {

    Vector2 balllocation, ballvelocity, ballgravity;

    public SprBall(int _nX2, int _nY2) {
        balllocation = new Vector2(300,300);
        ballvelocity = new Vector2((float)8.0,(float)10.0);
        ballgravity = new Vector2(0,(float) 0.5);

        balllocation.y += ballvelocity.y;  //  https://www.openprocessing.org/sketch/67284#
        ballvelocity.y -= ballgravity.y;

        if (balllocation.y < 0) {
            ballvelocity.y = (float)(ballvelocity.y * -0.9);
            balllocation.y = 0;
        }
    }
}