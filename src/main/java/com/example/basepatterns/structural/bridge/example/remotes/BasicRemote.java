package com.example.basepatterns.structural.bridge.example.remotes;

import com.example.basepatterns.structural.bridge.example.devices.Device;

public class BasicRemote implements Remote {
    protected Device device; //делегирование реализации в абстракцию

    public BasicRemote() {
    }

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Power: toggle");
        if (!device.isEnabled()) {
            device.enable();
        } else device.disable();
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: volume up");
        device.setVolume(device.getVolume() + 10);

    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: channel up");
        device.setChannel(device.getChannel() + 1);

    }

    @Override
    public void channelDown() {
        System.out.println("Remote: channel down");
        device.setChannel(device.getChannel() - 1);

    }
}
