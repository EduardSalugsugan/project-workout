import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import java.io.IOException;

public class AccountDB extends Account{
	
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	//read from file to fill ArrayList accounts
	public static void recall() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Accounts.txt"));
			String s;
			String [] temp = new String[5];
			String tempA;
			String tempS;
			String tempW;
			String tempU;
			String tempP;
			while((s = br.readLine()) != null)
			{
				temp = s.split(",");
				tempA = temp[0];
				temp = s.split(",");
				tempS = temp[1];
				temp = s.split(",");
				tempW = temp[2];
				temp = s.split(",");
				tempU = temp[3];
				temp = s.split(",");
				tempP = temp[4];
				Account newA = new Account(tempA, tempS, tempW, tempU, tempP);
				accounts.add(newA);
			}
			br.close();
		}catch(IOException e)	{
			System.out.println("error");
			e.printStackTrace();
		}
	}

	//Writes to file to save new accounts
	public static void create(Account a) {
		accounts.add(a);
		try {
			PrintWriter myWrite = new PrintWriter("Accounts.txt");
			for(int i = 0; i < accounts.size(); i++)
			{
				myWrite.write(accounts.get(i).getAge() + ",");
				myWrite.write(accounts.get(i).getSex() + ",");
				myWrite.write(accounts.get(i).getWeight() + ",");
				myWrite.write(accounts.get(i).getUsername() + ",");
				myWrite.write(accounts.get(i).getPassword());
				myWrite.write("\n");
			}
			myWrite.close();
		}catch(IOException e)	{
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	//Searches for an account so that user can sign in
	//or tells account is not right
	public boolean Search(String user, String pass) {
		for(int i = 0; i < accounts.size(); i++)
		{
			String tempUser = accounts.get(i).getUsername();
			String tempPass = accounts.get(i).getPassword();
			
			if((user.equals(tempUser)) && pass.equals(tempPass))
				return true;
		}
		return false;
	}
	
	public boolean SearchSignUp(String user) {
		for(int i = 0; i < accounts.size(); i++)
		{
			String tempUser = accounts.get(i).getUsername();
			if(user.equals(tempUser))
			{
				return true;
			}
			
		}
		return false;
	}
}
