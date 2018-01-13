package designpattern.builder;

/**
 * This class will work as the engineer building the object
 * To do that it will require an RobotBuilder instance so that it can call all
 * method from it to use it. And finally return the finished the object.
 */
public class RobotDirector {
    private RobotBuilder robotBuilder;

    public RobotDirector(RobotBuilder robotBuilder){
        this.robotBuilder=robotBuilder;
    }

    public void makeRobot(){
        robotBuilder.buildRobotArms();
        robotBuilder.buildRobotHead();
        robotBuilder.buildRobotLegs();
        robotBuilder.buildRobotTorso();
    }

    public Robot getRobot(){
        return this.robotBuilder.getRobot();
    }
}
