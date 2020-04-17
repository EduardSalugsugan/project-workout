import java.util.ArrayList;

public class Workout {
	
	private ArrayList<StrengthExercise> strengthWorkoutList;
	private ArrayList<CardioExercise> cardioWorkoutList;
	private String workoutName;
	private String type;
	
	public Workout(String workoutType) {
		workoutName = "";
		if(workoutType.equalsIgnoreCase("Strength")) {
			type = "Strength";
			strengthWorkoutList = new ArrayList<StrengthExercise>();
		}
		
		else {
			type = "Cardio";
			cardioWorkoutList = new ArrayList<CardioExercise>();
		}
	}
	
	public void setWorkoutName(String name) {
		this.workoutName = name; 
	}
	
	public String getWorkoutName() {
		return workoutName;
	}
	
	public void addStrengthExercise(StrengthExercise e) {
		strengthWorkoutList.add(e);
	}
	
	public void addCardioExericse(CardioExercise e) {
		cardioWorkoutList.add(e);
	}
	
	public void removeExercise(Object e) {
		if(e instanceof StrengthExercise)
			strengthWorkoutList.remove(e);
	}
	
	public int size() {
		if(type.equalsIgnoreCase("Strength")) {
			return strengthWorkoutList.size();
		}
		
		else
			return cardioWorkoutList.size();
	}
	

}
