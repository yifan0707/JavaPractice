package part5_threadPools;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

    private int id;

    Processor(int id){
        this.id =id;
    }

    @Override
    public void run(){
        System.out.println("task "+id+"started");

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("task "+id+"ended");

    }
}

public class App {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executor.submit(new Processor(i));
        }

        System.out.println("All tasks added");
        executor.shutdown();

        try{
            executor.awaitTermination(1, TimeUnit.HOURS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All tasks finished");
    }
}
