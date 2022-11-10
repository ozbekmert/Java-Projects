
package videodatabase;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileChoosingMenuForVideo extends JFrame implements ActionListener
{
    private JButton browse;
    public static JButton FromUrl;
    private JButton back;
    private JPanel Choose;
    private JPanel Menu1;
    private JPanel Menu2;
    private JLabel Intro;
    private JLabel Intro1;
    private JLabel Intro2;
    private JLabel Intro3;
    private URL url;
    private FileDialog fd;
    private File UrlFile;
    private String filename;
    private JCheckBox registerAsUser;
    private JCheckBox registerAsAdmin;
    private ButtonGroup group;
    public static JProgressBar progress;
    private Timer timer;

    private JLabel errorLabel;
    private JTextField URL;
    private JTextField FileName;
    public boolean flag = true;

    public FileChoosingMenuForVideo()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(550,400);
		setLocation(400,400);
            setVisible(true);
            setBackground(Color.gray);
            setLayout(new GridLayout(4,1));
            browse = new JButton("Browse & Save");
            FromUrl = new JButton("Enter & Save");
            back = new JButton("Back");
            Choose = new JPanel();
            Menu1 = new JPanel();
            Menu2 = new JPanel();
            Intro = new JLabel("Please Choose File Source");
            Intro1 = new JLabel("From Directory");
            Intro2 = new JLabel("Movie Name:");
            Intro3 = new JLabel("Movie's URL:");
            progress = new JProgressBar();
            progress.setMinimum( 0 );
            progress.setMaximum( 20 );
            progress.setValue( 0 );
            progress.setStringPainted(true);
            


           errorLabel = new JLabel("Please be careful while entering your properties");
            URL = new JTextField(20);
            FileName = new JTextField(20);

            Choose.add(Intro);
            add(Choose);
            Menu1.setLayout(new FlowLayout());
            Menu1.add(Intro2);
            Menu1.add(FileName);
            Menu1.add(Intro3);
            Menu1.add(URL);
            Menu1.add(FromUrl);
            Menu1.add(progress);
            add(Menu1);
            Menu2.setLayout(new FlowLayout());
            Menu2.add(Intro1);
            Menu2.add(browse);
            Menu2.add(back);
           
            add(Menu2);

            add(errorLabel);
            

            browse.addActionListener(this);
            FromUrl.addActionListener(this);
            back.addActionListener(this);
        pack();
    }

    public File setFileFromDirectory()
    {

            fd = new FileDialog(this, "Select Source Movie", FileDialog.LOAD);
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
                  System.out.println("Can't read: "+  e1.toString() );
                }


                return f;


            }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==browse)
        {
          File file = setFileFromDirectory();
          Main.File.add(file);
          //Main.addFileArrayList(file);
          setVisible(false);
        }
         if(e.getSource()==FromUrl)
        {
            FromUrl.setEnabled(false);
            Thread down = new Thread(new DownloadThread(FileName.getText(),URL.getText()));
            down.start();
            
           


        }





                
            
         

        
        if(e.getSource()==back)
        {
            setVisible(false);
        }


    }
}



