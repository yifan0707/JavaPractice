package factory;

public class Coke extends Drink {
    String taste;
    public Coke(int size){
        super("Coke",size);
        this.taste="Sweat coke taste";
    }

    @Override
    public void outputDrinkTaste(){
        System.out.println(name+"'s taste is "+taste);
    }
}
