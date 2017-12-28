import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends JFrame{
    private JLabel item1;
    private JButton equalButton;
    private JTextField textField;
    public Layout(){
        super("The title");
        setLayout(new FlowLayout());
        addOutputBar();
//        item1 = new JLabel("This is a sentence");
//        item1.setToolTipText("This is gonna show up on hover");
//        add(item1);


        for(int i=0;i<10;i++){
            this.addButton(Integer.toString(i));
        }
        equalButton=new JButton("=");
        this.add(equalButton);
        EventHandler handler=new EventHandler();
        equalButton.addActionListener(handler);



    }

    /**
     * add the button with the given text
     * @param text
     */
    public void addButton(String text){
        JButton button=new JButton();
        button.setText(text);
        button.setSize(100,100);
        this.add(button);
    }

    public void addOutputBar(){
        textField=new JTextField("0",20);
        textField.setEditable(false);
        this.add(textField);
    }

    private class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==equalButton){
                textField.setText("answer");
            }
        }
    }

}
