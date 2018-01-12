package factory;

public class App {
    public static void main(String[] args){
        Drink coke=new Coke(500);
        Drink sprite=new Sprite(500);

        coke.outputDrinkInfo();
        coke.outputDrinkTaste();
        sprite.outputDrinkInfo();
        sprite.outputDrinkTaste();

        System.out.println("\n");

        AbstractFactory factory=new ConcreteFactory();
        Drink coke1=factory.createDrink(Coke.class);
        Drink sprite1=factory.createDrink(Sprite.class);
        coke1.outputDrinkInfo();
        coke1.outputDrinkTaste();
        sprite1.outputDrinkInfo();
        sprite1.outputDrinkTaste();

        System.out.println("\n");

        Drink coke2=StaticFactory.createDrink(Coke.class,100);
        Drink sprite2=StaticFactory.createDrink(Sprite.class,100);
        coke2.outputDrinkInfo();
        coke2.outputDrinkTaste();
        sprite2.outputDrinkInfo();
        sprite2.outputDrinkTaste();

        System.out.println("\n");

        Drink coke3=new CokeFactory().createDrink(100);
        Drink sprite3=new SpriteFactory().createDrink(100);
        coke3.outputDrinkInfo();
        coke3.outputDrinkTaste();
        sprite3.outputDrinkInfo();
        sprite3.outputDrinkTaste();

        System.out.println("\n");

        SingletonFactory.getInstance();

    }
}
