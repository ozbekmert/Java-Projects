
package videodatabase;

import java.awt.Dimension;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;

class QuizPanel extends JPanel implements ActionListener
{

         private ImageIcon gif;
     
   
        private ImageIcon icon;
        
        private JLabel panel1;
        private JLabel panel2;
        private JButton imgbut;
        private JButton ManageQuiz;
        private String FileName;
        private String ID;
        private JPasswordField field;
        private final String PASS="PINAR";

    public QuizPanel(String FileName,String ID)
    {
      this.FileName=FileName;
      this.ID=ID;
        //setLayout(new FlowLayout());
        setPreferredSize(new Dimension(360,420));
        
       panel1  = new JLabel("Please Click to the Button to Take Quiz");
       panel2 = new JLabel("Welcome To Quiz Section");
       icon =new ImageIcon("trivia.jpg");
       imgbut = new JButton(icon);
       imgbut.addActionListener(this);
       field = new JPasswordField(5);
       field.addActionListener(this);

        ManageQuiz = new JButton("Set Quiz");
        ManageQuiz.addActionListener(this);
        add(panel2);
        add(imgbut);
        add(ManageQuiz);
        add(field);
        add(panel1);
       
    }
    public boolean check()
    {
        boolean flag = false;
        if(field.getText().equalsIgnoreCase(PASS))
        {
            flag= true;
        }
   
        return flag;
    }
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== imgbut)
        {
           
           Quiz quiz = new Quiz(FileName,ID);

        }
        if(e.getSource()==ManageQuiz)
        {
           
            if(check())
            {
                
            SetQuiz Setquiz = new SetQuiz(FileName);
            field.setText("");
            }

        }
    }

}
