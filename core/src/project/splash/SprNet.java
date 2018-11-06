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

    public SprNet(int _nX, int _nY, int _nW, int _nH) {
        super(new Texture(Gdx.files.internal("NetSpriteSheet.png")));
        for (int i = 0; i < 10; i++) {
            textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/NetSpriteSheet.atlas"));
            sNet = "Net" + (i + 1);
            textureRegion = textureAtlas.findRegion(sNet);
            arSprNet[i] = new Sprite(textureRegion);
            arSprNet[i].setSize(_nW, _nH);
            arSprNet[i].setOrigin(arSprNet[i].getWidth()/2, arSprNet[i].getHeight());
            arSprNet[i].setPosition(_nX, _nY);

        }
    }

    public Sprite update(int _index) {
        index = _index;
        return arSprNet[index];
    }
}