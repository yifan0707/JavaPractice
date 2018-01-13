package designpattern.builder;

/**
 * interface of the ROBOT
 */
public interface RobotPlan {
    public void setRobotHead(String head);
    public void setRobotTorso(String torso);
    public void setRobotArms(String arms);
    public void setRobotLegs(String legs);
}
