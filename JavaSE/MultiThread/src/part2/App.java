package part2;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Processor p1=new Processor();
        p1.start();
        System.out.println("Press enter to stop");
        Scanner scanner = new Scanner (System.in);
        scanner.nextLine();
        p1.shotdown();
    }
}

class Processor extends Thread{
    //volatile need to be called to ensure the program able to run
    //on any devices. (changing variables to shut down the thread).
    private volatile boolean running=true;

    @Override
    public void run(){
        while(running){
            System.out.println("Hello, World");

            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void shotdown(){
        running=false;
    }
}