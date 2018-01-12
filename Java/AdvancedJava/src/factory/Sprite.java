package factory;

public class Sprite extends Drink {
    String taste;
    public Sprite(int size){
        super("Sprite",size);
        this.taste="Sweat Sprite taste";
    }

    @Override
    public void outputDrinkTaste(){
        System.out.println(name+"'s taste is "+taste);
    }
}