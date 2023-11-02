package devices;

import javax.swing.*;

public class Laptop extends Device {
    @Override
    public void setVolume(int n) {
        volume+=n;
    }

    @Override
    public void setImage(ImageIcon image) {

    }

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public int getVolume() {
        return volume;
    }
}
