package project.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SprNet extends Sprite {
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    String sNet;
    Sprite arSprNet[] = new Sprite[10];
//    Polygon polyNets[] = new Polygon[10];
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
        }
//        setPolyNets();

    }

//    public void setPolyNets() {
//        polyNets[0] = new Polygon(new float[]{100,160,220,160,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,165,50,165,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,160});
//        polyNets[1] = new Polygon(new float[]{100,150,220,150,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,155,50,155,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,150});
//        polyNets[2] = new Polygon(new float[]{100,145,220,145,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,150,50,150,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,145});
//        polyNets[3] = new Polygon(new float[]{100,135,220,135,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,140,50,140,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,135});
//        polyNets[4] = new Polygon(new float[]{100,130,220,130,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,135,50,135,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,130});
//        polyNets[5] = new Polygon(new float[]{100,121,220,121,sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),200,127,50,127,sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight(),30,121});
//        polyNets[6] = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight()});
//        polyNets[7] = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight()});
//        polyNets[8] = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight()});
//        polyNets[9] = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight()});
//        polyNets[10] = new Polygon(new float[]{sprNet1.getX(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(),sprNet1.getY(),sprNet1.getX() + sprCurNet.getWidth(), sprNet1.getY() + sprCurNet.getHeight(),sprNet1.getX(),sprNet1.getY() + sprCurNet.getHeight()});
//
//    }

    public Sprite update(int _index, int _nW, int _nH) {
        nW = _nW;
        nH = _nH;
        index = _index;
        return arSprNet[index];
    }
}