package designpattern.bridge;

public abstract class EntertainmentDevice {
    protected int volume;
    protected int state;

    public EntertainmentDevice(){
        volume=10;
        state=1;
    }

    public abstract void buttonLeftPressed();
    public abstract void buttonRightPressed();

    public void buttonUpPressed(){
        volume++;
    }

    public void buttonDownPressed(){
        volume--;
    }
}
