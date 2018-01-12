package part13_Callable_Future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args){
        ExecutorService executor= Executors.newCachedThreadPool();


        Future<Integer> future=executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception{
                Random random=new Random();
                int sleepTime=random.nextInt(4000);

                if(sleepTime>2000){
                    throw new IOException("sleep time is more than 2s!");
                }

                System.out.println("Starting the thread");
                try{
                    Thread.sleep(sleepTime);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                System.out.println("Ending the thread");
                return sleepTime;
            }
        });

        executor.shutdown();

        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            //future.get() will block the thread if the thread is not finished.
            //future.isDone() will tell whether the thread is finished or not
            //future.cancel() will cancel the thread
            System.out.println(future.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            //System.out.println(e);-> java.util.concurrent.ExecutionException: java.io.IOException: sleep time is more than 2s!
            //System.out.println(e.getCause()); -> java.io.IOException: sleep time is more than 2s!
            IOException ex=(IOException)e.getCause();
            System.out.println(ex.getMessage()); // -> sleep time is more than 2s!
        }
    }
}
