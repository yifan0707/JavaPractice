package designpattern.bridge;

public class MuteRemote extends Remote {
    public MuteRemote(EntertainmentDevice device) {
        super(device);
    }

    @Override
    public void middleButtonPressed() {
        System.out.println("The device is muted");
    }
}
