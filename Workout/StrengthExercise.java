import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StrengthExercise {
	
	public final static String [] upperMuscleGroups = {"Shoulders", "Chest", "Biceps", "Triceps", "Forearms", "Abs", "Upper Back"};
	public final static String [] lowerMuscleGroups = {"Quadriceps" , "Glutes" , "Hamstrings", "Calves", "Lower Back"};
	private String name;
	private String targetMuscleArea;
	private String mainTargetMuscle;
	private String equiptmentNeeded;
	private String weightType;
	private int timeToComplete;
	
	//Instance variables to be set during actual workout
	private int weightUsed;
	private int repitions;
	private int sets;
	
	public StrengthExercise() {
		name = "";
		targetMuscleArea = "";
		timeToComplete = 0;
		mainTargetMuscle = "";
		equiptmentNeeded ="";
		weightType = "";
		weightUsed = 0;
		repitions = 0;
		sets = 0;
	}
	
	public void setName(String n) {
		name =n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setMainTargetMuscle(String targetMuscle) {
		
		mainTargetMuscle = targetMuscle;
		
	}
	
	public String getMainTargetMuscle() {
		return mainTargetMuscle;
	}
	
	public String getEquiptmentNeeded() {
		return equiptmentNeeded;
	}

	public void setEquiptmentNeeded(String equiptment) {
		equiptmentNeeded = equiptment;
	}

	public String getTargetMuscleArea() {
		return targetMuscleArea;
	}

	public void setTargetMuscleArea(String targetMuscleArea) {
		this.targetMuscleArea = targetMuscleArea;
	}

	public String getWeightType() {
		return weightType;
	}

	public void setWeightType(String weightType) {
		this.weightType = weightType;
	}

	public int getWeightUsed() {
		return weightUsed;
	}

	public void setWeightUsed(int weightUsed) {
		this.weightUsed = weightUsed;
	}

	public int getRepitions() {
		return repitions;
	}

	public void setRepitions(int repitions) {
		this.repitions = repitions;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public boolean equals(StrengthExercise exercise) {
		if(exercise.getName().equals(name))
			return true;
		
		return false;
			
	}
	
	public static ArrayList<StrengthExercise> getAllExercises(String fileName) {
		ArrayList<StrengthExercise> exerciseList = new ArrayList<StrengthExercise>();
		StrengthExercise currentExercise;
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line = reader.readLine()) != null) {
				String [] cell = line.split(",");
				currentExercise = new StrengthExercise();
				currentExercise.setName(cell[0]);
				currentExercise.setTargetMuscleArea(cell[1]);
				currentExercise.setMainTargetMuscle(cell[2]);
				currentExercise.setWeightType(cell[3]);
				currentExercise.setEquiptmentNeeded(cell[4]);
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
	
	//Load all of the exercises in the given file into an Observable list to be displayed 
	public static ObservableList<String> loadExercises(String fileName) {
		ObservableList<String> viewList = FXCollections.observableArrayList();
		StrengthExercise currentExercise;
		ArrayList<StrengthExercise> list = getAllExercises(fileName);
		for(int i = 0; i < list.size(); i++) {
			currentExercise = (StrengthExercise)list.get(i);
			viewList.add(currentExercise.getName());
		}
		return viewList;
		
	} //End of load exercises


}
