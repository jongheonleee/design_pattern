package patterns.factoryMethod.practice.phone;

import patterns.factoryMethod.practice.framework.Device;

public class Phone extends Device {

    @Override
    public void turnOn() {
        System.out.println(" Phone : hihihihhi");
    }

    @Override
    public void turnOff() {
        System.out.println(" Phone : oh no!!");
    }

    @Override
    public String toString() {
        return "phone";
    }
}
