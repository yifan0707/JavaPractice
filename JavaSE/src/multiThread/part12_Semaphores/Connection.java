package part12_Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private int count;
    private Semaphore semaphore=new Semaphore(10);
    public static Connection getInstance() {
        return instance;
    }

    private Connection() {
        count=0;
    }

    public void connect() throws InterruptedException{
        semaphore.acquire();
        try{

            synchronized(this){
                count++;
                System.out.println("current count number is: "+count);
            }

            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            synchronized(this){
                count--;
                System.out.println("current count number is: "+count);
            }

        }finally {
            semaphore.release();
        }
    }



}
