package videodatabase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane.*;

public class UserBoard extends JFrame implements ActionListener
{
    private Container pane;
    private JFrame MainFrame = new JFrame();
    private JLabel welcomeLabel;

    private JLabel videoMenu;
    private JLabel soundTrackMenu;
    private String ID;
    private String password;
    private JPanel  welcomePanel;
    private JPanel VideoPanel;
    private JPanel SoundTrackPanel;


    private JButton createVideo;
    private JButton createSoundTrack;

    private JButton exit;


    public UserBoard(String ID, String password)
    {
        this.password=password;
        this.ID=ID;

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(500,500);
            setLocation(125,40);
            setVisible(true);

            setBackground(Color.gray);

           setLayout(new GridLayout(6, 1));  // 4 rows and three columns



//------------------------JPANEL-------------------------
        welcomePanel = new JPanel();
        VideoPanel = new JPanel();
        SoundTrackPanel= new JPanel();


 //--------------------------JBUTTON------------------------
       
        exit = new JButton("Back");
 //--------------------------JLABEL----------------------------------------
       welcomeLabel = new JLabel("Welcome to Admin Main Page");
       videoMenu = new JLabel("Video Menu");
       soundTrackMenu = new JLabel("SoundTrack Menu");


 //----------------Registring action Listner-----------------------------
       
        exit.addActionListener(this);

 //----------------------Adding all those things to the Frame------------------------------
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        VideoPanel.add(videoMenu);
        VideoPanel.add(Main.videoPanel);
        add(VideoPanel);
        SoundTrackPanel.add(soundTrackMenu);
        SoundTrackPanel.add(Main.soundTrackPanel);
        add(SoundTrackPanel);
        add(exit);

           pack();

    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==exit)
        {
            setVisible(false);
        }

    }
    }


