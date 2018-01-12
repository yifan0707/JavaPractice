package networkProgramming.netWorking;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.applet.AppletContext;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class App extends JApplet{
    private HashMap<String, URL> websiteInfo;
    private ArrayList<String> titles;
    private JList mainList;

    //init
    public void init(){
        websiteInfo=new HashMap<String,URL>();
        titles=new ArrayList<String>();

        loadHTMLInfo();

        add(new JLabel("What website do you want to visit??"), BorderLayout.NORTH);
        mainList=new JList(titles.toArray());

        mainList.addListSelectionListener((ListSelectionEvent e)->{
            Object object=mainList.getSelectedValue();
            URL url=websiteInfo.get(object);
            AppletContext browser=getAppletContext();
            browser.showDocument(url);
        });

        add(new JScrollPane(mainList),BorderLayout.CENTER);
    }

    private void loadHTMLInfo(){
        String title;
        String address;
        URL url;

        int counter=0;
        title=getParameter("title"+counter);
        while(title != null ){
            address = getParameter("address"+counter);
            try {
                url=new URL(address);
                websiteInfo.put(title,url);
                titles.add(title);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            counter++;
            title=getParameter("title"+counter);
        }
    }
}

