package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

public class SprNet extends Sprite {
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    String sNet;
    Sprite arSprNet[] = new Sprite[10];
    Polygon polyNets[] = new Polygon[10];
    int index;
    int nW, nH, nX, nY;

    public SprNet(int _nX, int _nY, int _nW, int _nH) {
        super(new Texture(Gdx.files.internal("NetSpriteSheet.png")));
        for (int i = 0; i < 10; i++) {
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite(textureRegion);
            nW = _nW;
            nH = _nH;
            arSprNet[i].setSize(nW, nW);
            arSprNet[i].setOrigin(arSprNet[i].getWidth()/2, arSprNet[i].getHeight());
            nX = _nX;
            nY = _nY;
            arSprNet[i].setPosition(nX, nY);
//            System.out.println(i);
        }
        setPolyNets();

    }

    public void setPolyNets() {
        if (arSprNet[0]) {
            polyNets[0] = new Polygon(new float[]{100, 160, 220, 160, 250, 250, 200, 165, 50, 165, 0, 250, 30, 160});
        }
        else if (arSprNet[1]) {
            polyNets[1] = new Polygon(new float[]{100, 150, 220, 150, 250, 250, 200, 155, 50, 155, 0, 250, 30, 150});
        }
        else if (arSprNet[2]) {
            polyNets[2] = new Polygon(new float[]{100, 145, 220, 145, 250, 250, 200, 150, 50, 150, 0, 250, 30, 145});
        }
        else if (arSprNet[3]) {
            polyNets[3] = new Polygon(new float[]{100, 135, 220, 135, 250, 250, 200, 140, 50, 140, 0, 250, 30, 135});
        }
        else if (arSprNet[4]) {
            polyNets[4] = new Polygon(new float[]{100, 130, 220, 130, 250, 250, 200, 135, 50, 135, 0, 250, 30, 130});
        }
        else if (arSprNet[5]) {
            polyNets[5] = new Polygon(new float[]{100, 121, 220, 121, 250, 250, 200, 127, 50, 127, 0, 250, 30, 121});
        }
        else if (arSprNet[6]) {
            polyNets[6] = new Polygon(new float[]{100, 116, 220, 116, 250, 250, 200, 121, 50, 121, 0, 250, 30, 116});
        }
        else if (arSprNet[7]) {
            polyNets[7] = new Polygon(new float[]{100, 110, 220, 110, 250, 250, 200, 115, 50, 115, 0, 250, 30, 110});
        }
        else if (arSprNet[8]) {
            polyNets[8] = new Polygon(new float[]{100, 104, 220, 104, 250, 250, 200, 109, 50, 109, 0, 250, 30, 104});
        }
        else if (arSprNet[9]) {
            polyNets[9] = new Polygon(new float[]{100, 97, 220, 97, 250, 250, 200, 102, 50, 102, 0, 250, 30, 97});
        }
        else if (arSprNet[10]) {
            polyNets[10] = new Polygon(new float[]{100, 92, 220, 92, 250, 250, 200, 97, 50, 97, 0, 250, 30, 92});
        }

//    polyNets = new Polygon(new float[]{100,92,220,92,250,250,200,97,50,97,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,92});
    }

    public Sprite update(int _index, int _nW, int _nH) {
        nW = _nW;
        nH = _nH;
        index = _index;
        return arSprNet[index];
    }
}