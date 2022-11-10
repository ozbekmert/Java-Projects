package videodatabase;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class howToUseInterface extends JFrame implements ActionListener
{
    private JButton ForAdmin;
    private JButton ForUser;
    private JButton back;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label;

   public howToUseInterface()
   {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500,500);
        setLocation(125,40);
        setVisible(true);
        setLayout(new GridLayout(2,1));
        getContentPane().setBackground(Color.gray);

        ForAdmin = new JButton("Use for Admin");
        ForUser = new JButton("Use for User");
        back = new JButton("Back");
        panel1 = new JPanel();
        label = new JLabel(new ImageIcon("how.gif"));
        panel2 = new JPanel();
        panel2.add(label);

      

        ForAdmin.addActionListener(this);
        ForUser.addActionListener(this);
        back.addActionListener(this);

        add(panel2);
        panel1.add(ForAdmin);
        panel1.add(ForUser);
        panel1.add(back);

        add(panel1);
        pack();

   }
   public void actionPerformed(ActionEvent e)
   {
       if(e.getSource()== ForAdmin)
       {
            HowToUseInterfaceForAdmin face1 = new HowToUseInterfaceForAdmin();
       }
       if(e.getSource()== ForUser)
       {
            HowToUseInterfaceForUser face2 = new HowToUseInterfaceForUser();
       }
       if(e.getSource()== back)
       {
            setVisible(false);
       }



   }
}



