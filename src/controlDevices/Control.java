package controlDevices;

import devices.Device;

import javax.swing.*;
import java.awt.*;

public abstract class Control {
    protected Device device;

    protected Control(Device device){
        this.device = device;
    }

    abstract void image();
    abstract void incVolume();
    abstract void decVolume();

    public void volumeUp(){
        device.setVolume(1);
        incVolume();
    }
    public void volumeDown(){
        device.setVolume(-1);
        decVolume();
    }
    public int getVolume(){
        return device.getVolume();
    }
    public void setImage(ImageIcon image){
        device.setImage(image);
        image();
    }

}
