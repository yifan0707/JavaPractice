package part4;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    private Object lock1=new Object();
    private Object lock2=new Object();

    public static void main(String[] args){
        App app=new App();

        System.out.println("Starting the thread");
        long time1=System.currentTimeMillis();

        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                app.process();
            }
        });

        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){
                app.process();
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


        System.out.println(System.currentTimeMillis()-time1);
        System.out.println("Ending the thread" +
                "list1: "+app.getList1().size()+"list2: "+app.getList2().size());

    }

    public void stageOne(int i){
        synchronized(lock1) {
            try {
                list1.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void stageTwo(int i){
        synchronized(lock2){
            try{
                list2.add(i);
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    public void process(){
        for(int i=0;i<1000;i++){
            stageOne(i);
            stageTwo(i);
        }
    }

    public List<Integer> getList1(){
        return list1;
    }
    public List<Integer> getList2(){
        return list2;
    }

}
