package designpattern.prototype;

public class PenFactory {
    public Pen makeCopy(Pen prototype){
        return prototype.clone();
    }
}
