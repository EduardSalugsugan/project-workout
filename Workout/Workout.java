import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Workout {
	
	private ArrayList<Exercise> workoutList;
	private String workoutName;
	private static File workoutFile = new File("workouts.txt");
	
	
	public Workout() {
		workoutName = "";
		workoutList = new ArrayList<Exercise>();
	}
	
	public int length() {
		return workoutList.size();
	}
	
	public boolean isEmpty() {
		return workoutList.isEmpty();
	}
	
	public void remove(int i) {
		workoutList.remove(i);
	}
	
	public Exercise getExercise(int i) {
		return workoutList.get(i);
	}
	
	public void setWorkoutName(String name) {
		this.workoutName = name; 
	}
	
	public String getWorkoutName() {
		return workoutName;
	}
	
	public void addExercise(Exercise e) {
		workoutList.add(e);
	}
	
	
	
	public ObservableList<String> loadExercises() {
		ObservableList<String> viewList = FXCollections.observableArrayList();
		Exercise currentExercise;
		
		for(int i = 0; i < workoutList.size(); i++) {
			currentExercise = (Exercise)workoutList.get(i);
			viewList.add(currentExercise.getName());
		}
		return viewList;
		
	} //End of load exercises
	
	public void saveRoutine() throws IOException{
		
		if(!workoutFile.exists()) {
			System.out.println("New file created");
			workoutFile.createNewFile();
		}
		String line = "Name," + this.workoutName;
		
		try {
				
			FileWriter fr = new FileWriter(workoutFile.getAbsoluteFile(), true);
			BufferedWriter writer = new BufferedWriter(fr);
			writer.write(line + "\n");
			
			for(int i = 0; i < workoutList.size(); i++) {
				Exercise currentExercise = workoutList.get(i);
				writer.write(currentExercise.toString() + "\n");
				
			}
			writer.write("end\n");
			writer.close();
		}catch(IOException e) {
			System.out.println("I/O Exception");
		}
		
	}
	
	
	public static ArrayList<Workout> getAllWorkouts(){
		ArrayList<Workout> workoutList = new ArrayList<Workout>();
		Exercise newExercise;
		Workout currentWorkout = new Workout();
		
		try {
			FileReader fr = new FileReader(workoutFile.getAbsoluteFile());
			BufferedReader reader = new BufferedReader(fr);
			String line;
			
			while((line = reader.readLine()) != null) {
				String cell [] = line.split(",");

				if(cell[0].equalsIgnoreCase("end")) {
					workoutList.add(currentWorkout);
					currentWorkout = new Workout();
				}
				
				else if(cell[0].equalsIgnoreCase("Name")) {
					currentWorkout = new Workout();
					currentWorkout.setWorkoutName(cell[1]);
				}	
					
				else if(cell[0].equalsIgnoreCase("Strength")) {
					newExercise = new StrengthExercise(cell[1], cell[2], cell[3], cell[4], cell[5]);
					currentWorkout.addExercise(newExercise);
				}
				else if(cell[0].equalsIgnoreCase("Cardio")){
					newExercise = new CardioExercise(cell[1], cell[2]);
					currentWorkout.addExercise(newExercise);
				}
				
			}
			reader.close();
			
		}catch(FileNotFoundException f) { 
			System.out.println("File not found");
		}catch(IOException e) {
			System.out.println("IO Exception");
		}
		
		
		return workoutList;
	}
	
	public static ObservableList<String> loadWorkouts() {
		ObservableList<String> viewList = FXCollections.observableArrayList();
		Workout currentWorkout;
		ArrayList<Workout> list = getAllWorkouts();
		for(int i = 0; i < list.size(); i++) {
			currentWorkout = list.get(i);
			viewList.add(currentWorkout.getWorkoutName());
		}

		return viewList;
		
	} //End of load exercises
	
	

}
