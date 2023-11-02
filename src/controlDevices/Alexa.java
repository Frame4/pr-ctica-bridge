package controlDevices;

import devices.Device;

import javax.swing.*;
import java.awt.*;

public class Alexa extends Control {
    public Alexa(Device device){
        super(device);
    }

    @Override
    void image() {
        System.out.println("Alexa! Set this image");
    }

    @Override
    void incVolume() {
        System.out.println("Alexa! Increase volume");
    }

    @Override
    void decVolume() {
        System.out.println("Alexa! Decrease volume");
    }
}
