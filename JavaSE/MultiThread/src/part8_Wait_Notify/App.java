package part8_Wait_Notify;

import java.util.Scanner;

public class App {
    private static final Processor processor=new Processor();

    public static void main(String[] args){
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    processor.produce();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    processor.consume();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}

class Processor{

    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Produce thread running... ");
            wait();
            System.out.println("resumed");
        }
    }

    public void consume() throws InterruptedException{
        Scanner scanner =new Scanner(System.in);
        Thread.sleep(3000);
        synchronized(this){
            System.out.println("waiting for return key");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(3000);

        }
    }
}
