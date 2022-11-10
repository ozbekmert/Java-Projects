package videodatabase;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane.*;


public class AdminBoard extends JFrame implements ActionListener
{   
    private Container pane;
    private JFrame MainFrame = new JFrame();
    private JLabel welcomeLabel;
    private JLabel addingLabel;
    private JLabel deletingLabel;
    private JLabel videoMenu;
    private JLabel soundTrackMenu;
    private String ID;
    private String password;
    private JPanel  welcomePanel;
    private JPanel VideoPanel;
    private JPanel SoundTrackPanel;
    private JPanel addingPanel;
    private JPanel deletingPanel;
    private JTextField deleteVideoField;
    private JTextField deleteSoundTrackField;
    private JButton createVideo;
    private JButton createSoundTrack;
    private JButton deleteVideo;
    private JButton deleteSoundTrack;
    private JButton exit;
    private JButton saveForVideo;
    private JButton saveForSoundTrack;
    private FileChoosingMenuForVideo menu;
    private FileChoosingMenuForSound menu2;
   
    


    public AdminBoard(String ID, String password)
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
        addingPanel = new JPanel();
        deletingPanel = new JPanel();
       
//-------------------------------JTEXTFIELD----------------------------
        deleteVideoField = new JTextField(5);
        deleteSoundTrackField = new JTextField(5);
 //--------------------------JBUTTON------------------------
        createVideo = new JButton("Add Video");
        createSoundTrack = new JButton("Add SoundTrack");
        deleteVideo = new JButton("Delete Video:");
        deleteSoundTrack = new JButton("Delete SoundTrack:");
        exit = new JButton("Back");
        saveForVideo = new JButton("Save Video");
        saveForSoundTrack =new JButton("Save SoundTrack");
 //--------------------------JLABEL----------------------------------------
       welcomeLabel = new JLabel("Welcome to Admin Main Page");
       addingLabel = new JLabel("Adding Menu");
       deletingLabel = new JLabel("Deleting Menu");
       videoMenu = new JLabel("Video Menu");
       soundTrackMenu = new JLabel("SoundTrack Menu");


 //----------------Registring action Listner-----------------------------
        createVideo.addActionListener(this);
        createSoundTrack.addActionListener(this);
        deleteVideo.addActionListener(this);
        deleteSoundTrack.addActionListener(this);
        exit.addActionListener(this);
         saveForVideo.addActionListener(this);
         saveForSoundTrack.addActionListener(this);

 //----------------------Adding all those things to the Frame------------------------------
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        VideoPanel.add(videoMenu);
        VideoPanel.add(Main.videoPanel);
        add(VideoPanel);
        SoundTrackPanel.add(soundTrackMenu);
        SoundTrackPanel.add(Main.soundTrackPanel);
        add(SoundTrackPanel);
        addingPanel.add(addingLabel);
        addingPanel.add(createVideo);
        addingPanel.add(createSoundTrack);
        addingPanel.add(saveForVideo);
        addingPanel.add(saveForSoundTrack);
        add(addingPanel);
        deletingPanel.add(deletingLabel);
        deletingPanel.add(deleteVideo);
        deletingPanel.add(deleteVideoField);
        deletingPanel.add(deleteSoundTrack);
        deletingPanel.add(deleteSoundTrackField);
        add(deletingPanel);
        add(exit);

        


           pack();

    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==createVideo)
        {

             menu = new FileChoosingMenuForVideo();

  
        }
        
        if(e.getSource()==createSoundTrack)
        {
            menu2 = new FileChoosingMenuForSound();

        }
        if(e.getSource()==saveForVideo)
        {

             Main.boardList.add(new Board("Welcome to Board" + Main.count3));

            Main.mediaButtonListForAdmin.add(new MyJButton(""));
            Main.videoPanel.add(Main.mediaButtonListForAdmin.get(Main.count-1));
            Main.FileList.add(menu);
            //Main.addFCMVArrayList(menu);
            Main.mediaButtonListForAdmin.get(Main.count-1).addActionListener(this);
            Main.count++;
            Main.mediaButtonListForAdmin.get(Main.count-2).setText(Main.File.get(Main.count-2).getName());
            setVisible(false);
            setVisible(true);
        }
        for(int i = 0; i < Main.FileList.size(); i ++)
        {

	   if(e.getSource() == Main.mediaButtonListForAdmin.get(i)){
		
		BoardPageForAdmin mov = new  BoardPageForAdmin(Main.File.get(i).getName(), Main.File.get(i),Main.boardList.get(i),ID);
	}
        if(e.getSource()==saveForSoundTrack)
         {
            Main.boardList.add(new Board("Welcome to Board" + Main.count3));
            Main.SecondmediaButtonListForAdmin.add(new MyJButton(""));
            Main.soundTrackPanel.add(Main.SecondmediaButtonListForAdmin.get(Main.count2-1));


            Main.FileList2.add(menu2);
            //Main.addFCMVArrayList(menu2);
            Main.SecondmediaButtonListForAdmin.get(Main.count2-1).addActionListener(this);
            Main.count2++;
            Main.SecondmediaButtonListForAdmin.get(Main.count2-2).setText(Main.File2.get(Main.count2-2).getName());
            setVisible(false);
            setVisible(true);
        }
        for(int j = 0; j < Main.FileList2.size(); j ++)
        {

	   if(e.getSource() == Main.SecondmediaButtonListForAdmin.get(j)){
		BoardPageForAdmin mov = new  BoardPageForAdmin(Main.File2.get(j).getName(), Main.File2.get(j),Main.boardList.get(i),ID);
	}}
        if(e.getSource()==deleteVideo)
        {
            Main.videoPanel.remove(Main.mediaButtonListForAdmin.get(Integer.parseInt(deleteVideoField.getText())));
			setVisible(false);
			setVisible(true);

        }
        if(e.getSource()==deleteSoundTrack)
        {
            Main.soundTrackPanel.remove(Main.SecondmediaButtonListForAdmin.get(Integer.parseInt(deleteSoundTrackField.getText())));
	    	setVisible(false);
		setVisible(true);

        }
        if(e.getSource()==exit)
        {
            setVisible(false);
        }


    }
    }
    }



