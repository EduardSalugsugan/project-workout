import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CardioExercise extends Exercise{
	
	private int resistanceLevel;
	private int laps;
	private double lapTime;
	private static String fileName = "cardioexercises.txt";
	public final String type = "Cardio";
	//private int timeToComplete;
	
	public CardioExercise() {
		name = "";
		resistanceLevel = 0;
		equiptmentNeeded = "";
		laps = 0;
		lapTime = 0;
		timeToComplete = 0;
		
	}
	
	public CardioExercise(String n, String equiptment) {
		name = n;
		equiptmentNeeded = equiptment;
	}

	
	public int getResistanceLevel() {
		return resistanceLevel;
	}

	public void setResistanceLevel(int resistanceLevel) {
		this.resistanceLevel = resistanceLevel;
	}

	public int getLaps() {
		return laps;
	}

	public void setLaps(int laps) {
		this.laps = laps;
	}

	public double getLapTime() {
		return lapTime;
	}

	public void setLapTime(double lapTime) {
		this.lapTime = lapTime;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return this.type + "," + this.name + "," + this.equiptmentNeeded;
	}
	
	public static ArrayList<CardioExercise> getAllExercises() {
		ArrayList<CardioExercise> exerciseList = new ArrayList<CardioExercise>();
		CardioExercise currentExercise;
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line = reader.readLine()) != null) {
				String [] cell = line.split(",");
				currentExercise = new CardioExercise();
				currentExercise.setName(cell[0]);;
				currentExercise.setEquiptmentNeeded(cell[1]);
				
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
	
	
	
	
	public static ObservableList<String> loadExercises() {
		ObservableList<String> viewList = FXCollections.observableArrayList();
		CardioExercise currentExercise;
		ArrayList<CardioExercise> list = getAllExercises();
		for(int i = 0; i < list.size(); i++) {
			currentExercise = (CardioExercise)list.get(i);
			viewList.add(currentExercise.getName());
		}
		return viewList;
		
	} //End of load exercises
	

}
