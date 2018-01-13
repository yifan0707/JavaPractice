package designpattern.observer;

import java.util.Random;

public class StockControl implements Runnable {
    private ComputerShop cs;

    public StockControl(ComputerShop cs){
        this.cs=cs;
    }

    @Override
    public void run() {
        Random random=new Random();
        for(int i=0;i<20;i++){
            int count=random.nextInt(5);

            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(random.nextFloat()-0.5>0){
                System.out.println("item added "+count);
                cs.addingMerchandise
                        (MerchandiseName.values()[random.nextInt(3)],count);
            }else{
                System.out.println("item sold "+count);
                cs.sellingMerchandise
                        (MerchandiseName.values()[random.nextInt(3)],count);
            }
        }

    }
}
