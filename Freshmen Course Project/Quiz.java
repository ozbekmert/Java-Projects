
package videodatabase;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener
{

    // ---------------Question & Answer Label-----------------------
    public static JLabel QuestionLabel;
    public static JLabel AnswerLabel1;
    public static JLabel AnswerLabel2;
    public static JLabel AnswerLabel3;
    public static JLabel AnswerLabel4;
     public static JLabel AnswerLabel5;
     public static JLabel QuestionLabelQues;
  
     private Timer timer;
     private JButton finish;
     private JPanel finishPanel;
     
    

    // -------------------button List---------------------------------
    private JRadioButton a;
    private JRadioButton b;
    private JRadioButton c;
    private JRadioButton d;
    private JRadioButton e;
    //---------------------Group button-------------------------------------
    private ButtonGroup group;
    //--------------------- JPanel------------------------------------
    private JPanel QuestionPanel;
    private JPanel AnswerPanel;
    //------------------------------------------------------------------

    public static String FileName;
    public static ArrayList<String> quiz;
    public static ArrayList<Character> rightAns;
    private JButton nextQuestion;
  
    private int i =0;
    private int j=0;
    private int countRightQuestion=0;
    private int countWrongQuestion=0;
    private String time;
    private String ID;

    public Quiz(final String FileName,String ID)
    {
       
            this.ID=ID;
           setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            setVisible(true);

            setBackground(Color.gray);

           setLayout(new GridLayout(2,1));

        this.FileName=FileName;
        

        QuestionLabel = new JLabel();
        QuestionLabelQues = new JLabel("Question: ");
        AnswerLabel1 = new JLabel();
        AnswerLabel2= new JLabel();
        AnswerLabel3= new JLabel();
        AnswerLabel4= new JLabel();
        AnswerLabel5= new JLabel();
        nextQuestion = new JButton(new ImageIcon("start.jpg"));
        nextQuestion.addActionListener(this);
      

        QuestionPanel = new JPanel();
        AnswerPanel = new JPanel();
        quiz = new ArrayList<String>();
        rightAns = new ArrayList<Character>();

        a= new JRadioButton("a");
        a.setName("a");
        a.addActionListener(this);
        b= new JRadioButton("b");
        b.setName("b");
        b.addActionListener(this);
        c= new JRadioButton("c");
        c.setName("c");
        c.addActionListener(this);
        d= new JRadioButton("d");
        d.setName("d");
        d.addActionListener(this);
        e= new JRadioButton("e");
        e.setName("e");
        e.addActionListener(this);

        group = new ButtonGroup();
        group.add(a);
        group.add(b);
        group.add(c);
        group.add(d);
        group.add(e);
        finish = new JButton("Finish");
        finish.addActionListener(this);
        finishPanel = new JPanel();

      QuestionPanel.setLayout(new GridLayout(2,1));
      QuestionPanel.add(QuestionLabelQues);
      QuestionPanel.add(QuestionLabel);
      add(QuestionPanel);
      AnswerPanel.setLayout(new GridLayout(5,2));
      AnswerPanel.add(a);
      AnswerPanel.add(AnswerLabel1);

      AnswerPanel.add(b);
      AnswerPanel.add(AnswerLabel2);

      AnswerPanel.add(c);
      AnswerPanel.add(AnswerLabel3);

      AnswerPanel.add(d);
      AnswerPanel.add(AnswerLabel4);

      AnswerPanel.add(e);
      AnswerPanel.add(AnswerLabel5);

      add(AnswerPanel);
      finishPanel.add(finish);
      add(finishPanel);


     TimerTask  timerTask = new TimerTask()
       {
        public void run()
        {
            ReadFromFile(FileName);

            if(quiz.size()>=i-1)
            {
            do{


               QuestionLabel.setText(quiz.get(i));
               i++ ;
               AnswerLabel1.setText(quiz.get(i));
               i++;
               a.setEnabled(true);
               AnswerLabel2.setText(quiz.get(i));
               i++;
               b.setEnabled(true);
               AnswerLabel3.setText(quiz.get(i));
               i++;
               c.setEnabled(true);
               AnswerLabel4.setText(quiz.get(i));
               i++;
               d.setEnabled(true);
               AnswerLabel5.setText(quiz.get(i));
               i ++;
               e.setEnabled(true);
               rightAns.add(quiz.get(i).charAt(0));
               i++;
             




            }while(quiz.size()== i-1);}
            else
            {

              


            }


        }};
        timer = new Timer();
        timer.schedule(timerTask, 20, 5000);
   
      pack();
      

    }
    public void checkQuestion(String str )
    {
        if(rightAns.get(j)==(str.charAt(0)))
        {
            countRightQuestion++;
            j++;
        }
        else
        {
            countWrongQuestion++;
            j++;
        }
    }
    public static void ReadFromFile(String FileName)
    {
        String ALPHA = FileName +"QUIZQUESANS";
        File file = new File(ALPHA);


        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

    try
    {
      fis = new FileInputStream(file);


      bis = new BufferedInputStream(fis);
      dis = new DataInputStream(bis);


      while (dis.available() != 0)
      {

         quiz.add( dis.readLine());

      }


      fis.close();
      bis.close();
      dis.close();

    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
   
   
    

    public void actionPerformed(ActionEvent ex)
    {

            if(ex.getSource()==a)
            {
             
                
               checkQuestion(a.getName());
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
               
                
            }
            else if (ex.getSource() == b)
            {
                checkQuestion(b.getName());
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
                
            }
            else if(ex.getSource()==c)
            {
                checkQuestion(c.getName());
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
               
            }
            else if(ex.getSource()==d)
            {
                checkQuestion(d.getName());
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
                
            }
            else if(    ex.getSource()== e )
            {
                checkQuestion(e.getName());
                e.setSelected(false);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
                
            }
            if(ex.getSource()==finish)
            {

                System.out.println(countRightQuestion);
                System.out.println(countWrongQuestion);
                Result result = new Result(countRightQuestion,countWrongQuestion,ID);
                System.out.println( result.toString());
                finish.setEnabled(false);
                setVisible(false);
            }

        }
 
    
    
    



    
    
    

}
