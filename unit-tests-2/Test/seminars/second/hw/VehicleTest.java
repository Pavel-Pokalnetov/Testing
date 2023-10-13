package seminars.second.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VehicleTest {
    @Test
    public void testCar() {
        Car car = new Car("Автоваз", "ВАЗ21140", 2002);
        //проверка класса
        assertTrue(car instanceof Vehicle,"The object is not instance of Vehicle");

        //проверка количества колес
        assertEquals(4, car.getNumWheels(),"Error number Wheels");

        //проверка движения
        car.testDrive();
        assertEquals(60, car.getSpeed(),"Error of speed in testDrive()");

        //проверка парковки
        car.park();
        assertEquals(0, car.getSpeed(),"Error of speed in pakr()");
    }




    @Test
    public void testMotocycle() {
        Motorcycle motorcycle = new Motorcycle("ИЖМАШ", "ИЖ Юпитер-5", 1994);

        //проверка класса
        assertTrue(motorcycle instanceof Vehicle,"The object is not instance of Vehicle");

        //проверка количества колес
        assertEquals(2, motorcycle.getNumWheels(),"Error number Wheels");

        //проверка движения
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed(),"Error of speed in testDrive()");

        //проверка парковки
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed(),"Error of speed in pakr()");
    }
}