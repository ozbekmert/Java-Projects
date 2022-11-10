import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JScrollPane.*;

public class BoardPageForAdmin extends JFrame 
{
  
    private String FileName;
    private File movie;
    private String ID;
    public static JTabbedPane tp;
    
    public BoardPageForAdmin()
    {
       

        JFrame frame = new JFrame ("Wirelwss Quiz");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

       tp = new JTabbedPane();

      tp.addTab ("Quiz Tab", new QuizPanel());
      tp.addTab ("Information Tab", new ConnectionManager());
      tp.addTab("Quiz Result Tab", new QuizResultTab());
      tp.addTab("Server Panel", new ServerPanel(false));
      tp.setEnabledAt(2,false);
      
     
              
              
      frame.getContentPane().add(tp);
      frame.pack();
      frame.setVisible(true);
       
}

   

}