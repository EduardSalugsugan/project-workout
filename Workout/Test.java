import java.util.ArrayList;

public class Test {
	
	public static void main (String [] args) {
		ArrayList<StrengthExercise> exercises = StrengthExercise.getAllExercises();
		
		System.out.println(exercises.get(0).getName() +":" + exercises.get(0).getWeightType());
	}

}
