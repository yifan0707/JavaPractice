package designpattern.bridge;

/**
 * Decouple an abstraction from its implementation so that two can vary
 * independently
 *
 * Not really sure about this design pattern
 */
public class App {
    public static void main(String[] args){
        Remote pauseRemote=new PauseRemote(new TV());
        Remote muteRemote=new MuteRemote(new TV());

        pauseRemote.buttonLeftPressed();
        pauseRemote.buttonLeftPressed();


        muteRemote.buttonRightPressed();
        muteRemote.buttonRightPressed();
    }
}
