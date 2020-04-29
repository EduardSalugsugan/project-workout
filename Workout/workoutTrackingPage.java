import java.io.File;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
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
	private static Workout completedWorkout;
	private static Exercise currentExercise;
	private static StrengthExercise currentStrength;
	private static CardioExercise currentCardio;
	private static int numberOfExercisesInWorkout;
	private static boolean finalButton = false;
	private static Button exerciseComplete;
	private static int index;
	private static Label nameLabel;
	private static TextField resistanceLog;
	private static Label weightLabel;

	
	
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
		page = new Scene(layout, 1000, 600);
		window.setScene(page);
		window.sizeToScene();
		window.show();
		
	}
	
	public static GridPane createWorkoutTrackerPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		//pane.setGridLinesVisible(true);
		pane.setVgap(20);
		pane.setHgap(10);
		completedWorkout = new Workout();

		Button beginWorkout = new Button("Begin Workout");
		beginWorkout.setOnAction(e -> {
			index = 0;
			pane.getChildren().remove(beginWorkout);
			logExercises(index, pane);	
			
		});
		pane.add(beginWorkout, 0, 0);

		
		return pane;
	}
	
	private static void logExercises(int index, GridPane pane) {
		

		pane.setAlignment(Pos.TOP_CENTER);
		Label name = new Label("Exercise name");
		name.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		

		if(index >= numberOfExercisesInWorkout) {
			Button finishWorkout = new Button("Finish Workout");
			finishWorkout.setOnAction(e ->{
				saveCompletedWorkout(completedWorkout);
			});
			pane.add(finishWorkout, 0, index + 1);
			return;
		}
		
		
		currentExercise = thisWorkout.getExercise(index);
		nameLabel = new Label(currentExercise.getName());
		nameLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		
		if(currentExercise.getType().equalsIgnoreCase("Strength")) {
			
			currentStrength = (StrengthExercise) currentExercise;
			if(currentStrength.getWeightType().equalsIgnoreCase("Free Weights")) {
				Label weightUsed = new Label("Weight(lbs):");
				weightUsed.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				resistanceLog = new TextField();
				resistanceLog.setPrefWidth(50);
				pane.add(weightUsed, 1, index + 1);
				pane.add(resistanceLog, 2, index + 1);
				
				Label repLabel = new Label("Reps:");
				repLabel.setFont(Font.font("Arial", FontWeight.BOLD,14));
				TextField repLog = new TextField();
				repLog.setPrefWidth(50);
				pane.add(repLabel, 3, index + 1);
				pane.add(repLog, 4, index + 1);
				
				Label setLabel = new Label("Sets:");
				setLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				TextField setField = new TextField();
				setField.setPrefWidth(50);
				
				pane.add(setLabel, 5, index + 1);
				pane.add(setField, 6, index + 1);
				
				exerciseComplete = new Button("Exercise Complete");
				pane.add(nameLabel, 0, index + 1);
				pane.add(exerciseComplete, 7, index + 1);
				
				exerciseComplete.setOnAction(e ->{
					currentStrength.setWeightUsed(Integer.parseInt(resistanceLog.getText()));
					currentStrength.setRepitions(Integer.parseInt(repLog.getText()));
					currentStrength.setRepitions(Integer.parseInt(setField.getText()));
					completedWorkout.addExercise(currentStrength);
					int i = index + 1;
					logExercises(i, pane);
				});
			}
			
			if(currentStrength.getWeightType().equalsIgnoreCase("Body weight")) {
				Label repLabel = new Label("Reps:");
				repLabel.setFont(Font.font("Arial", FontWeight.BOLD,14));
				TextField repLog = new TextField();
				repLog.setPrefWidth(50);
				pane.add(repLabel, 1, index + 1);
				pane.add(repLog, 2, index + 1);
				
				Label setLabel = new Label("Sets:");
				setLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
				TextField setField = new TextField();
				setField.setPrefWidth(50);
				
				pane.add(setLabel, 3, index + 1);
				pane.add(setField, 4, index + 1);
				
				exerciseComplete = new Button("Exercise Complete");
				pane.add(nameLabel, 0, index + 1);
				pane.add(exerciseComplete, 7, index + 1);
				
				exerciseComplete.setOnAction(e ->{
					currentStrength.setRepitions(Integer.parseInt(repLog.getText()));
					currentStrength.setSets(Integer.parseInt(setField.getText()));
					completedWorkout.addExercise(currentStrength);
					int i = index + 1;
					logExercises(i, pane);
				});
			}


		}
		
		else if(currentExercise.getType().equalsIgnoreCase("Cardio")) {
			currentCardio = (CardioExercise) currentExercise;
			
			Label resistanceLevel = new Label("Resistance Level: ");
			resistanceLevel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
			TextField resistanceBox = new TextField();
			resistanceBox.setPrefWidth(50);
			pane.add(resistanceLevel, 1, index + 1);
			pane.add(resistanceBox, 2, index + 1);
			
			exerciseComplete = new Button("Exercise Complete");
			pane.add(nameLabel, 0, index + 1);
			pane.add(exerciseComplete, 7, index + 1);
			
			exerciseComplete.setOnAction(e ->{
				int i = index + 1;
				logExercises(i, pane);
			});
			
		}
		
		
	}
	
	public static void saveCompletedWorkout(Workout completedWorkout) {
		
		

		for(int i = 0; i < completedWorkout.length(); i++) {
			StrengthExercise thisExercise = (StrengthExercise)completedWorkout.getExercise(i);
			System.out.println(thisExercise + ", " +thisExercise.getWeightUsed() + ", " +thisExercise.getRepitions() );
		}
		
	}
	
	
	
	
}
