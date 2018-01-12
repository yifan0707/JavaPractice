package factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {
    private Singleton(){
        System.out.println("Singleton constructor called, instance created");
    }

}

class SingletonFactory{
    private static Singleton instance;

    public static Singleton getInstance(){
        try {
            Class singleton;
            singleton = Class.forName(Singleton.class.getName());
            Constructor constructor=singleton.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            instance=(Singleton)constructor.newInstance(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
