
package Function_Menus;

import Server.Client;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class PWM_Menu extends JPanel implements ActionListener 
{
    
    public Client client;
    private XYGraph pwm1_gr,pwm2_gr;
    public Thread update;
    public JPanel pan1,pan2,status_pan;
    public JLabel lab1,lab2,status_lab1,status_lab2;
    public JTextField field1;
    public JTextField field2;
    public JCheckBox box1,box2;
    public JButton but1,but2;
    public double pwm1_val,pwm2_val;
    public Thread read_op;
    public Thread read_op2;
    public PWM_Menu(Client client)
    {
        this.client=client;
        init();

    }
    
    public void init()
    {
          pwm1_gr = new XYGraph("PWM_1");
          pwm2_gr = new XYGraph("PWM_2");
          pan1 = new JPanel();
          pan2 = new JPanel();
          pan1.setLayout(new FlowLayout());
          pan2.setLayout(new FlowLayout());
          
          box1 = new JCheckBox("Enable PWM1");
          box1.setSelected(false);
          status_lab1 = new JLabel("im here");
          lab1 = new JLabel("Please Enter PWM Level(0-100) corspnd %");
          field1 = new JTextField(3);
          but1 = new JButton("Set PWM1");
          but1.addActionListener(this);
          pan1.add(box1);
          pan1.add(lab1);
          pan1.add(field1);
          pan1.add(but1);
          pan1.add(status_lab1);
          
          
          box2 = new JCheckBox("Enable PWM2");
          box2.setSelected(false);
          status_lab2 = new JLabel("im here");
          lab2 = new JLabel("Please Enter PWM Level(0-100) corspnd %");
          field2 = new JTextField(3);
          but2 = new JButton("Set PWM2");
          but2.addActionListener(this);
          pan2.add(box2);
          pan2.add(lab2);
          pan2.add(field2);
          pan2.add(but2);
          pan2.add(status_lab2);
          status_pan = new JPanel();
        
          
          this.setLayout(new GridLayout(2,2));
          this.add(pwm1_gr);
          this.add(pwm2_gr);
          this.add(pan1);
          this.add(pan2);
      
          this.setVisible(true);
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pwm1_gr.setVisible(true);
                    
            }
        });
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pwm2_gr.setVisible(true);
                    
            }
        });   
         
      read_op = new Thread()
        {
            public void run() 
            {
                long start = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                 pwm1_val=0;
                 pwm2_val=0;
                while(true)
                {
                    long end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                    if(box1.isSelected())
                    //pwm1_val=Math.random();
                    pwm1_val = client.getPWM("PWM0"); 
                    if(pwm1_val != -1)
                    {
                    update(1,end-start, pwm1_val);
                    }
                    
                    if(box2.isSelected())
                    //pwm2_val= Math.random(); 
                    pwm2_val = client.getPWM("PWM1");
                    if(pwm1_val != -1)
                    {
                        update(2,end-start, pwm2_val);
                    }
                    try { 
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PWM_Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                  
                }
            }
        };
      
      read_op.start();
        
     
    
    }
    
    public void update(int graph, double time, double data)
    {
        if(graph ==1)
        {
              pwm1_gr.setdata(time, data);
        }
        else if(graph == 2)
        {
              pwm2_gr.setdata(time, data);
        }
        else
        {
            System.out.println("Not suitable Graph selected");
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        boolean op=false;
       if(ae.getSource()==but1)
       {
           
          // op= client.setPWM("1",field1.getText());
           if(op)
           {
               status_lab1.setText("Succesfully write PWM1");
           }
           else
           {
                status_lab1.setText("Failed write PWM1");
           }   
       }
       else if(ae.getSource()==but2)
       {
          
            //op= client.setPWM("2",field2.getText());
            if(op)
              status_lab2.setText("Succesfully write PWM2");
            else
                status_lab2.setText("Failed write PWM2");
                
       }
       
    }


}

class XYGraph extends JPanel 
{
 
    public static Integer time,data;
    private String name;
    private XYSeries series;
    private JFreeChart chart = null;
    private XYSeriesCollection dataset;
    private  ChartPanel CP;
    XYGraph(String name) 
    {
            this.name = name;
            series = new XYSeries(name);
            dataset = new XYSeriesCollection(series);
            chart  = ChartFactory.createXYLineChart("Pulse Width Modulation Menu",
                    "Time(Sec)", "PWM Voltage Level(%)",(XYSeriesCollection) dataset,
                    PlotOrientation.VERTICAL, true, true, false);

            // create and display a frame...            
            this.setLayout(new java.awt.BorderLayout());
            CP = new ChartPanel(chart);
            this.add(CP,BorderLayout.CENTER);
            this.validate();
            this.add(CP);
            this.validate();
    }
 
       
    public void setdata(double time,double data)
    {
        series.add(time,data);
    }
}
