
package videodatabase;


import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MediaInfoBoard extends JFrame implements ActionListener
{

     //Local Variables
    private int like=0;
    private int dislike=0;
    private JPanel TextAreaPanel;
    private JPanel TextFieldPanel;
    private JPanel RatioPanel;
    private JPanel LikeDislikePanel;
    private JPanel BackPanel;
    private JLabel StringRate;
    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;
    private ButtonGroup group;
    private JLabel RatioLabel;
    private JButton likeButton;
    private JButton dislikeButton;
    private JLabel LikedOrDislikedLabel;
    private JLabel showAllAppriciate;
    private JButton backButton;
    private JTextArea JTextArea;
    private JTextField textField;
    private JSplitPane jsp;
    private String FileName;
    private JButton saveText;
    private JLabel textFieldInfo;

   private JPanel panelAllForASplitPane;
   private JPanel panelAllForBSplitPane;
   private JPanel ButtonGroupPanel;
   private ArrayList<String> comment;


    private final static String newline = "\n";



    public MediaInfoBoard(String FileName)
    {
        this.FileName=FileName;
        comment= new ArrayList<String>();
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setBackground( Color.gray );
        

        //-------------------------
        panelAllForASplitPane = new JPanel();
        panelAllForBSplitPane = new JPanel();
        textField = new JTextField(50);
        JTextArea = new JTextArea(50,50);
         TextAreaPanel = new JPanel();
         TextFieldPanel = new JPanel();
         ButtonGroupPanel = new JPanel();
         RatioPanel  = new JPanel();
         LikeDislikePanel = new JPanel();
         BackPanel = new JPanel();
         StringRate = new JLabel("Rate:");
         button1 = new JRadioButton("1");
         button2= new JRadioButton("2");
         button3= new JRadioButton("3");
         saveText = new JButton("Save Text");
         group = new ButtonGroup();
         RatioLabel = new JLabel();
         likeButton = new JButton(new ImageIcon("like.jpg"));
         dislikeButton= new JButton(new ImageIcon("dislike.jpg"));
         LikedOrDislikedLabel = new JLabel();
         showAllAppriciate  = new JLabel();
         backButton= new JButton("Back");
         textFieldInfo = new JLabel();
        //-------------------------




          //------------------JTextArea----------------------------
         

        JTextArea = new JTextArea(40,50);
        JTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(JTextArea);

      
        TextAreaPanel.add(scrollPane);
        ReadFromFile(FileName);
        JTextArea.setText(toString());
       


     
                            
         //------------------TextFieldPanel-----------------------
          TextFieldPanel.setLayout(new GridLayout(3,1));
          TextFieldPanel.add(textField);
          saveText.addActionListener(this);
          TextFieldPanel.add(saveText);
          TextFieldPanel.add(textFieldInfo);
         //-----------------Ratio Panel-------------------------
         RatioPanel.setLayout(new GridLayout(3,1));
         RatioPanel.add(StringRate);
         group.add(button1);
         group.add(button2);
         group.add(button3);
         button1.addActionListener(this);
         button2.addActionListener(this);
         button3.addActionListener(this);
         ButtonGroupPanel.add(button1);
         ButtonGroupPanel.add(button2);
         ButtonGroupPanel.add(button3);
         RatioPanel.add(ButtonGroupPanel);
         RatioPanel.add( RatioLabel);

          //-----------------LikeDislikePanel-------------------------
         LikeDislikePanel.setLayout(new FlowLayout());
         likeButton.addActionListener(this);
         LikeDislikePanel.add(likeButton);
         LikeDislikePanel.add(LikedOrDislikedLabel);
         dislikeButton.addActionListener(this);
         LikeDislikePanel.add(dislikeButton);
         
         LikeDislikePanel.add(showAllAppriciate);
         //--------------Back Panel--------------------
         backButton.addActionListener(this);
         BackPanel.add(backButton);

         // -------------panelAllFor A SplitPane--------------------
         panelAllForASplitPane.add(TextAreaPanel);
         // -------------panelAllFor B SplitPane--------------------
         panelAllForBSplitPane.setLayout(new GridLayout(4,1));
         panelAllForBSplitPane.add(TextFieldPanel);
         panelAllForBSplitPane.add(RatioPanel);
         panelAllForBSplitPane.add(LikeDislikePanel);
         panelAllForBSplitPane.add(BackPanel);

         //Setting Up left Panel


		jsp = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		jsp.setLeftComponent(  panelAllForASplitPane);
		jsp.setRightComponent(panelAllForBSplitPane );

          
          add(jsp);
          pack();
          setVisible(true);

    }
    // ----------------------Those two Mehtods increase amount of like and dislike number
    public void like(){
        like++;
    }
    public void dislike(){
        dislike++;
    }
    //--------------------------Those two Mehtods shows amount of like and dislike number in Panel
    public String showLike(){
    	String tmp = "Your Like Rate is " + like+"/3";
        return tmp;
    }
    public String showDislike(){
    	String tmp = "Your Dislike Rate is " + dislike+"/3";
        return tmp;
    }
    private void saveComment(String str,String FileName)
    {
        String ALPHA = FileName +"Comment";
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
        public void ReadFromFile(String FileName)
        {
            String ALPHA = FileName +"Comment";
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
               comment.add(dis.readLine());
              

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

   public String toString()
   {
       String temp = "";
       if(comment.size()!=0)
       {
         for(int i = 0; i<comment.size();i++)
         {
            temp += comment.get(i);
         }
         
       }
       else
       {
        temp ="";
       }
        
       return temp;
   }




    public void actionPerformed(ActionEvent e)
    {
      
        if(e.getSource()==saveText)
        {
            String text = textField.getText();
            JTextArea.append(text + newline);
            textField.selectAll();
            saveComment(textField.getText(),FileName);
            textFieldInfo.setText("Your comment has been saved");
            

        }

        if(e.getSource()==button1 ||e.getSource()==button2 || e.getSource()==button3)
        {
            
            if(e.getSource()==button1)
            {
                like();
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                StringRate.setText(showLike());
                
            }
            else if(e.getSource() == button2)
            {
                like();
                like();
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                StringRate.setText(showLike());
            }
            else if(e.getSource() == button3)
            {
                like();
                like();
                like();
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                StringRate.setText(showLike());

            }
           
        }
            else if (e.getSource() == likeButton)
            {
                
                
                LikedOrDislikedLabel.setText("You liked");
                likeButton.setEnabled(false);
                dislikeButton.setEnabled(false);
             }
            else if (e.getSource() == dislikeButton)
            {
                    
                    LikedOrDislikedLabel.setText("You disliked");

                    dislikeButton.setEnabled(false);
                    likeButton.setEnabled(false);
            }
            else if(e.getSource()==backButton)
            {
                setVisible(false);
            }

            }
        }
    
    
