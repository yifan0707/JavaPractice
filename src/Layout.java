import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends JFrame{
    private static EventHandler handler;
    private static int sum;
    private static StringBuilder output;
    private static String currentString;
    private JPanel buttons;
    private JButton equalButton;
    private JButton addButton;
    private JTextField textField;
    public Layout(){
        super("The title");
        currentString="";
        handler=new EventHandler();
        sum=0;
        output=new StringBuilder(sum);

        setLayout(new BorderLayout(5,5));
        addOutputBar();
        addButtons();
    }

    /**
     * add the button with the given text
     */
    public void addButtons(){
        buttons=new JPanel(new GridLayout(4,4,5,5));
        buttons.setBounds(10,50,250,250);
        buttons.setBackground(Color.gray);

        for(int i=0;i<10;i++){
            JButton button=new JButton();
            button.setText(Integer.toString(i));
            button.addActionListener(handler);
            buttons.add(button);
        }

        //This is for adding "+"
        addButton=new JButton("+");
        addButton.addActionListener(handler);
        buttons.add(addButton);

        //This is for adding "="
        equalButton=new JButton("=");
        equalButton.addActionListener(handler);
        buttons.add(equalButton);
        this.add(buttons,BorderLayout.CENTER);

    }

    public void addOutputBar(){
        textField=new JTextField(output.toString(),20);
        textField.setEditable(false);
        this.add(textField,BorderLayout.NORTH);
    }

    private class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //output the result and reset sum and string builder
            if(event.getSource()==equalButton){
                String[] tokens=output.toString().split(" +");
                for(int i=0;i<tokens.length;i++){
                    tokens[i]=tokens[i].trim();
                    sum=sum+Integer.parseInt(tokens[i]);
                }
                textField.setText(Integer.toString(sum));
                sum=0;
                output.setLength(0);
            }else if(event.getSource()==addButton){
                output.append(" +");
                textField.setText(output.toString());
            }else{
                String text=((JButton)(event.getSource())).getText();
                output.append(text);
                textField.setText(output.toString());
            }
        }
    }

}
