package designpattern.decorator;

public class GPU extends ComputerDecorator{
    public GPU(Computer computer){
        super(computer);
    }

    @Override
    public float getCost(){
        return super.getCost()+2000;
    }

    @Override
    public String getComponents(){
        return super.getComponents()+", GPU added";
    }
}
