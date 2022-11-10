
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import javax.swing.*;


public class IntructionPage extends JFrame implements ActionListener
{
    public JPanel pan;
    public JPanel pan1;
    public JLabel lab;
    public JLabel lab1;
    public String IP;
    public JButton but1;
    
    public IntructionPage()
    {
    pan = new JPanel();
    pan1 = new JPanel();
    lab = new JLabel();
    lab1 = new JLabel();
    but1 = new JButton("back");
    but1.addActionListener(this);
    pan1.setLayout(new FlowLayout());
    this.setLayout(new FlowLayout());
    lab1.setText("Your IP adress is");
        
    lab.setText(IPAdressReciever());
    pan1.add(lab1);
    pan1.add(lab);
    pan.add(but1);
    this.add(pan1);
    this.add(pan);
    this.pack();
    this.setVisible(true);
    
    
    }
    
    public String IPAdressReciever()
    {
      try
      {
        InetAddress ownIP=InetAddress.getLocalHost();
        IP = (String)(ownIP.getHostAddress());
    
      }catch (Exception e){
          
        System.out.println("Exception caught ="+e.getMessage());
        }
      return IP;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
     if(ae.getSource()== but1)
     {
         this.setVisible(false);
     }
    }
    
}
