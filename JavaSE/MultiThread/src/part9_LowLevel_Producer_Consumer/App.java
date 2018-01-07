package part9_LowLevel_Producer_Consumer;

import java.util.LinkedList;

public class App {
    private static Processor processor=new Processor();

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
                   processor.consumer();
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
    private LinkedList<Integer> list=new LinkedList<Integer>();
    private final int LIMITATION=10;
    private Object lock=new Object();

    public void produce() throws InterruptedException{
        int value=0;

        while(true){
            synchronized(lock){
               while(list.size()==LIMITATION){
                   lock.wait();
               }
               list.add(value++);
               System.out.println("List's current size is: "+list.size());
               lock.notify();
            }
        }
    }


    public void consumer() throws InterruptedException{
        while(true){
            synchronized(lock){
                System.out.println("Item that removed is : "+list.removeFirst());
                lock.notify();
                while(list.size()==0) {
                    lock.wait();
                }
            }
            Thread.sleep(1000);
        }


    }


}
