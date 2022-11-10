import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainClass extends JFrame implements ActionListener

{
   public JButton addCourse;
   public JButton updateCourse;
   public JButton deleteCourse;
   public JButton listCourse;
   public JPanel leftPanel;
   public JPanel middlePanel;
   public JPanel rightPanel;

    
    public  MainClass()
    {

        addCourse = new JButton("ADD Course");
        addCourse.addActionListener(this);
       updateCourse  = new JButton("UPDATE Course");
       updateCourse.addActionListener(this);
       
        deleteCourse = new JButton("DELETE Course");
        deleteCourse.addActionListener(this);
        listCourse = new JButton ("LIST Course");
        listCourse.addActionListener(this);
        
        
        middlePanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        middlePanel.setLayout(new GridLayout(4,1));
        middlePanel.add(addCourse);
        middlePanel.add(updateCourse);
        middlePanel.add(deleteCourse);
        middlePanel.add(listCourse);
        this.setLayout(new FlowLayout());
        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
        
        
        
       this.setTitle("Course Appplication");
    
      
       this.setVisible(true);
       this.pack();
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == addCourse)
        {
            
            CourseAddition courseADDER = new CourseAddition(); 
        }
      
        if(e.getSource() == deleteCourse)
        {
            Connect c = new Connect();
            c.createDB();
            String[] a = c.contentOfCourses_Name();
            DeleteCourse courseDel = new DeleteCourse(a); 
        }
        if(e.getSource() == updateCourse)
           {
            Connect c = new Connect();
            c.createDB();
            String[] a = c.contentOfCourses_Name();
            UpdateCourse update_Course = new UpdateCourse(a); 
           }
         if(e.getSource() == listCourse)
        {
            Connect c = new Connect();
            c.createDB();
            c.contentOfCourses();
         
        }
    
    }
}
