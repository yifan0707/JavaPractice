package factory;

import java.lang.reflect.InvocationTargetException;

public class ConcreteFactory extends AbstractFactory{
    @Override
    public <T extends Drink> T createDrink(Class<T> clazz){
        Drink drink=null;
        try{
            Class newClass=Class.forName(clazz.getName());
            drink=(Drink) newClass.getDeclaredConstructor(int.class)
                    .newInstance(300);
        }catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException |
                InvocationTargetException   e) {
            e.printStackTrace();
        }

        return (T)drink;
    }
}
