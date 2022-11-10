
package Function_Menus;

import Server.Client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Relays_Menu extends JPanel implements ActionListener  
{
    public JLabel lab;
    public JPanel relay_Pan;
    public Client client;
    public JLabel  l1,l2,l3,l4,l5,l6;
    public JToggleButton r1,r2,r3,r4,r5,r6;
    public JPanel  p1,p2,p3,p4,p5,p6;
    public Thread read_op;
    public Boolean relay_stat;
    public JButton box;

    public Relays_Menu(Client client) 
    {
        this.client = client;
        init();

    }
    
    public void init()
    {
        box = new JButton("Enable Relay Status");
        box.addActionListener(this);
        r1 = new JToggleButton("Off");
        r2 = new JToggleButton("Off");
        r3 = new JToggleButton("Off");
        r4 = new JToggleButton("Off");
        r5 = new JToggleButton("Off");
        r6 = new JToggleButton("Off");
        r1.setEnabled(false);
        r2.setEnabled(false);
        r3.setEnabled(false);
        r4.setEnabled(false);
        r5.setEnabled(false);
        r6.setEnabled(false);
        
        l1 = new JLabel("Relay 1");
        l2 = new JLabel("Relay 2");
        l3 = new JLabel("Relay 3");
        l4 = new JLabel("Relay 4");
        l5 = new JLabel("Relay 5");
        l6 = new JLabel("Relay 6");
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1));
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1));
        p4 = new JPanel();
        p4.setLayout(new GridLayout(2,1));
        p5 = new JPanel();
        p5.setLayout(new GridLayout(2,1));
        p6 = new JPanel();
        p6.setLayout(new GridLayout(2,1));
        p1.add(r1);
        p1.add(l1);
        p2.add(r2);
        p2.add(l2);
        p3.add(r3);
        p3.add(l3);
        p4.add(r4);
        p4.add(l4);
        p5.add(r5);
        p5.add(l5);
        p6.add(r6);
        p6.add(l6);
        relay_Pan = new JPanel();
        relay_Pan.setLayout(new FlowLayout());
        relay_Pan.add(p1);
        relay_Pan.add(p2);
        relay_Pan.add(p3);
        relay_Pan.add(p4);
        relay_Pan.add(p5);
        relay_Pan.add(p6);
        relay_Pan.add(box);
        
        
        this.add(relay_Pan);
        this.setVisible(true);
        
    read_op = new Thread(){
            ArrayList<String> places = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6"));
            int relay_counter=0;
            public void run() 
            {
                while(true){
                
                    System.out.println("im running, status: "); 
                       relay_stat = client.getRelayStatus(places.get(relay_counter));
                       System.out.println(relay_stat);
		     try {
                         sleep(2000);
                       } catch (InterruptedException ex) {
                          Logger.getLogger(Relays_Menu.class.getName()).log(Level.SEVERE, null, ex);
                       }

                        if(relay_stat)  
                        {  
                          switch (relay_counter) 
                          {
                              case 0:  
                                  r1.setSelected(true);
                                       break;
                              case 1: 

                                   r2.setSelected(true);
                                       break;
                              case 2:  
                                   r3.setSelected(true);

                                       break;
                              case 3:  
                                   r4.setSelected(true);

                                       break;
                              case 4:  

                                   r5.setSelected(true);
                                       break;
                              case 5:  
                                   r6.setSelected(true);

                                       break;
                          }
                        }
                        else
                        {  
                          switch (relay_counter) 
                          {
                              case 0: 
                             
                                  r1.setSelected(false);
                                       break;
                              case 1: 

                                   r2.setSelected(false);
                                       break;
                              case 2:  
                                   r3.setSelected(false);

                                       break;
                              case 3:  
                                   r4.setSelected(false);

                                       break;
                              case 4:  

                                   r5.setSelected(false);
                                       break;
                              case 5:  
                                   r6.setSelected(false);

                                       break;
                          }
                        }
                        
                        relay_counter++;
                        if(relay_counter==5)
                            relay_counter=0;
 
            }
         }

        };
    
    
    
    }


    @Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==box)
       {
            read_op.start();
            box.setEnabled(false);
       
       }
    }
    
}


