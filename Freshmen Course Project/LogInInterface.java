package videodatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LogInInterface extends JFrame implements ActionListener
{
	//class variables
	private JLabel passwordLabel = new JLabel("Password: ");
	private JLabel IDLabel = new JLabel("ID: ");
	private JTextField IDField = new JTextField(7);
	private JPasswordField passwordField = new JPasswordField(7);
	private JButton logInAsUserButton = new JButton("Log-In As User");
	private JButton logInAsAdminButton = new JButton("Log-In As Admin");
	private JButton backButton = new JButton("Back");
	private JLabel errorLabel = new JLabel("");
	private UserList userList;





	//constructor
	public LogInInterface(UserList userList){

		this.userList = userList;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(280,150);
		setLocation(645,250);
		setVisible(true);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.gray);


		add(IDLabel);
		add(IDField);
		add(passwordLabel);
		add(passwordField);
		add(logInAsUserButton);
                add(logInAsAdminButton);
		add(errorLabel);
		add(backButton);

		backButton.addActionListener(this);
		logInAsUserButton.addActionListener(this);
                logInAsAdminButton.addActionListener(this);
	}
        //Controls different login scenario  and handle wrong pass or ID
	public void actionPerformed(ActionEvent event)
        {
            // -------------------------------------------------------------LOGIN-------------------------
             // ------------------------------------------------------------------------------------------                if(event.getSource()==logInAsAdminButton)
            if(event.getSource() == logInAsAdminButton)
            {
                  
                  if(passwordField.getText().equals("")|| passwordField.getText().equals(""))
                  {
			errorLabel.setText("Please fill the empty fields!");
		  }
		  if(userList.IDandPasswordInSameOrderForAdmin(IDField.getText(),(passwordField.getText())))
                  {
				AdminBoard AdminBoard  = new AdminBoard(IDField.getText(),passwordField.getText());
				setVisible(false);
		  }
		  if(userList.containsGivenIDForAdmin(IDField.getText())==false||userList.containsGivenIDForAdmin(IDField.getText())==false)
                  {
		      errorLabel.setText("Admin, one of the ID or Password is wrong.");
		  }



                }
                 // -------------------------------------------------------------LOGIN-------------------------
                // ------------------------------------------------------------------------------------------
		if(event.getSource() == logInAsUserButton)
                {
                    
                    if(passwordField.getText().equals("")|| passwordField.getText().equals(""))
                    {
				errorLabel.setText("Please fill the empty fields!");
                    }
                    if(userList.IDandPasswordInSameOrderForUser(IDField.getText(),passwordField.getText()))
                    {
                        UserBoard UserBoard  = new UserBoard(IDField.getText(),passwordField.getText());
			setVisible(true);
                    }
                    if(userList.containsGivenIDForUser(IDField.getText())==false||userList.containsGivenIDForUser(IDField.getText())==false)
                    {
				errorLabel.setText("Dear Student, one of the ID or Password is wrong.");
                    }



		}
		if(event.getSource() == backButton)
                {
			setVisible(false);
		}
	}
}

