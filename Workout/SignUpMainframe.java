import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpMainframe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passLabel;
	private static JTextField passText;
	private static JLabel genderLabel;
	private static JTextField genderText;
	private static JLabel ageLabel;
	private static JTextField ageText;
	private static JLabel weightLabel;
	private static JTextField weightText;

	private static JButton createAccountButton;
	private static JLabel success;
    JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
    public SignUpMainframe()  {
    	
		frame.setResizable(false);
		frame.setSize(280,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);
		
		passText = new JPasswordField();
		passText.setBounds(100, 50, 165, 25);
		panel.add(passText);
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(10, 80, 80, 25);
		panel.add(ageLabel);
		
		ageText = new JTextField(2);
		ageText.setBounds(100, 80, 165, 25);
		panel.add(ageText);	
		
		weightLabel = new JLabel("Weight");
		weightLabel.setBounds(10, 110, 80, 25);
		panel.add(weightLabel);
		
		weightText = new JTextField(2);
		weightText.setBounds(100, 110, 165, 25);
		panel.add(weightText);

		genderLabel = new JLabel("Sex");
		genderLabel.setBounds(10, 140, 80, 25);
		panel.add(genderLabel);
		
		genderText = new JTextField(2);
		genderText.setBounds(100, 140, 165, 25);
		panel.add(genderText);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(100, 170, 150, 30);
		createAccountButton.addActionListener(this);
		panel.add(createAccountButton);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);

		frame.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		String pass = passText.getText();
		String age = ageText.getText();
		String sex = genderText.getText();
		String weight = weightText.getText();


	}
}