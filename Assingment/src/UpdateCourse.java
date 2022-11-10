
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class UpdateCourse extends JFrame implements ActionListener

{
   public JButton updateButton;

   
   public JLabel nameLabel;
   public JLabel GradeLabel;
   public JLabel GPALabel;
   public JLabel GPALabel2;

   String[] Gradedata = {"AA", "BA", "BB", "CB","CC", "DC", "DD", "FD"};
  public String[] names;
   public JPanel upperPanel;
   public JPanel middlePanel;
   public JPanel lowerPanel;
   public JPanel buttonPanel;
public String selectedGrade;
public String selectedCourse;
public  JComboBox comboBox1;
public  JComboBox comboBox2;
    
    public  UpdateCourse(String[] names)
    {
        this.names=names;
        
       upperPanel = new JPanel();
       upperPanel.setLayout(new FlowLayout());
       nameLabel = new JLabel("Name");
       upperPanel.add(nameLabel);
       comboBox2 = new JComboBox(names);
       comboBox2.setMaximumRowCount(10);
       comboBox2.addActionListener(this);
       upperPanel.add(comboBox2);
      
       
       
       middlePanel = new JPanel();
       middlePanel.setLayout(new FlowLayout());
       GradeLabel = new JLabel("Grade: ");
       middlePanel.add(GradeLabel);
       
      comboBox1 = new JComboBox(Gradedata);
       comboBox1.setMaximumRowCount(10);
       comboBox1.addActionListener(this);
       
       middlePanel.add(comboBox1);
        
       lowerPanel = new JPanel();
       lowerPanel.setLayout(new FlowLayout());
      GPALabel = new JLabel("GPA");
       GPALabel2 = new JLabel("  will change as program works ");
       lowerPanel.add(GPALabel);
       lowerPanel.add(GPALabel2);
       
        buttonPanel = new JPanel();
        updateButton = new JButton("UPDATE");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);
      
        
        
        this.setLayout(new GridLayout(4,1));
        this.add(upperPanel);
        this.add( middlePanel);
        this.add(lowerPanel);
        this.add(buttonPanel);
        
        
        this.setTitle("Update Course");
        this.setVisible(true);
        this.pack();
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource() == comboBox1 )
        {
        selectedGrade = (String) comboBox1.getSelectedItem();
            System.out.println(selectedGrade);
        
        }
        if (e.getSource() == comboBox2)
        {
        selectedCourse = (String) comboBox2.getSelectedItem();
            System.out.println(selectedCourse);
        
        }
        
            
        if(e.getSource() == updateButton)
        {
         Connect c = new Connect();
         c.createDB();
         c.updateContentOfCourses(selectedCourse, selectedGrade);
       
           
        }
      
      
    }
}
