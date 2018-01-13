package designpattern.builder;

/**
 * This class will focusing on building the actual components of the classes
 * Meanwhile this will require an instance of the robot as target
 */
public class OldRobotBuilder implements  RobotBuilder{
    private Robot robot;

    public OldRobotBuilder(){
        this.robot=new Robot();
    }

    public Robot getRobot(){
        return robot;
    }

    @Override
    public void buildRobotHead() {
        this.robot.setRobotHead("EVA's head");
    }

    @Override
    public void buildRobotTorso() {
        this.robot.setRobotTorso("EVA's torso");
    }

    @Override
    public void buildRobotArms() {
        this.robot.setRobotArms("EVA's arms");
    }

    @Override
    public void buildRobotLegs() {
        this.robot.setRobotLegs("EVA's legs");
    }
}
