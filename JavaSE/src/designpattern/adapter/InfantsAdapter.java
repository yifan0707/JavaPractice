package designpattern.adapter;

public class InfantsAdapter implements GrownUps{
    private Infants infants;
    public InfantsAdapter(Infants infants){
        this.infants=infants;
    }
    @Override
    public void humanWalk() {
        infants.infantsCrow();
    }

    @Override
    public void humanEat() {
        infants.infantsEat();
    }

    @Override
    public void humanPlay() {
        infants.infantsPlay();
    }
}
