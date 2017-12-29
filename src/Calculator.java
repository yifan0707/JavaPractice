import javax.swing.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args){

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
        calculator.setSize(270,270);
        calculator.setMinimumSize(new Dimension(270,270));
        calculator.setVisible(true);
    }
}

