package project.splash;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SpriteSheet extends Sprite {
    String name;
    TextureAtlas textureAtlas;

    public SpriteSheet (String name, int x, int y, int width, int height){
        setPosition(x, y);
        setSize(width, height);
        this.name = name;

    }

}
