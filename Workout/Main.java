import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.SwingUtilities;

public class Main extends AccountDB{

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new LoginMainframe();
            }
        });
        try {
			File obj = new File("Accounts.txt");
			if(obj.createNewFile())
			{
				System.out.println("Success");
			}
			else
			{
				recall();
			}
		}	catch(IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}

