package project.splash.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import project.splash.Screens.ScrPlay;

public class SprNet extends Sprite {
    TextureAtlas textureAtlas;
    TextureRegion textureRegion;
    String sNet;
    Sprite arSprNet[] = new Sprite[10], sprNet, sprCurNet;
    int index;
    int nW, nH, nX, nY, iSpr;
    ScrPlay play;

    public SprNet(ScrPlay _play, int _nX, int _nY, int _nW, int _nH) {
        super(new Texture(Gdx.files.internal("NetSpriteSheet.png")));
        for (int i = 0; i < 10; i++) {
            textureAtlas = new TextureAtlas(Gdx.files.internal("NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite(textureRegion);
            nW = _nW;
            nH = _nH;
            arSprNet[i].setSize(nW, nW);
            arSprNet[i].setOrigin(arSprNet[i].getWidth() / 2, arSprNet[i].getHeight());
            nX = _nX;
            nY = _nY;
            arSprNet[i].setPosition(nX, nY);
        }

    }

    public void render(SpriteBatch batch){
    }

    public Sprite update(int _index, int _nW, int _nH) {
        nW = _nW;
        nH = _nH;
        index = _index;
        return arSprNet[index];
    }
}