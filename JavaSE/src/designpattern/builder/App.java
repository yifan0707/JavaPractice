package designpattern.builder;

/**
 * Builder Design Pattern is used in the situation that one object is heavily
 * made of bunch of other objects
 * Situation that would require this design pattern
 * 1. When the object is made from other objects
 * 2. When the creation of other objects is independent from the main object
 * 3. When the Hide the creation parts from the client so both aren't dependent
 * 4. Only Builder knows the specifics of the Construction of the Robot , nobodyelse
 * dose
 */
public class App {
    public static void main(String[] args){
        RobotBuilder robotBuilder=new OldRobotBuilder();
        RobotDirector robotDirector=new RobotDirector(robotBuilder);

        robotDirector.makeRobot();
        Robot robot=robotDirector.getRobot();

        System.out.println(robot.getRobotHead());

        System.out.println(robot.getRobotTorso());

        System.out.println(robot.getRobotArms());

        System.out.println(robot.getRobotLegs());
    }
}
