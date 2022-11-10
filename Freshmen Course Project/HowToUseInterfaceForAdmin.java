package videodatabase;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class HowToUseInterfaceForAdmin extends JFrame implements ActionListener
{
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label4;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private JLabel Label9;
    private JPanel MainPanel;
    private JButton back;
    public HowToUseInterfaceForAdmin()
    {

            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
           
            setVisible(true);
           
            getContentPane().setBackground(Color.gray);

            Label1 = new JLabel("The video-music database, which is based on collaborative program,");
            Label2 = new JLabel("allows people to inform themselves about new or old");
            Label3= new JLabel("produced movies and enhance their movie knowledge");
            Label4 = new JLabel("All admins must have their individual IDs and passwords inorder to login");
            Label5 = new JLabel("If the admin doesn't have an ID and a password, admin must register");
            Label6 = new JLabel("After logging in admin can watch videos,trailers etc. , add comments and ratings");
            Label7 = new JLabel("listen soundtracks like users. Also admins can edit and add informations on videos");
            Label8 = new JLabel("In addition to that admins can create new questions for quizes. Admin must enter ");
            Label9 = new JLabel("the relevant password to access set quiz part");



            MainPanel = new JPanel();
             MainPanel.setLayout(new GridLayout(10,1));
            back = new JButton("Back");
            back.addActionListener(this);

            MainPanel.add(Label1);
            MainPanel.add(Label2);
            MainPanel.add(Label3);
            MainPanel.add(Label4);
            MainPanel.add(Label5);
            MainPanel.add(Label6);
            MainPanel.add(Label7);
            MainPanel.add(Label8);
            MainPanel.add(Label9);
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
