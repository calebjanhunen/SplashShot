package project.splash;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class SprBall extends Sprite {

    Vector2 balllocation, ballvelocity, ballgravity;
    Texture txtball, txt;
    Sprite SprBall = new Sprite();


    public SprBall(Texture _txt, int _nX2, int _nY2, int _nW2, int _nH2) {
        this.txt = _txt;
        txtball = new Texture("basketball.png");
        balllocation = new Vector2(100, 100);
        ballvelocity = new Vector2((float)8.0,(float)10.0);
        ballgravity = new Vector2(0,(float) 0.5);
        SprBall.setOrigin(_nX2, _nY2 );
        SprBall.setSize(_nW2, _nH2);
    }

    public float update(){
        balllocation.y += ballvelocity.y;  //  https://www.openprocessing.org/sketch/67284#
        ballvelocity.y -= ballgravity.y;

        if (balllocation.y < 0) {
            ballvelocity.y = (float)(ballvelocity.y * -0.9);
            balllocation.y = 0;
        }

        return balllocation.y;
    }

}