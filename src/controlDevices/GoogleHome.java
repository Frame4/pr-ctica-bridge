package controlDevices;

import devices.Device;

import javax.swing.*;

public class GoogleHome extends Control {
    public GoogleHome(Device device){
        super(device);
    }

    @Override
    void image() {
        System.out.println("Hey google! Set this image");
    }

    @Override
    void incVolume() {
        System.out.println("Hey google! Increase volume");
    }

    @Override
    void decVolume() {
        System.out.println("Hey google! Decrease volume");
    }

}
