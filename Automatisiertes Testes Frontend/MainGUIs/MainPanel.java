package MainGUIs;

import AutoTest.MainAutoTest;
import Server.Client;
import Function_Menus.Relays_Menu;
import Function_Menus.VFS_Menu;
import Function_Menus.Temp_Menu;
import Function_Menus.PWM_Menu;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPanel extends JFrame implements ActionListener
{
   public Client client;
   public JPanel pan1,pan2,pan3;
   public JPanel pan_sub1,pan_sub2;
   public JLabel lab1;
   public JButton auto;
   public JRadioButton pwm_menu,temp_menu,relay_menu,vfs_menu;
   public ButtonGroup group;
   public  JPanel collection;
   public PWM_Menu pwm_panel;
   public Relays_Menu relays_panel;
   public Temp_Menu temp_panel;
   public VFS_Menu fvs_panel;
   public MainPanel(Client client)
   {
       this.client = client;
       init(); 
   }

   public void init()
   {
   
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan_sub1 = new JPanel();
        pan_sub2 = new JPanel();
        pan3 = new JPanel();
        lab1 = new JLabel("Please choose one of the following Option for Operation");
        pan1.add(lab1);

        pwm_menu = new JRadioButton("PWM Menu",true);
        temp_menu = new JRadioButton("Temperature Sensors Menu",false);
        relay_menu = new JRadioButton("Relays Menu",false);
        vfs_menu =  new JRadioButton("VFS Menu",false);
        
        group = new ButtonGroup();
        pwm_menu.addActionListener(this);
        temp_menu.addActionListener(this);
        relay_menu.addActionListener(this);
        vfs_menu.addActionListener(this);
        
        group.add(pwm_menu);
        group.add(temp_menu);
        group.add(relay_menu);
        group.add(vfs_menu);
        
        auto = new JButton("Start Automated Tests Section");
        auto.addActionListener(this);
        pan_sub1.setLayout(new FlowLayout());
        pan_sub1.add(pwm_menu);
        pan_sub1.add(temp_menu);
        pan_sub1.add(relay_menu);
        pan_sub1.add(vfs_menu);
        
        pan_sub2.add(auto);
        pan2.setLayout(new FlowLayout());
        pan2.add(pan_sub1);
        pan2.add(pan_sub2);
        this.setLayout(new FlowLayout());
        this.add(pan1);
        this.add(pan2);
        
        pwm_panel = new PWM_Menu(client);
        relays_panel = new Relays_Menu(client);
        temp_panel = new Temp_Menu(client);
        fvs_panel = new VFS_Menu(client);
        
        collection = new JPanel(new CardLayout());
        collection.add(pwm_panel, "PWM Menu");
        collection.add(relays_panel, "Relays Menu");
        collection.add(temp_panel, "Temperature Menu");
        collection.add(fvs_panel, "VFS Menu");
        
        pan3.add(collection);
        this.add(pan3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1500,575));
        this.setTitle("Main Menu");
        this.pack();
   
   }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
          CardLayout cl = (CardLayout)(collection.getLayout());

        if(ae.getSource() == pwm_menu)
        {
            cl.show(collection, "PWM Menu");
         
        }
        else if(ae.getSource() == temp_menu)
        {
            cl.show(collection, "Temperature Menu");
            
        }
        else if(ae.getSource() == relay_menu)
        {
            cl.show(collection, "Relays Menu");
        }
        else if(ae.getSource() == vfs_menu)
        {
            cl.show(collection, "VFS Menu");
        }
        else if(ae.getSource() == auto)
        {
            MainAutoTest testSection = new MainAutoTest(client);
        }
        


        


       
    }
}
