package patterns.factoryMethod.practice.computer;

import patterns.factoryMethod.implement.framework.Product;
import patterns.factoryMethod.practice.framework.Device;
import patterns.factoryMethod.practice.framework.Factory;

public class ComputerFactory extends Factory {

    @Override
    protected Device createDevice() {
        return new Computer();
    }

    @Override
    protected void checkDevice(Device device) {
        // 0. 키고 꺼보기
        device.turnOn();
        device.turnOff();
        // 1. 결과 반환
        System.out.println("success!!");

    }

    @Override
    protected void registerDevice(Device device) {
        System.out.println(device + " registered!!");
    }
}
