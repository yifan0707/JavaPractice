package designpattern.prototype;

/**
 * Prototype pattern is used to creating new objects by cloning existing
 * other objects.
 *
 * Situation that being used
 * 1. Avoid subclasses of an object creator in the client application
 * 2. Avoid the inherent cost of creating a new object in the standard way
 */
public class App {
    public static void main(String[] args){
        PenFactory penFactory=new PenFactory();
        Pencil pencil1=new Pencil();
        Pencil pencil2=(Pencil)penFactory.makeCopy(pencil1);

        //These two object are referencing different address of the system
        //which means although these two instance have same fields. They are
        //still different
        System.out.println(System.identityHashCode(pencil1));
        System.out.println(System.identityHashCode(pencil2));
    }
}
