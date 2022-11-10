package videodatabase;
import javax.swing.*;

public class MyJButton extends JButton
{
        //Class Variable
	private String title;
        //Constructor
	public MyJButton(String title){
		super(title);
		this.title=title;
	}
        // Return Button Name
	public String getName(){
		return title;
	}

}