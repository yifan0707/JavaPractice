import java.lang.reflect.*;

/**
 * This class is the main class that will test all techniques
 * related to the Java Reflection API
 */
public class ReflectionTesting {
    public static void main(String[] args){
        //pass the class to SpecialEnemyClass
        Class specialEnemyClass=SpecialEnemy.class;

        //this gets the class name as an string
        String className=specialEnemyClass.getName();

        System.out.println(className+"\n");

        //isAbstract,isFinal,isInterface,isPrivate,isProtected,
        //isStatic,isStrict,isSynchronized,isVolatile.
        int classModifiers=specialEnemyClass.getModifiers();
        System.out.println("Is EnemyClass Abstract:"+Modifier.isAbstract(classModifiers)+"\n");

        //getting the super class name
        Class enemyClass=specialEnemyClass.getSuperclass();
        String superClassName=enemyClass.getName();
        System.out.println("The super class name is: "+superClassName+"\n");

        //getting the class methods as an Method array
        Method[] methods=specialEnemyClass.getMethods();

        //loop through all the array
        for(Method method:methods) {
            System.out.println("The method name is: "+method.getName());
            if(method.getName().startsWith("get")){
                System.out.println("Getter Method found");
            }else if(method.getName().startsWith("set")){
                System.out.println("Set method found");
            }
            //output the return type of the method
            System.out.println("Method's return type is: "+method.getReturnType());

            //list of the parameters of the method
            Class[] parameters=method.getParameterTypes();
            System.out.print("Parameter Name is: ");
            for(Class parameter:parameters){
                System.out.print(parameter.getName());
            }
            System.out.println("\n");
        }

        //To access the constructor of the class
        Constructor constructor=null;
        Constructor defaultConstructor=null;
        Constructor falseConstructor=null;
        Object instanceConstructor=null;


        try {
            //constructor with no parameters
            defaultConstructor=specialEnemyClass.getConstructor(null);

            //constructor that contains one parameter. In this case this constructor doesn't exist
            //this line of code mush be commented out otherwise all other line of codes would not
            //be recognized since Exceptions have been thrown
            //falseConstructor=specialEnemyClass.getConstructor(int.class);

            //constructor that contains multiple parameters using "new Class[]{.....}" to represent all elements
            constructor=specialEnemyClass.getConstructor(new Class<?>[]{int.class,String.class,double.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //to create a new instance using the constructor of the class
        //according to the output, java would access the parent constructor first and then access the child constructor
        try {
            instanceConstructor=specialEnemyClass.getConstructor(new Class[]{int.class, String.class,double.class})
                    .newInstance(100,"Zombie",10d);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Class<?>[] constructorParameters=constructor.getParameterTypes();
        for(Class<?> parameter:constructorParameters){
            System.out.print(parameter.getName()+" ");
        }
        System.out.println("\n");


        //Declare all the instances variables outside the try fields
        //otherwise the new instance variable can not be accessed outside the try code block
        SpecialEnemy specialEnemy=null;


        //Initiating an new instance using the constructor above
        try {
            specialEnemy=(SpecialEnemy) constructor.newInstance(100,"Alien",20.0d);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        specialEnemy.setName("AlienNo.1");
        specialEnemy.setDamage(200.0f);
        System.out.println(specialEnemy.getName()+" "+specialEnemy.getDamage());

        //Access private fields using reflection
        //Field stores info on a single field of a class
        //A Field provides information about, and dynamic access to, a single field of a class or an interface.
        //The reflected field may be a class (static) field or an instance field
        Field stringName=null;

        try {
            //define a field that you want to access.
            //In this case, we define a field from the parent class Enemy since there is no NAME field in the child class
            stringName= SpecialEnemy.class.getSuperclass().getDeclaredField("name");

            //set the accessible of the field to be true to avoid private/protected case
            stringName.setAccessible(true);

            //get the value of a field and store it into
            String valueOfName=(String)stringName.get(specialEnemy);
            System.out.println("Special enemy's name is "+valueOfName);

            String methodName="levelUp";

            //Getting the method according to the way its declared to avoid overloading
            //in this case "levelUp()" will be call instead of "levelUp(int number)"
            Method levelUpMethod1=SpecialEnemy.class.getDeclaredMethod(methodName,null);

            levelUpMethod1.setAccessible(true);

            //invoking the method by passing a instance and the argument that method required
            levelUpMethod1.invoke(specialEnemy,null);

            Method levelUpMethod2=SpecialEnemy.class.getDeclaredMethod(methodName,new Class<?>[]{int.class});
            levelUpMethod2.setAccessible(true);
            levelUpMethod2.invoke(specialEnemy,3);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }





}
