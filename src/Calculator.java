import javax.swing.*;

public class Calculator {
    public static void main(String arg[]){

//        String fn=JOptionPane.showInputDialog("First number: ");
//        String sn=JOptionPane.showInputDialog("Second number: ");
//
//        int num1=Integer.parseInt(fn);
//        int num2=Integer.parseInt(sn);
//
//        int sum=num1+num2;
//        JOptionPane.showMessageDialog(null,"The answer is "+sum,"The title",JOptionPane.PLAIN_MESSAGE);

        Layout calculator=new Layout();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setSize(270,180);
        calculator.setVisible(true);
    }
}
