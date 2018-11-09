package project.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprBall extends Sprite {

    Vector2 v2balllocation, v2ballvelocity, v2ballgravity;
    Texture txtball, txt;
    Sprite SprBall = new Sprite();
    int width, height;


    public SprBall(Texture _txt, int _nX, int _nY, int _nW, int _nH) {
        super(_txt);
        this.txt = _txt;
        txtball = new Texture("basketball.png");
        v2balllocation = new Vector2(300, 500);
        v2ballvelocity = new Vector2((float) 8.0, (float) 10.0);
        v2ballgravity = new Vector2(0, (float) 0.5);
        SprBall.setOrigin(_nX, _nY);
        width = _nW;
        height = _nH;
        SprBall.setSize(width, height);
    }

    public Vector2 update() {
        v2balllocation.y += v2ballvelocity.y;  //  https://www.openprocessing.org/sketch/67284#
        v2ballvelocity.y -= v2ballgravity.y;

        if (v2balllocation.y < 0) {
            v2ballvelocity.y = (float) (v2ballvelocity.y * -0.9);
            v2balllocation.y = 0;
        }
        return v2balllocation;
    }

}