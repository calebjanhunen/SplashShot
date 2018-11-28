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
    int index;
    int nW, nH, nX, nY;
    public SprNet(int _nX, int _nY, int _nW, int _nH) { //create an array of polygon nets (hard coded) to cover the bottom half of the net
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
    }

    public Sprite update(int _index, int _nW, int _nH) {
        nW = _nW;
        nH = _nH;
        index = _index;
        return arSprNet[index];
    }
}