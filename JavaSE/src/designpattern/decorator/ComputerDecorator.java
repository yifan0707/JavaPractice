package designpattern.decorator;

public abstract class ComputerDecorator implements Computer{
    protected Computer computer;

    public ComputerDecorator(Computer computer){
        this.computer=computer;
    }

    @Override
    public float getCost() {
        return computer.getCost();
    }

    @Override
    public String getComponents(){
        return computer.getComponents();
    }
}
