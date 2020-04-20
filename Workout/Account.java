import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Account {
	private String username;
	private String password;
	private int age;
	private String gender;
	private int weight;


	public Account() {
		username = null;
		password = null;
		age = 0;
		gender = null;
		weight = 0;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public int getWeight() {
		return weight;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setGender(String s) {
		gender = s;
	}

	public void setWeight(int w) {
		weight = w;
	}

	public void setUsername(String u) {
		username = u;
	}

	public void setPassword(String p) {
		password = p;
	}
	
	public static ArrayList<Account> getAllAccounts(String fileName){
		ArrayList <Account> accountList = new ArrayList<Account>();
		Account currentAccount;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line = reader.readLine()) != null) {
				String[] cell = line.split(",");
				currentAccount = new Account();
				currentAccount.setUsername(cell[0]);
				currentAccount.setPassword(cell[1]);
				currentAccount.setAge(Integer.parseInt(cell[2]));
				currentAccount.setGender(cell[3]);
				currentAccount.setWeight(Integer.parseInt(cell[4]));
				accountList.add(currentAccount);
			}
			reader.close();	
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found");
		}
		catch(IOException i) {
			System.out.println("IO exception");
		}		
		return accountList;	
	}
	
	
	public static Account getCurrentAccount() {
		Account currentAccount = new Account();
		try {
			FileReader fr = new FileReader("currentAccount.txt");
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			String[] cell = line.split(",");
			currentAccount.setUsername(cell[0]);
			currentAccount.setPassword(cell[1]);
			currentAccount.setAge(Integer.parseInt(cell[2]));
			currentAccount.setGender(cell[3]);
			currentAccount.setWeight(Integer.parseInt(cell[4]));
			reader.close();			
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println("IO exception");
		}
		return currentAccount;
	
	}
} 