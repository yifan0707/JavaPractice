public final class SpecialEnemy extends Enemy {
    private double damage;

    public SpecialEnemy(){
        super();
        System.out.println("This is the DEFAULT constructor of the SpecialEnemy class");
    }

    public SpecialEnemy(int health,String name,double damage){
        super(health,name);
        System.out.println("This is the alternative constructor of the SpecialEnemy class");
    }

    public void setDamage(double damage){
        this.damage=damage;
    }

    public double getDamage(){
        return damage;
    }

    private void levelUp(){
        damage*=2;
        System.out.println("levelUp + 1");
    }

    private void levelUp(int number){
        damage*=number;
        System.out.println("levelUp + "+number);
    }

}
