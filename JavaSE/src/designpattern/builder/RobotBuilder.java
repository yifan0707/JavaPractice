package designpattern.builder;

/**
 * this is the interface that will build the robot
 */
public interface RobotBuilder {
    public void buildRobotHead();
    public void buildRobotTorso();
    public void buildRobotArms();
    public void buildRobotLegs();
    public Robot getRobot();
}
