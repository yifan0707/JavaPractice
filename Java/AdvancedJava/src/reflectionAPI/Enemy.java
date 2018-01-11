package reflectionAPI;

public class Enemy {
    protected int health;
    protected String name;

    public Enemy(){
        this.health=0;
        this.name="";
        System.out.println("This is DEFAULT constructor of the reflectionAPI.Enemy class");
    }

    public Enemy(int health,String name){
        this.health=health;
        this.name=name;
        System.out.println("This is the alternative constructor of the reflectionAPI.Enemy class");
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return name;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public void setName(String name){
        this.name=name;
    }
}
