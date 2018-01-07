package part10_Reentrant_Locks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    private static Runner runner=new Runner();

    public static void main (String[] args){
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    runner.threadProcess1();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2=new Thread(new Runnable(){
           @Override
           public void run(){
               try{
                   runner.threadProcess2();
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

        runner.finished();
    }
}

class Runner{
    private int count =0;
    private Lock lock =new ReentrantLock();
    private Condition condition=lock.newCondition();

    private void increment(){
        for(int i=0;i<100000;i++){
            count++;
        }
    }

    public void threadProcess1() throws InterruptedException{
        lock.lock();

        System.out.println("waiting.....");
        condition.await();
        System.out.println("Started.....");

        try{
            increment();
        }finally {
            lock.unlock();
        }
    }

    public void threadProcess2() throws InterruptedException{
        lock.lock();

        System.out.println("Pressing enter to resume");
        new Scanner(System.in).nextLine();
        condition.signal();
        System.out.println("Resumed");


        try{
            increment();
        }finally{
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println(count);
    }
}