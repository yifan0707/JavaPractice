package designpattern.command;

public class TurnOn implements Command {
    Television television;

    public TurnOn(Television television){
        this.television=television;
    }

    @Override
    public void execute(){
        television.turnOnTV();
    }
}


