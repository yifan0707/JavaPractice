package factory;

public abstract class MultiFactory {
    public abstract Drink createDrink(int capacity);
}

class CokeFactory extends MultiFactory{
    @Override
    public Drink  createDrink(int capacity){
        return new Coke(capacity);
    }
}

class SpriteFactory extends MultiFactory{
    @Override
    public Drink  createDrink(int capacity){
        return new Sprite(capacity);
    }
}


