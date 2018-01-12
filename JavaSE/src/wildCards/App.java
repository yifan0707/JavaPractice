package wildCards;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args){
        App app=new App();
        List<Integer> integerList= Arrays.asList(1,2,3);
        List<String> stringList=Arrays.asList("one","two","three");

        //this goes wrong since the integerList can only hold object element
        //in this case it shows that (?) WildCard and Object is not the same
        //app.printObjectList(integerList);
        app.printWildCardList(stringList);

    }

    private void printObjectList(List<Object> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println("\n");
    }

    private void printWildCardList(List<?> list){
        for(Object object:list){
            System.out.print(object+" ");
        }
        System.out.println("\n");
    }
}
