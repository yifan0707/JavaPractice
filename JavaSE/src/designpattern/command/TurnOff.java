package designpattern.command;

public class TurnOff implements Command {
    Television television;

    public TurnOff(Television television){
        this.television=television;
    }

    @Override
    public void execute(){
        television.turnOffTV();
    }
}
