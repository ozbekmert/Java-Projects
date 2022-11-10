package videodatabase;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


class VideoPanel extends JPanel implements ActionListener
{
    private String Name;
    private File movie;
    private ImageIcon gif;
    private URL ImageURL;
   
    private ImageIcon icon;
    private JLabel panel1;
    private JLabel panel2;

    private JButton play;

    public VideoPanel(File movie,String Name)
    {
        this.Name = Name;
        this.movie=movie;
        //setLayout(new FlowLayout());
        setPreferredSize(new Dimension(360,400));

        
       panel1  = new JLabel("Please click to the Button To watch movie that you've selected");
       panel2 = new JLabel("Welcome To Video Watching Section");
       icon =new ImageIcon("play1.png");
       play = new JButton(icon);
       play.addActionListener(this);
       
        add(panel2);
        add(play);
        add(panel1);
      
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play)
        {
             QuickTimeVideoPlayer mov = new QuickTimeVideoPlayer(Name, movie); 
        }
    }

}
