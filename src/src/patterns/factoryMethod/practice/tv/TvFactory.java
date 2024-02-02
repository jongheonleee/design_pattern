package patterns.factoryMethod.practice.tv;

import patterns.factoryMethod.practice.framework.Device;
import patterns.factoryMethod.practice.framework.Factory;

public class TvFactory extends Factory {

    @Override
    protected Device createDevice() {
        return new Tv();
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
