
package videodatabase;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.FileWriter;


import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;
public class SetQuiz extends JFrame implements ActionListener,Serializable
{
    private JButton save;
 
    private JButton back;
   
    private JRadioButton choice1;
    private JRadioButton choice2;
    private JRadioButton choice3;
    private JRadioButton choice4;
    private JRadioButton choice5;
    private ButtonGroup group;
    private JTextField ques;
    private JTextField ans1;
    private JTextField ans2;
    private JTextField ans3;
    private JTextField ans4;
    private JTextField ans5;
    private JTextField rightans;

    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panelall;
    private JLabel rightAnswer;
    private JLabel question;
    private JLabel infoLabel;
   // private ArrayList<String> toFile;
    private String FileName;

   

    public SetQuiz(String FileName)
    {
        this.FileName=FileName;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500,500);
        setLocation(125,40);

        setLayout(new GridLayout(4,3));
        setVisible(true);
        // -------------------------ArrayList------------------------------------------
//       toFile = new ArrayList<String>();
        // -------------------------JRadioButtons--------------------------------------
        choice1 = new JRadioButton("a");
        choice2 = new JRadioButton("b");
        choice3 = new JRadioButton("c");
        choice4 = new JRadioButton("d");
        choice5 = new JRadioButton("e");
        save = new JButton("save");
       
        back= new JButton("Back");
   
        //--------------------------------JTextField------------------------------
        ques = new JTextField(50);
        ans1 = new JTextField(20);
        ans2 = new JTextField(20);
        ans3 = new JTextField(20);
        ans4 = new JTextField(20);
        ans5 = new JTextField(20);
        rightans = new JTextField(1);
        //---------------------------------JPanel------------------------------

        panel2 = new JPanel();
        panel3= new JPanel();
        panel4 = new JPanel();
        panel5= new JPanel();
        panel6= new JPanel();
        panelall = new JPanel();
        //--------------------------------JLabel--------------------------------
        rightAnswer = new JLabel("Rigth Answer: ");
        question = new JLabel("Question: ");
        infoLabel = new JLabel("There is nothing ");


        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice4.addActionListener(this);
        choice5.addActionListener(this);
        save.addActionListener(this);
   
        back.addActionListener(this);
      
        //--------------------Registering Group Button------------------------------
        group = new ButtonGroup();
             group.add(choice1);
             group.add(choice2);
             group.add(choice3);
             group.add(choice4);
             group.add(choice5);

        // ------------------------Setting Up Frame ------------------------
             panel2.setLayout(new FlowLayout());
            
             panel2.add(question);
             panel2.add(ques);
             add(panel2);
             panel3.setLayout(new GridLayout(5,2));
             panel3.add(choice1);             
             panel3.add(choice2);              
             panel3.add(choice3);              
             panel3.add(choice4);              
             panel3.add(choice5);             
             panelall.add(panel3);
             panel4.setLayout(new GridLayout(5,1));
             panel4.add(ans1);
             panel4.add(ans2);
             panel4.add(ans3);
             panel4.add(ans4);
             panel4.add(ans5);
             panelall.add(panel4);
             panelall.add(rightAnswer);
             panelall.add(rightans);
             add(panelall);
             panel5.setLayout(new FlowLayout());
             panel5.add(save);
       
             panel5.add(back);

             add(panel5);
             panel6.add(infoLabel);
             add(panel6);
             pack();



    }
    private void saveQuestion(String str,String FileName)
    {
        String ALPHA = FileName +"QUIZQUESANS";
        File file = new File(ALPHA);

       
            try
            {
                FileWriter fstream = new FileWriter(file,true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(str + "\r\n");
                out.close();
                System.out.println("Append is working");
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }

       }
    



    public void actionPerformed(ActionEvent e)
    {


        if(e.getSource()==save)
        {
            

        
           saveQuestion(ques.getText(),FileName);

           saveQuestion(ans1.getText(),FileName);

           saveQuestion(ans2.getText(),FileName);

           saveQuestion(ans3.getText(),FileName);

           saveQuestion(ans4.getText(),FileName);

           saveQuestion(ans5.getText(),FileName);

           saveQuestion(rightans.getText(),FileName);

                   ques.setText("");
                   ans1.setText("");
                   ans2.setText("");
                   ans3.setText("");
                   ans4.setText("");
                   ans5.setText("");
                   rightans.setText("");

           infoLabel.setText("Question that you've entered was successfully saved");
        }


       
        if(e.getSource()==back)
        {
            setVisible(false);
        }
        
  }
}

