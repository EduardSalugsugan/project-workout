import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Workout {
	
	private ArrayList<Exercise> workoutList;
	private String workoutName;
	private String type;
	
	public Workout() {
		workoutName = "";
		workoutList = new ArrayList<Exercise>();
	}
	
	public int length() {
		return workoutList.size();
	}
	
	public void remove(int i) {
		workoutList.remove(i);
	}
	
	public Exercise get(int i) {
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
	

}
