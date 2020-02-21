import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Account extends JFrame{
	private String age;
	private String sex;
	private String weight;
	private String password;
	private String username;
	
	public Account() {
		age = null;
		sex = null;
		weight = "";
		password = null;
		username = null;
	}
	
	public Account(String a, String s, String w, String u, String p) {
		age = a;
		sex = s;
		password = p;
		username = u;
		weight = w;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAge(String a) {
		age = a;
	}
	
	public void setSex(String s) {
		sex = s;
	}
	
	public void setWeight(String w) {
		weight = w;
	}
	
	public void setUsername(String u) {
		username = u;
	}
	
	public void setPassword(String p) {
		password = p;
	}
}