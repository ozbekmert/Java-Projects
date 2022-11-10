package videodatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class StartingPage extends JFrame implements ActionListener
{

        // Buttons

        private JFrame MainFrame = new JFrame();
        private JPanel MainPanel1;
        private JPanel MainPanel2;
       
	private JButton regButton;
	private JButton exitButton;
	private JButton howToUseButton;
        private JButton LogInButton;
        private JLabel welcomeLabel;
        private JLabel MenuLabel;
        private ImageIcon gif;
        private URL ImageURL;
        private ImagePanel panel;
        private ImageIcon icon;
        private UserList list;


        public StartingPage(UserList list) throws Exception{

            this.list = list;
            MainPanel1 = new JPanel();
            MainPanel2 = new JPanel();
            
            regButton = new JButton("Register");
            exitButton = new JButton("Exit");
            howToUseButton = new JButton("How To Use");
            LogInButton = new JButton("Log-In");
            welcomeLabel = new JLabel("Welcome Video Database Program");
            MenuLabel = new JLabel("Menu Panel");
            MainPanel1.add(welcomeLabel);
            MainPanel2.add(MenuLabel);
            MainPanel2.add(LogInButton);
            MainPanel2.add(regButton);
            MainPanel2.add(howToUseButton);
            MainPanel2.add(exitButton);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500,500);
            setLocation(125,40);
            setVisible(true);
            setLayout(new FlowLayout());
            getContentPane().setBackground(Color.gray);
            

              add(MainPanel1);

            
                 icon =new ImageIcon("movie.gif");
                 panel = new ImagePanel(icon.getImage());
                 this.add(panel);

       
           add(MainPanel2);
                LogInButton.addActionListener(this);
                howToUseButton.addActionListener(this);
		exitButton.addActionListener(this);
		regButton.addActionListener(this);
           
        
        }
        public void actionPerformed(ActionEvent event){

                if(event.getSource()== LogInButton)
                {
                        LogInInterface log = new LogInInterface(list);
		}
		
		if(event.getSource()== howToUseButton)
                {
                    howToUseInterface htuse = new howToUseInterface();
		}
		if(event.getSource()== regButton)
                {
                    RegisterInterface regface = new RegisterInterface(list);
                }

		if(event.getSource()== exitButton)
                {
			System.exit(0);
		}

	}
}