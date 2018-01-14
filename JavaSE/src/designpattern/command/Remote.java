package designpattern.command;

public class Remote {
    public Remote(){
    }

    public void invoke(Command command){
        command.execute();
    }
}
