package part11_DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    private static Runner runner=new Runner();

    public static void main(String[] args){
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    runner.thread1();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });


        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    runner.thread2();
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
    BankAccount bankAccount1;
    BankAccount bankAccount2;
    private Random random=new Random();
    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();

    private void actuireLock(Lock lock1,Lock lock2){
        while(true){
            boolean gotLock1=false;
            boolean gotLock2=false;

            try{
                gotLock1=lock1.tryLock();
                gotLock2=lock2.tryLock();
            }finally {
                if(gotLock1&&gotLock2){
                    return;
                }
                if(gotLock1){
                    lock1.unlock();
                }
                if(gotLock2){
                    lock2.unlock();
                }
            }
        }
    }

    public Runner(){
        bankAccount1=new BankAccount();
        bankAccount2=new BankAccount();
    }

    public void thread1() throws InterruptedException{
        actuireLock(lock1,lock2);
        try{

            for(int i=0;i<10000;i++){
                BankAccount.transefer(bankAccount1,bankAccount2,random.nextInt(100));
            }
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void thread2() throws InterruptedException{
        actuireLock(lock1,lock2);
        try{

            for(int i=0;i<10000;i++){
                BankAccount.transefer(bankAccount2,bankAccount1,random.nextInt(100));
            }
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void finished(){
        System.out.println("bank account1: "+bankAccount1.getBalance()+" bank account2: "+bankAccount2.getBalance()
                +" "+(bankAccount1.getBalance()+bankAccount2.getBalance()));
    }


}