package videodatabase;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HowToUseInterfaceForUser extends JFrame implements ActionListener
{
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;

    private JPanel MainPanel;
    private JButton back;
    public HowToUseInterfaceForUser()
    {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
         
            setVisible(true);
            

            getContentPane().setBackground(Color.gray);

            Label1 = new JLabel("The video-music database, which is based on collaborative program,,");
            Label2 = new JLabel("allows people to inform themselves about new or old");
            Label3= new JLabel("produced movies and enhance their movie knowledge");
            Label4 = new JLabel("All admins must have their individual IDs and passwords inorder to login");
            Label5 = new JLabel("If the user doesn't have an ID and a password, user must register");
            Label6 = new JLabel("After logging in user can watch videos,trailers etc. , add comments and ratings, listen soundtracks");
           
            MainPanel = new JPanel();
            MainPanel.setLayout(new GridLayout(7,1));
            back = new JButton("Back");
            back.addActionListener(this);

            MainPanel.add(Label1);
            MainPanel.add(Label2);
            MainPanel.add(Label3);
            MainPanel.add(Label4);
            MainPanel.add(Label5);
            MainPanel.add(Label6);

            MainPanel.add(back);
            add(MainPanel);
            pack();

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            setVisible(false);
        }

    }

}
