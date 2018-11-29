package project.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprBall extends Sprite {

    Vector2 v2balllocation, v2ballvelocity, v2ballgravity;
    Texture txtball, txt;
    Sprite SprBall = new Sprite();
    int nX,nY,nW,nH;


    public SprBall(Texture _txt, int _nX, int _nY, int _nW, int _nH) {
        super(_txt);
        this.txt = _txt;
        txtball = new Texture("basketball.png");
        v2balllocation = new Vector2(190, 300);
        v2ballvelocity = new Vector2((float) 0.0, (float) 10.0);
        v2ballgravity = new Vector2(0, (float) -0.5);
        nX = _nX;
        nY = _nY;
        SprBall.setOrigin(nX, nY);
        nW = _nW;
        nH = _nH;
        SprBall.setSize(nW, nH);
    }

    public Vector2 update() {
        v2ballvelocity.add(v2ballgravity); //  https://www.openprocessing.org/sketch/67284#
        v2balllocation.add(v2ballvelocity);

        if (v2balllocation.y < 0) {
            v2ballvelocity.y = (float) (v2ballvelocity.y * -0.9);
            v2balllocation.y = 0;
        }
        return v2balllocation;
    }
}