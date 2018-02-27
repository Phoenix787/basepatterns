package com.example.basepatterns.structural.bridge.example;

import com.example.basepatterns.structural.bridge.example.devices.Device;
import com.example.basepatterns.structural.bridge.example.devices.Radio;
import com.example.basepatterns.structural.bridge.example.devices.Tv;
import com.example.basepatterns.structural.bridge.example.remotes.AdvancedRemote;
import com.example.basepatterns.structural.bridge.example.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    private static void testDevice(Device device) {
        System.out.println("Test with basic remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.channelUp();
        basicRemote.volumeUp();
        device.printStatus();

        System.out.println("Test with advanced remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
