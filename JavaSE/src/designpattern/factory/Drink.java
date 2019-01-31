package factory;

public abstract class Drink {
    String name;
    int size;

    public Drink(String name,int size){
        this.name=name;
        this.size=size;
    }
    public void outputDrinkInfo(){
        System.out.println("The drink name is: "+name+" and the size is : "+size);
    }

    public abstract void outputDrinkTaste();
}
