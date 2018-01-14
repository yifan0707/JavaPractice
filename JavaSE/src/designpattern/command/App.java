package designpattern.command;

/**
 * The command design pattern is mainly used to encapsulate all behavioral
 * Information needed to perform an action or trigger an event at later time.
 *
 * This design pattern stores commands as classes' instance so that it is easy
 *  to redo and store all the progress information
 *
 *  Thus command design pattern is mainly used in the situation of progress
 *  management , Multi-level undo, Wizards, Progress bars, Thread pools
 *
 * Command design components:
 * 1. Receiver
 * 2. Invoker
 * 3. Command
 */
public class App {
    public static void main(String[] args){
        Remote remote=new Remote();
        Television tv=new Television("GeLi");
        Command turnOn=new TurnOn(tv);
        Command turnOff=new TurnOff(tv);
        Command turnUpVolume=new TurnUpVolume(tv);
        Command turnDownVolume=new TurnDownVolume(tv);

        remote.invoke(turnOn);
        System.out.println("Is tv turned on: "+tv.getIsTurnedOn());
        remote.invoke(turnOff);
        System.out.println("Is tv turned on: "+tv.getIsTurnedOn());

        remote.invoke(turnUpVolume);
        remote.invoke(turnUpVolume);
        remote.invoke(turnUpVolume);
        System.out.println("Is tv turned on: "+tv.getVolume());
        remote.invoke(turnDownVolume);
        System.out.println("Is tv turned on: "+tv.getVolume());

    }
}
