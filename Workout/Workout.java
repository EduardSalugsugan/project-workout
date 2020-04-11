import java.util.ArrayList;

public class Workout {
	
	private ArrayList<Exercise> workoutList;
	private String workoutName;
	
	public Workout() {
		workoutList = new ArrayList<Exercise>();
	}
	
	public Workout(String name) {
		setWorkoutName(name);
		workoutList = new ArrayList<Exercise>();
	}
	
	
	public void setWorkoutName(String name) {
		this.workoutName = name; 
	}
	
	public boolean addExercise(Exercise e) {
		
		workoutList.add(e);
		return true;
	}
	
	public void removeExercise(Object e) {
		if(e instanceof Exercise)
		workoutList.remove(e);
	}

}
