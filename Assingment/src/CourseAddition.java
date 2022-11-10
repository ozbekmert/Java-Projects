import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CourseAddition extends JFrame implements ActionListener

{
   public JButton addButton;
   public JTextField nameField;
   public JTextField courseCodeField;
   public JTextField courseCreditField;
   public JTextField gradeField;
   
   public JLabel nameLabel;
   public JLabel CourseCodeLabel;
   public JLabel CourseCreditLabel;
   public JLabel CourseGradeLabel;
   
   public String coursename;
       public String coursecode;
       public String CourseCredit;
       public String grade;
   public Connect c;
  
   
   public JPanel leftPanel;
   public JPanel middlePanel;
   public JPanel rightPanel;

    
    public  CourseAddition()
    {
        c= new Connect();
        nameField = new JTextField(20);
        courseCodeField = new JTextField(20);
        courseCreditField = new JTextField(20);
        gradeField= new JTextField(20);
        
         nameLabel = new JLabel("Name: ");
        CourseCodeLabel= new JLabel("Course Code: ");
        CourseCreditLabel= new JLabel("Course Credit: ");
        CourseGradeLabel= new JLabel("Grade: ");
        
        
        middlePanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4,1));
        middlePanel.setLayout(new GridLayout(5,1));
        
        leftPanel.add(nameLabel);
        leftPanel.add(CourseCodeLabel);
        leftPanel.add(CourseCreditLabel);
        leftPanel.add(CourseGradeLabel);
        
        middlePanel.add( nameField);
        middlePanel.add(courseCodeField);
        middlePanel.add(courseCreditField);
        middlePanel.add(gradeField);
        addButton = new JButton("ADD");
        addButton.addActionListener(this);
        middlePanel.add(addButton);
        
       
        
        
        
        this.setLayout(new FlowLayout());
        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
        this.setTitle("Add Course");
        this.setVisible(true);
        this.pack();
        
        
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == addButton)
        {
          coursename = nameField.getText();
           coursecode = courseCodeField.getText();
            CourseCredit = courseCreditField.getText();
           grade = gradeField.getText();
           Connect c = new Connect();
           c.createDB();
           c.insertCourse_Name(coursename, coursecode,CourseCredit, grade);
           
           
            
        }
      
      
    }
    
}
