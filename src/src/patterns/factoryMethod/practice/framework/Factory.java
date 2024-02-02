package patterns.factoryMethod.practice.framework;

import patterns.factoryMethod.practice.framework.Device;

public abstract class Factory {
    public final Device create() {
        // 0. create
        Device device = createDevice();
        // 1. check
        checkDevice(device);
        // 2. register
        registerDevice(device);
        return device;
    }

    protected abstract Device createDevice();
    protected abstract void checkDevice(Device device);
    protected abstract void registerDevice(Device device);
}
