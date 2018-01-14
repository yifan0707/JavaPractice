package designpattern.command;

public class TurnUpVolume implements Command {
    Television television;

    public TurnUpVolume(Television television){
        this.television=television;
    }

    @Override
    public void execute(){
        television.turnUpVolume();
    }
}
