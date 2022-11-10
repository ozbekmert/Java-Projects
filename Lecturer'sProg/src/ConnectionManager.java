
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;

public class ConnectionManager extends JPanel implements ActionListener
{
    public JButton FileChooser;
    public JButton FileChooser2;
    public JButton setTime;
    public JButton StartServer;
    public JPanel pan1;
    public JPanel pan2;
    public JPanel pan3;
    public JPanel pan4;
    public File quiz;
    public File StudentList;
    public JLabel lab1;
    public JLabel lab2;
    public JLabel lab3;
    public JLabel lab4;
    public JLabel lab5;
    public JLabel lab6;
    public JLabel lab7;
    public JLabel lab8;
    public FileDialog fd;
    public JTextField field;
    public String time;
    public ConnectionManager()
    {
        
        FileChooser = new JButton("Set");
        FileChooser.addActionListener(this);
        FileChooser2 = new JButton("Set");
        FileChooser2.addActionListener(this);
        FileChooser.setEnabled(true);
        FileChooser2.setEnabled(false);
        StartServer = new JButton("Route");
        StartServer.addActionListener(this);
        StartServer.setEnabled(false);
        setTime = new JButton("Set");
        setTime.addActionListener(this);
        setTime.setEnabled(false);
        
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        
        lab1 = new JLabel("Quiz Source");
        lab2 = new JLabel("Set Time(in minute)");
        lab3 = new JLabel("Student Soruce");
        lab4 = new JLabel("Server start");
        lab5 = new JLabel();
        lab6 = new JLabel();
        lab7 = new JLabel();
        lab8 = new JLabel();
        
        field = new JTextField(2);
        
        this.setLayout(new GridLayout(4,2));
        pan1.add(lab1);
        pan1.add(FileChooser);
        pan1.add(lab5);
        this.add(pan1);
        
        pan2.add(lab3);
        pan2.add(FileChooser2);
        pan2.add(lab6);
        this.add(pan2);
        
        pan3.add(lab2);
        pan3.add(field);
        pan3.add(setTime);
        pan3.add(lab7);
        this.add(pan3);
        pan4.add(lab4);
        pan4.add(StartServer);
        this.add(pan4);
        
        this.setVisible(true);
        
     

    }
    
    public File setFileFromDirectory()
    {

            fd = new FileDialog(new JFrame(), "Select",FileDialog.LOAD);
            fd.setVisible(true);

                File f= null;
                try
                {
                       f = new File(fd.getDirectory(),fd.getFile());

                      FileOutputStream fos = new FileOutputStream("MediaFileFromDir");
                      ObjectOutputStream oos = new ObjectOutputStream(fos);
                      oos.writeObject(fd.getDirectory());
                      oos.close();

                }

                catch(IOException  e1)
                {
                  f = null;  
                  System.out.println("Can't read: "+  e1.toString() );
                }


                return f;


            }

    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource()==FileChooser)
       {
           quiz =setFileFromDirectory();
           if(quiz != null)
           {
              lab5.setText("Selected Quiz Name: "+quiz.getName()); 
              FileChooser2.setEnabled(true);
           }
       }
       if(e.getSource()==FileChooser2)
       {
            StudentList =setFileFromDirectory();
           if(StudentList != null)
           {
               lab6.setText("Selected Student List: "+StudentList.getName());
              setTime.setEnabled(true);
           }
       
       }
       if(e.getSource()==setTime)
       {
            time = field.getText();
           if(time != "")
           {    
               lab7.setText("Proposed Time: "+time+"min");

              StartServer.setEnabled(true);
           }
       
       }
       if(e.getSource()==StartServer)
       {
           
        
        RUNSERVER conn_c= new RUNSERVER(quiz,StudentList,time);
          
        Thread t = new Thread(conn_c);
         
        t.start();
      
         BoardPageForAdmin.tp.setEnabledAt(2, true);
       }
        
        
    }

    
    
}

class RUNSERVER implements Runnable 
{
    private File file1;
    private  File file2;
    private String time;
    RUNSERVER(File file1,File file2, String time) 
    {
      this.file1=file1;
      this.file2=file2;
      this.time=time;
    
    }

    public void run () 
    {
         QuizServer server = new QuizServer(file1,file2,time);
    }

}

    
