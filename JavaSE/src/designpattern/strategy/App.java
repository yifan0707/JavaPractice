package designpattern.strategy;

/**
 * In this section strategy design pattern have been adapted
 * Due to the fact that all various kinds of vehicles have the same action
 * called "Refuel" . However, they perform the action differently according
 * to their vehicle type.
 *
 * Option 1:
 * We can declare a standard public method in the Car class and all other
 * classes that performs differently need to override the original method
 *
 * Option2:
 * We can declare the "Refuel" class as an abstract class. And all sub classes
 * of Car class need to write their own unique implementation
 *
 * Option3:
 * We use strategy design pattern so that we can change the algorithm at
 * the runtime.
 *
 * In option1&2, situation of writing duplicate code can occurs frequently
 * which is not good for maintaining and manipulating the code.
 *
 * In option3, a family of different functionality implementation is created
 * which is easy to maintain and makes the algorithm interchangeable within
 * the family.
 */
public class App {
    public static void main(String[] args){
        Car car1=new CompactCar();
        Car car2=new ElectricVehicle();
        Car car3=new Truck();

        car1.refuel();
        car2.refuel();
        car3.refuel();
    }
}
