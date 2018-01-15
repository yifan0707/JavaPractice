package designpattern.bridge;

public class PauseRemote extends Remote {

    public PauseRemote(EntertainmentDevice device){
        super(device);
    }

    @Override
    public void middleButtonPressed() {
        System.out.println("The device is muted");
    }
}
