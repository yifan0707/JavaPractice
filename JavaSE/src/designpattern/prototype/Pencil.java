package designpattern.prototype;

public class Pencil implements Pen {

    public Pencil(){
        System.out.println("Pencil instance created");
    }

    @Override
    public Pen clone(){
        Pencil temp=null;
        try{
            temp= (Pencil)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return temp;
    }
}
