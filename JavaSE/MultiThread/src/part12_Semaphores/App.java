package part12_Semaphores;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args){
        ExecutorService executor= Executors.newCachedThreadPool();

        for(int i=0;i<400;i++){
            executor.submit(new Runnable(){
                @Override
                public void run(){
                    try{
                        Connection.getInstance().connect();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }

        executor.shutdown();

        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
