package designpattern.decorator;

public class CPU extends ComputerDecorator {
    public CPU(Computer computer){
        super(computer);
    }

    @Override
    public float getCost() {
        return super.getCost()+200;
    }

    @Override
    public String getComponents(){
        return super.getComponents()+", CPU";
    }
}
