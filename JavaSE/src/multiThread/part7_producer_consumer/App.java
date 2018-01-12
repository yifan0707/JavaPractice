package part7_producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args){
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    producer();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable(){
           @Override
           public void run(){
               try{
                   consumer();
               }catch(InterruptedException e ){
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


    private static void producer() throws InterruptedException{
        Random random=new Random();
        while(true){
            queue.put(random.nextInt(100));
            System.out.println("after putted a new item, Queue size is: "+queue.size());
        }
    }

    private static void consumer() throws InterruptedException{
        Random random=new Random();
        while(true){
            Thread.sleep(100);
            if(random.nextInt(10)==0){
                queue.take();
                System.out.println("size after taken is: "+queue.size());

            }
        }
    }
}


