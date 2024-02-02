package test.factoryMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.factoryMethod.practice.computer.Computer;
import patterns.factoryMethod.practice.computer.ComputerFactory;
import patterns.factoryMethod.practice.framework.Device;
import patterns.factoryMethod.practice.framework.Factory;
import patterns.factoryMethod.practice.phone.Phone;
import patterns.factoryMethod.practice.phone.PhoneFactory;
import patterns.factoryMethod.practice.tv.Tv;
import patterns.factoryMethod.practice.tv.TvFactory;

public class FactoryMethodTest {


    Factory factory;
    Device device;
    @BeforeEach
    void setUp() {
        factory = null;
        device = null;
    }

    @Test
    @DisplayName("적용 - Computer 생성 테스트")
    void test1() {
        factory = new ComputerFactory();
        device = factory.create();
        assertEquals(Computer.class, device.getClass());

    }

    @Test
    @DisplayName("적용 - Tv 생성 테스트")
    void test2() {
        factory = new TvFactory();
        device = factory.create();
        assertEquals(Tv.class, device.getClass());

    }

    @Test
    @DisplayName("적용 - Phone 생성 테스트")
    void test3() {
        factory = new PhoneFactory();
        device = factory.create();
        assertEquals(Phone.class, device.getClass());

    }

}
