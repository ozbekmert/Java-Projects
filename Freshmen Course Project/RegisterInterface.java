package videodatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterInterface extends JFrame implements ActionListener
{
	// Class Variable
        private JCheckBox registerAsUser;
        private JCheckBox registerAsAdmin;
        private ButtonGroup group;
        private JLabel panelcheck;
        private JLabel panelcheck1;
        private JLabel panelcheck2;
        private JLabel panelcheck3;
        private JPanel MainPanel;
        private JPanel MainPanel2;
        private JLabel errorLabel;
        private JTextField field;
        private JPasswordField field2;
        private JPasswordField copyfield2;
        private JButton saveButton;
        private boolean flag;
        private UserList UserList;
        private JButton back;

        //Constructor takes Userlist because this method is core component for registiration
	public RegisterInterface(UserList UserList)
        {
               this.UserList = UserList;
	       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
             
		setSize(550,400);
		setLocation(400,400);
		setLayout(new GridLayout(4, 4));

		getContentPane().setBackground(Color.gray);

                

                panelcheck = new JLabel("Usertype:");
                 panelcheck1 = new JLabel("ID :");
                panelcheck2 = new JLabel("Password: ");
                panelcheck3 = new JLabel("Re-write: ");
                saveButton = new JButton("Save");
                back = new JButton("Back");
                saveButton.addActionListener(this);
                back.addActionListener(this);

                MainPanel = new JPanel();
                MainPanel2 = new JPanel();
                MainPanel.add(panelcheck);
                group = new ButtonGroup();
                //---------------------------------------------------------------------
                //--------------------Adding Radio Button-------------------------------------
                registerAsUser = new JCheckBox("Register As User");
                
                registerAsUser.addActionListener(this);
                MainPanel.add(registerAsUser);
                group.add(registerAsUser);
                //---------------------------------------------------------------------
                //-------------------Adding Radio Button----------------------
                registerAsAdmin = new JCheckBox("Register As Admin");
                registerAsAdmin.setSelected(true);
                 registerAsAdmin.addActionListener(this);
                MainPanel.add(registerAsAdmin);
                group.add(registerAsAdmin);
                //------------------------Adding JPASSFIELD----------------------------
                field = new JTextField(10);
                field2 = new JPasswordField(10);
                copyfield2= new JPasswordField(10);
               MainPanel2.add(panelcheck1);
               MainPanel2.add(field);
               MainPanel2.add(panelcheck2);
               MainPanel2.add(field2);
               MainPanel2.add(panelcheck3);
               MainPanel2.add(copyfield2);
               MainPanel2.add(saveButton);
               MainPanel2.add(back);
               errorLabel = new JLabel();
               MainPanel2.add(errorLabel);
               
               

                //------------------------------Adding All to Frame------------------------
                add(MainPanel);
                add(MainPanel2);
                
		setVisible(true);
	}
     
	public void actionPerformed(ActionEvent event)
        {
          if(event.getSource()==back){
              setVisible(false);
          }

          if(event.getSource()==registerAsAdmin)
          {
               flag = false;
          }
          else if(event.getSource()== registerAsUser){
               flag = true;
          }


          if(event.getSource()== saveButton)
          {
              if(flag==true)
              {//----------------------------------------------------------------------------------------------------
                  //--------------------------------------------------Register Core-----------------------------------
                 if(field.getText().equals("") || field2.getText().equals("") || copyfield2.getText().equals("") )
                 {
                    errorLabel.setText("Please fill the empty fields!");
		 }
                 if(!field2.getText().equals(copyfield2.getText()))
                 {
                     errorLabel.setText("The Password you entered did not match,please re-write");
                 }
                 if(!UserList.containsGivenPasswordForUser(field2.getText())&&!UserList.containsGivenIDForUser(field.getText())&&(field2.getText()).equals(copyfield2.getText()))
                  {
		
                      UserList.addPasswordToUserArrayList(field2.getText());
                      UserList.addIDToUserArrayList(field.getText());
                      errorLabel.setText("Dear "+ field.getText() +", your account is created successfully.");
		}
		else if(UserList.containsGivenPasswordForUser(field2.getText())||UserList.containsGivenIDForUser(field.getText()))
                {
                        errorLabel.setText("ID has already been used.");
		}
            }
            if(flag == false)
            {
                if(field2.getText().equals("") || copyfield2.getText().equals("") ||field.getText().equals(""))
                 {
                    errorLabel.setText("Please fill the empty fields!");
		 }
                 if(!field2.getText().equals(copyfield2.getText()))
                 {
                     errorLabel.setText("The Password you entered did not match,please re-write");
                 }
                 if(!UserList.containsGivenPasswordForAdmin(field2.getText())&&!UserList.containsGivenIDForAdmin(field.getText())&&(field2.getText()).equals(copyfield2.getText()))
                  {

                      UserList.addPasswordToAdminArrayList(field2.getText());
                      UserList.addIDToAdminArrayList(field.getText());
                      errorLabel.setText("Dear "+ field.getText() +", your account is created successfully.");
		}
		else if(UserList.containsGivenPasswordForAdmin(field2.getText())||UserList.containsGivenIDForAdmin(field.getText()))
                {
                        errorLabel.setText("ID or password has already been used.");
		}
            }

            }
        }
}


        

