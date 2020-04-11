import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise {
	

	private String name;
	private String type;
	private int timeToComplete;
	
	public Exercise() {
		name = "";
		type = "";
		timeToComplete = 0;
	}
	public Exercise(String n, String t) {
		setName(n);
		setType(t);	
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setTimeToComplete(int t) {
		timeToComplete = t;
	}

	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		
		return(this.getName() + ", " + this.getType());
		
	}
	
	public boolean equals(Exercise e) {
		
		if(this.getName().equalsIgnoreCase(e.getName()))
			return true;
		
		else return false;
		
	}
	
	//Method to fill an ArrayList with exercises that are saved in an text file
	public static ArrayList<Exercise> getAllExercises(String fileName) {
		ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
		Exercise currentExercise;
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line = reader.readLine()) != null) {
				String [] cell = line.split(",");
				currentExercise = new Exercise(cell[0], cell[1]);
				exerciseList.add(currentExercise);
			}
			reader.close();
		
		}catch(FileNotFoundException f) {
			System.out.println("File not found");
		}//End of catch
		
		catch(IOException i) {
			System.out.println("IO exception");
		}
		
		
		return exerciseList;
	}

}
