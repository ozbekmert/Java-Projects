
package videodatabase;

import java.awt.Dimension;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


import javax.swing.*;

class InformationPanel extends JPanel implements ActionListener
{

         private ImageIcon gif;


        private ImageIcon icon;
        private String FileName;

        private JLabel panel1;
        private JLabel panel2;
        private JButton imgbut;
        private JButton ManageQuiz;
        private String ID;


    public InformationPanel(String FileName,String ID)
    {
        this.FileName=FileName;
        this.ID=ID;
       
        setPreferredSize(new Dimension(360,400));

      
       panel2 = new JLabel("Welcome To Information Section");
       icon =new ImageIcon("information.gif");
       imgbut = new JButton(icon);
       imgbut.addActionListener(this);

       
        add(panel2);
        add(imgbut);
    

    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==imgbut)
        {
            MediaInfoBoard info = new MediaInfoBoard(FileName);
        }
    }

}
