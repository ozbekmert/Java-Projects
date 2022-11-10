import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DeleteCourse extends JFrame implements ActionListener

{
   public JButton deleteButton;
   public String selectedCourse;
   public JTextField nameField;
   public JTextField courseCodeField;
   public JTextField courseCreditField;
   public JTextField gradeField;
   
   public JLabel nameLabel;
   public JLabel GradeLabel;
   public JLabel GPALabel;
   public JLabel GPALabel2;

   
  
   public JPanel upperPanel;
   public JPanel middlePanel;
   public JPanel lowerPanel;
   public JPanel buttonPanel;
    public  JComboBox comboBox2;
    public String[] names;
    public  DeleteCourse(String[] names)
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
       
       
       lowerPanel = new JPanel();
       lowerPanel.setLayout(new FlowLayout());
       GPALabel = new JLabel("GPA");
       GPALabel2 = new JLabel("  will change as program works ");
       lowerPanel.add(GPALabel);
       lowerPanel.add(GPALabel2);
     
       
        buttonPanel = new JPanel();
        deleteButton = new JButton("DELETE");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);
        
        
        this.setLayout(new GridLayout(4,1));
        this.add(upperPanel);
        this.add(lowerPanel);
        this.add(buttonPanel);
        
        
        this.setTitle("Delete Course");
        this.setVisible(true);
        this.pack();
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource() == comboBox2)
        {
        selectedCourse = (String) comboBox2.getSelectedItem();
            System.out.println(selectedCourse);
        
        }
        if(e.getSource() == deleteButton)
        {
            Connect c = new Connect();
            c.createDB();
            c.deleteContentOfCourses(selectedCourse);
        
        }
      
      
    }
}
