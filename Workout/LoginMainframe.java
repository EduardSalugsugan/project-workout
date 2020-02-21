import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginMainframe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passLabel;
	private static JTextField passText;
	private static JButton loginButton;
	private static JButton signUpButton;
	private static JLabel success;
    JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
    public LoginMainframe()  {
    	
		frame.setResizable(false);
		frame.setSize(280,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(10,50,80,25);
		panel.add(passLabel);
		
		passText = new JPasswordField();
		passText.setBounds(100, 50, 165, 25);
		panel.add(passText);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		signUpButton = new JButton("Sign up");
		signUpButton.setBounds(180, 80, 80, 25);
		signUpButton.addActionListener(this);
		panel.add(signUpButton);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);

		frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String pass = passText.getText();
		
		if (user.equals("Eduard") && pass.equals("Eduard")) {
			success.setText("Login Succesful");
		}
		else {
			success.setText("Wrong Username or Password");
		}
		frame.dispose();
		new SignUpMainframe();
		
	}
}