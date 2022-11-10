
package AutoTest;

import Server.Client;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainAutoTest extends JFrame implements ActionListener
{
    public JPanel main1,main2;
    public JLabel lab1;
    public final String[] comboTypes = { "SolarTest", "Test2", "Test3" };
    public JComboBox comboTypesList;
    public JButton start;
    public Client client;
    public Execute work;
    public MainAutoTest(Client client)
    {
         this.client = client;
         comboTypesList = new JComboBox(comboTypes);
         main1 = new JPanel();
         main2 = new JPanel();
         lab1 = new JLabel("Please Select Test Cases");
         start = new JButton("Start Selected Test");
         start.addActionListener(this);
         this.setLayout(new GridLayout(1,2));
         main1.setLayout(new FlowLayout());
         main2.setLayout(new FlowLayout());
         
         main1.add(lab1);
         main1.add(comboTypesList);
         
         main2.add(start);
         this.add(main1);
         this.add(main2);
         this.pack();
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==start)
        {
            if(((String)comboTypesList.getSelectedItem()).equals("SolarTest"))
            {
                work = new Execute("Solar_Test.xlsx",client);
                work.run();
            }
        }
    }
    
}
