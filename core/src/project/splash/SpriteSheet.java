package project.splash;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet extends Sprite {
    int width, height;
    TextureRegion textureRegion;

    public SpriteSheet (TextureRegion textureRegion, int x, int y, int width, int height){
        setPosition(x, y);
        this.width = width;
        this.height = height;
        this.textureRegion = textureRegion;
    }

}
