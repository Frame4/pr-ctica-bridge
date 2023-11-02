package devices;

import javax.swing.*;

public abstract class Device {
    protected int volume=50;
    protected ImageIcon image;

    public abstract void setVolume(int n);
    public abstract void setImage(ImageIcon image);
    public abstract ImageIcon getImage();
    public abstract int getVolume();


}
