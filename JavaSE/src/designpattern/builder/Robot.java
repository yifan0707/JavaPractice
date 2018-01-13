package designpattern.builder;

/**
 * this class will only have set and get method for all components and
 * the builder class will actually build all parts and use set method from
 * this class to pass in and stores the values
 */
public class Robot implements RobotPlan {
    private String robotHead;
    private String robotTorso;
    private String robotArms;
    private String robotLegs;

    @Override
    public void setRobotHead(String head) {
        this.robotHead=head;
    }

    @Override
    public void setRobotTorso(String torso) {
        this.robotTorso=torso;
    }

    @Override
    public void setRobotArms(String arms) {
        this.robotArms=arms;
    }

    @Override
    public void setRobotLegs(String legs) {
        this.robotLegs=legs;
    }

    public String getRobotHead(){
        return  robotHead;
    }

    public String getRobotTorso(){
        return  robotTorso;
    }

    public String getRobotArms(){
        return  robotArms;
    }

    public String getRobotLegs(){
        return  robotLegs;
    }
}
