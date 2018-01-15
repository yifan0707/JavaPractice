package designpattern.bridge;

public abstract class Remote {
    EntertainmentDevice device;
    public Remote(EntertainmentDevice device){
        this.device=device;
    }

    public abstract void middleButtonPressed();

    public void buttonLeftPressed() {
        device.buttonLeftPressed();
    }

    public void buttonRightPressed() {
        device.buttonRightPressed();
    }

}
