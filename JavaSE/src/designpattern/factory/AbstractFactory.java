package factory;

public abstract class AbstractFactory {
    public abstract <T extends Drink> T  createDrink(Class<T> clazz);
}
