package Function_Menus;

import Server.Client;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;


public class Temp_Menu extends JPanel implements ActionListener
{

    private final int MIN = -50;
    private final int MAX = 200;
    private Client client;
    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan3;
    private JPanel pan4;
    private JPanel pan5;
    private JPanel pan6;
    private JPanel pan7;
    private JPanel pan8;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;

    public ArrayList<JSlider> list;
    public JSpinner sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8;

    
    private JButton start;
    
    

    public Temp_Menu(Client client)
    {

       sp1 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp2 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp3 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp4 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp5 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp6 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp7 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));
       sp8 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 0.5));

        
        l1 = new JLabel("S1");
        l2= new JLabel("S2");
        l3= new JLabel("S3");
        l4= new JLabel("S4");
        l5= new JLabel("S5");
        l6= new JLabel("S6");
        l7= new JLabel("S7");
        l8= new JLabel("S8");
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        pan5 = new JPanel();
        pan6 = new JPanel();
        pan7 = new JPanel();
        pan8 = new JPanel();
        
        pan1.add(l1);
        pan1.add(sp1);
       
        pan2.add(l2);
        pan2.add(sp2);
       
        pan3.add(l3);
        pan3.add(sp3);
       
        pan4.add(l4);
        pan4.add(sp4);
       
        pan5.add(l5);
        pan5.add(sp5);
       
        pan6.add(l6);
        pan6.add(sp6);
       
        pan7.add(l7);
        pan7.add(sp7);
       
        pan8.add(l8);
        pan8.add(sp8);

        start = new JButton("Send");
        start.addActionListener(this);
        this.client = client;
        
        this.setLayout(new FlowLayout());
        
        this.add(pan1);
        this.add(pan2);
        this.add(pan3);
        this.add(pan4);
        this.add(pan5);
        this.add(pan6);
        this.add(pan7);
        this.add(pan8);
        this.add(start);
       
        
        
    }

    
    private MaskFormatter getMaskFormatter(String format) {
    MaskFormatter mask = null;
    try {
        mask = new MaskFormatter(format);
        mask.setPlaceholderCharacter('0');
    }catch (ParseException ex) {
        ex.printStackTrace();
    }
    return mask;
}

    @Override
    public void actionPerformed(ActionEvent xx)
    {
        
        if(xx.getSource()==start)
        {

                client.setTemp("S1",Double.toString((double)sp1.getValue()));
                
                
                try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                
                
                client.setTemp("S2",Double.toString((double)sp2.getValue()));
                try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                
                
                
                
                  client.setTemp("S3",Double.toString((double)sp3.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
               client.setTemp("S4",Double.toString((double)sp4.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
              client.setTemp("S5",Double.toString((double)sp5.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
              client.setTemp("S6",Double.toString((double)sp6.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
                  client.setTemp("S7",Double.toString((double)sp7.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
                client.setTemp("S8",Double.toString((double)sp8.getValue()));
                 try {
                     TimeUnit.SECONDS.sleep(1);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Temp_Menu.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
            
            }
        
        }
    }


