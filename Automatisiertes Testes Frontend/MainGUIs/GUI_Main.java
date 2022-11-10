package MainGUIs;

import Server.Client;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.*;

public class GUI_Main extends Thread implements ActionListener{

    public JFrame frame;
    public JLabel welcomeLabel;
    public JLabel IP_Lab;
    public JLabel Port_Lab;
    
    public JPanel pan1;
    public JPanel pan2;
    public JPanel pan3;
    
    public JButton start;
    public Thread gui_thread;
    public JTextField ip_field;
    public JTextField port_field;
    public Client client;
    
    public GUI_Main()
    {

    }
    
    
    
    public void init()
    {
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        
        frame = new JFrame("V1");
        welcomeLabel = new JLabel("Welcome to Automatisiertes Testen AG ");
        pan1.add(welcomeLabel);
        
        
       
        ip_field = new JTextField(15);
        port_field = new JTextField(4);
        ip_field.setText("192.168.1.64");
        port_field.setText("8081");
        IP_Lab = new JLabel("Target  IP:");
        Port_Lab = new JLabel("Target Port:");
        
        
        pan2.setLayout(new GridLayout(2,2));
        pan2.add(IP_Lab);
        pan2.add(ip_field);
        pan2.add(Port_Lab);
        pan2.add(port_field);

        
        start = new JButton("Log-In");
        start.addActionListener(this);
        pan3.add(start);
        
        frame.setLayout(new GridLayout(3,1));
        frame.add(pan1);
        frame.add(pan2);
        frame.add(pan3);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        
    
    }
    public void run()
    {
            init();
    
    }
    
    public Client connect(String ip,String port)
    {  
         Client client=null;
         
         String URL[] = new String[] {ip,port};
                boolean op;
               
		try {
			String serverURL = "http://" + URL[0] + ":"+ URL[1] + "/RPC2";
                         //   String serverURL = "http://" + "192.168.1.68:8081" + "/RPC2";			
                            // Create a new client with the given server address.
			  client = new Client(serverURL);
                        // Execute the RPC on the server.
		} catch (MalformedURLException e)
                {
			System.err.println("Client: Invalid server address: " + URL[0]+":"+URL[1]);
			//System.exit(0);
		}
                
         return client;       
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == start)
        {
        
           client = connect(ip_field.getText(),port_field.getText());
           new MainPanel(client);
           frame.setVisible(false);
        }
       
    }


    
}
