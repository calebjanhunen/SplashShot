package project.splash;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class RandomXCoordinate {

    private int nranX1, nranX2;
    Random r = new Random();

    public RandomXCoordinate(){
        nranX1 = r.nextInt(Gdx.graphics.getWidth() - 250); // random x coordinate for first net
        nranX2 = r.nextInt(Gdx.graphics.getWidth() - 250); // random x coordinate for second net
        while (Math.abs(nranX1 - nranX2) <= 250){
            nranX1 = r.nextInt(Gdx.graphics.getWidth() - 250); // random x coordinate for first net
            nranX2 = r.nextInt(Gdx.graphics.getWidth() - 250); // random x coordinate for second net

        }
    }

    public int getNranX1(){
        return nranX1;
    }

    public int getNranX2(){
        return nranX2;
    }
}
