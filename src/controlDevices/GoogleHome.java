package controlDevices;

import devices.Device;

import javax.swing.*;
import java.awt.*;

public class Smartphone extends Control {
    public String getControlDeviceName(){
        return "Smartphone";
    }

    public Smartphone(Device device){
        super(device);
    }

    @Override
    void setImage(ImageIcon image) {
        device.setImage(image);
    }
}
