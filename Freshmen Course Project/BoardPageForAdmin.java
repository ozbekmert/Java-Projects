package videodatabase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.JScrollPane.*;

public class BoardPageForAdmin extends JFrame 
{
    private Board board;
    private String FileName;
    private File movie;
    private String ID;


    public BoardPageForAdmin(String FileName, File movie,Board board,String ID)
    {
        this.FileName=FileName;
        this.movie=movie;
        this.board=board;
        this.ID=ID;

        JFrame frame = new JFrame (FileName);
      frame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);

      JTabbedPane tp = new JTabbedPane();

      tp.addTab ("Watch", new VideoPanel(movie,FileName));
      tp.addTab ("Quiz", new QuizPanel(FileName,ID));
      tp.addTab ("Information", new InformationPanel(FileName,ID));
  

      frame.getContentPane().add(tp);
      frame.pack();
      frame.setVisible(true);
        this.board = board;
}

   

}