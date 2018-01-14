package designpattern.command;

public class TurnDownVolume implements  Command{
    Television television;

    public TurnDownVolume(Television television){
        this.television=television;
    }

    @Override
    public void execute(){
        television.turnDownVolume();
    }
}
