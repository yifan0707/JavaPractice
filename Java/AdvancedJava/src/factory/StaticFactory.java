package factory;

import java.lang.reflect.InvocationTargetException;

public class StaticFactory {
    public static <T extends Drink> T createDrink(Class<T> clazz,int capacity){
        Drink drink=null;
        try{
            Class newClass=Class.forName(clazz.getName());
            drink=(Drink) newClass.getDeclaredConstructor(int.class)
                    .newInstance(capacity);
        }catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return (T)drink;
    }
}
