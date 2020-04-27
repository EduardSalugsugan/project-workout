import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class workoutTrackingPage {

	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static Workout thisWorkout;
	private static int numberOfExercisesInWorkout;
	
	
	public static void display(Workout w) {
		window.setOnCloseRequest(e -> window.close());
		thisWorkout = w;
		numberOfExercisesInWorkout = thisWorkout.length();
		setWindow();
		
	}
	
	public static void setWindow() {
		
		window.setTitle(thisWorkout.getWorkoutName());
		window.centerOnScreen();
		layout = createWorkoutTrackerPage();
		page = new Scene(layout, 800, 500);
		window.setScene(page);
		window.show();
		
	}
	
	public static GridPane createWorkoutTrackerPage() {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setVgap(20);
		pane.setHgap(10);
		Label name = new Label("Exercise name");

		name.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));

		
		pane.add(name, 0, 0);

		
		for(int i = 0; i < numberOfExercisesInWorkout; i++) {
			Label nameLabel = new Label(thisWorkout.getExercise(i).getName());
			nameLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
			pane.add(nameLabel, 0, i + 1);
			if(thisWorkout.getExercise(i).getType().equalsIgnoreCase("Strength")) {
				Label weightUsed = new Label("Weight used:");
				weightUsed.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				TextField weightBox = new TextField();
				weightBox.setPrefWidth(50);
				pane.add(weightUsed, 1, i + 1);
				pane.add(weightBox, 2, i + 1);
				
				Label reps = new Label("Reps completed:");
				TextField repBox = new TextField();
				repBox.setPrefWidth(50);
				pane.add(reps, 3, i + 1);
				pane.add(repBox, 4, i + 1);
				


			}
			
			if(thisWorkout.getExercise(i).getType().equalsIgnoreCase("Cardio")) {
				Label resistanceLevel = new Label("Resistance Level: ");
				resistanceLevel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				TextField resistanceBox = new TextField();
				resistanceBox.setPrefWidth(50);
				pane.add(resistanceLevel, 1, i + 1);
				pane.add(resistanceBox, 2, i + 1);
			}
			
		}
		
		return pane;
	}
	
	
}
