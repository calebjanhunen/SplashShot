package project.splash;

import java.awt.image.BufferedImage;

public class basketballNet {
    BufferedImage image;

    public basketballNet (BufferedImage image){
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage basketballNet = image.getSubimage((col-1)*154, (row-1)*154, width, height);
        return basketballNet;
    }
}
