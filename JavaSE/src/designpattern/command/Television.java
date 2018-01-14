package designpattern.command;

public class Television {
    int volume;
    String name;
    boolean isTurnedOn;
    public Television(String name){
        volume=10;
        this.name=name;
    }

    public void turnOnTV(){
        isTurnedOn=true;
    }

    public void turnOffTV(){
        isTurnedOn=false;
    }

    public void turnUpVolume(){
        volume++;
    }

    public void turnDownVolume(){
        volume--;
    }

    public int getVolume(){
        return volume;
    }

    public String getName(){
        return  name;
    }

    public boolean getIsTurnedOn(){
        return isTurnedOn;
    }

}
