package part14_Interrupting_Threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args){
        ExecutorService executor= Executors.newCachedThreadPool();

        Future<?> future=executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception{
                System.out.println("Thread starting to run");

                Random random=new Random();
                for(int i=0;i<1E8;i++){
                    Math.sin(random.nextDouble());

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread being interrupted");
                        break;
                    }
                }

                System.out.println("Thread ending");
                return null;

            }
        });

        executor.shutdown();

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //future.cancel will trigger the interrupted flag to false
        future.cancel(true);

        //shutdownNow will trigger the interrupted flag to be false
        //executor.shutdownNow();

        //or using t.interrupted() to interrupt the thread

    }
}
