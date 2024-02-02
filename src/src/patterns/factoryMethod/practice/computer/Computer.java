package patterns.factoryMethod.practice.computer;

import patterns.factoryMethod.practice.framework.Device;

public class Computer extends Device {

    @Override
    public void turnOn() {
        System.out.println("티비 : 띠리링... 웰컴");
    }

    @Override
    public void turnOff() {
        System.out.println("티비 : 뚜둥,,, 굿바이");
    }

    @Override
    public String toString() {
        return "computer";
    }
}
