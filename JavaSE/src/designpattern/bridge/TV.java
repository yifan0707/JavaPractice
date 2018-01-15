package designpattern.bridge;

public class TV extends EntertainmentDevice {

    public TV(){
        super();
    }

    @Override
    public void buttonLeftPressed() {
        state++;
    }

    @Override
    public void buttonRightPressed() {
        state--;
    }
}
