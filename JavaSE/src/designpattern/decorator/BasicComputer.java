package designpattern.decorator;

public class BasicComputer implements Computer {

    @Override
    public float getCost() {
        return 10;
    }

    @Override
    public String getComponents() {
        return "Computer case";
    }
}
