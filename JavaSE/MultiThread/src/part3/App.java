package part3;

public class App {
    private int count;

    public static void main(String[] args){
        App app=new App();
        app.doSomething();
    }

    private void doSomething(){

        Thread t1=new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        Thread t2=new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            //join method will put current thread on wait(which is main thread in this case)
            //and wait till the calling thread is dead to start the new thread.
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }

    private synchronized void increment(){
        count++;
    }
}


