
package Function_Menus;

import Server.Client;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VFS_Menu extends JPanel implements ActionListener
{

    private final int MIN = 0;
    private final int MAX = 15;
    public ArrayList<JSlider> list;
    public JSpinner sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8;
    public JSlider s1,s2,s3,s4,s5,s6,s7,s8;
    public JPanel  p1,p2,p3,p4,p5,p6,p7,p8;
    public JLabel  l1,l2,l3,l4,l5,l6,l7,l8;
    public JButton ready;
    public JPanel vfs_panel,progressPan; 
    public JLabel status;
    public Client client;
    public JProgressBar bar; 
    public Task_IntegerUpdate ta;
    public boolean flag = false;
    public VFS_Menu(Client client)
    {
        this.client = client;
        init();
  
    }
    
    public void init()
    {
       s1 = new JSlider(JSlider.VERTICAL, MIN, MAX, 0);
       s2 = new JSlider(JSlider.VERTICAL, MIN, MAX, 0);
       list= new ArrayList<JSlider>();
       list.add(s1);
       list.add(s2);
       sp1 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 1));
       sp2 = new JSpinner(new SpinnerNumberModel(MIN, MIN, MAX, 1));

       ready = new JButton("Ready");
       ready.addActionListener(this);
       p1 = new JPanel();
       p1.setLayout(new FlowLayout());
       p2 = new JPanel();
       p2.setLayout(new FlowLayout());

       l1 = new JLabel("VFS 1");
       l2 = new JLabel("VFS 2");

       p1.add(sp1);
       p1.add(s1);
       p1.add(l1);
       
       p2.add(sp2);
       p2.add(s2);
       p2.add(l2);
       
       
       vfs_panel = new JPanel();
       vfs_panel.setLayout(new FlowLayout());
       vfs_panel.add(p1);
       vfs_panel.add(p2);

       bar = new JProgressBar(0,8);
       bar.setValue(0);
       bar.setStringPainted(true);
       status = new JLabel();
       this.add(vfs_panel);
       
       progressPan = new JPanel();
       progressPan.setLayout(new FlowLayout());
       progressPan.add(ready);
       progressPan.add(bar);
       progressPan.add(status);
       this.add(progressPan);
       this.setVisible(true);
       


        s1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e)
            {
                sp1.setValue(s1.getValue());
                System.out.println(s1.getValue());
              
            }});
        sp1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                s1.setValue((int) sp1.getValue());
            }});
       
        s2.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                sp2.setValue(s2.getValue());
             
            }});
        sp2.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                s2.setValue((int) sp2.getValue());
            }});
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       
        if(ae.getSource()==ready)
        {
            ready.setEnabled(false);
            ta = new Task_IntegerUpdate(bar, 9, status,list,client,ready);
            ta.addPropertyChangeListener(
             new PropertyChangeListener() 
             {
                 public  void propertyChange(PropertyChangeEvent evt) 
                 {
                     if ("progress".equals(evt.getPropertyName())) {
                         bar.setValue((Integer)evt.getNewValue());
                         status.setText("Loading S"+(Integer)evt.getNewValue()+" of total 8");
                     }
                 }
             });
            ta.execute();
            
        }
        
        
        
    }

 static class Task_IntegerUpdate extends SwingWorker<Integer, Integer> 
 {
/*
T - the result type returned by this SwingWorker's doInBackground and get methods
V - the type used for carrying out intermediate results by this SwingWorker's publish and process methods    */
     
        ArrayList<JSlider> list;
        JProgressBar jpb;
        int max;
        JLabel label;
        int val;
        Client client;
        int ret;
        public JButton ready;
        public Task_IntegerUpdate(JProgressBar jpb, int max, JLabel label,ArrayList<JSlider> list,Client client,JButton ready)
        {
            this.client=client;
           this.ready = ready;
            this.jpb = jpb;
            this.max = max;
            this.label = label;
            this.list=list;
        }

        @Override
        protected void process(List<Integer> chunks)
        {
          
            
        }
        
       

        @Override
        protected Integer doInBackground() throws Exception 
        {
              
              String temp ="S";
              String temp_val;
              int index=0;
                for(int i=0;i<2;i++)
                {
                 index = i+1;
                 temp += Integer.toString(index);
                 Thread.sleep(1000); 
                 val = list.get(i).getValue();
                 temp_val = Integer.toString(val);
                 System.out.println(temp+" "+temp_val);
  
                   // client.setTemp(temp,temp_val);

                 temp ="S";
                 setProgress(index);
            }

            return index;
        }

        @Override
        protected void done() {
            try 
            {
                get();
                ready.setEnabled(true);
                JOptionPane.showMessageDialog(label.getParent(), "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            } 
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        

      
    }   
}

