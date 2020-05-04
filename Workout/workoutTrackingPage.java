import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
	private static CheckBox hasLaps;
	private static CheckBox hasResistance;
	private static CheckBox hasDistance;
	private static int index;
	private static Label nameLabel;

	private static Label weightLabel;
	private static Label lapLabel;
	private static TextField lapLog;
	private static Label resistanceLabel;
	private static TextField resistanceLog;
	private static Label distanceLabel;
	private static TextField distanceLog;
	private static ArrayList<Workout> completedWorkoutList;
	private static File completedWorkoutFile = new File("completedWorkouts.txt");
	
	
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
		completedWorkout.setWorkoutName(thisWorkout.getWorkoutName());

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
		

		//final long start = System.currentTimeMillis();
		pane.setAlignment(Pos.TOP_CENTER);
		Label name = new Label("Exercise name");
		name.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		

		if(index >= numberOfExercisesInWorkout) {
			Button finishWorkout = new Button("Finish Workout");
			finishWorkout.setOnAction(e ->{
				try {
					completedWorkout.saveCompletedWorkout();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				window.close();
				workoutPage.display();
			});
			
			GridPane.setHalignment(finishWorkout, HPos.CENTER);
			pane.add(finishWorkout, 0, index + 1, 9, 1);
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
					resistanceLog.setDisable(true);
					repLog.setDisable(true);
					setField.setDisable(true);
					exerciseComplete.setText("Completed");
					exerciseComplete.setDisable(true);
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
					repLog.setDisable(true);
					setField.setDisable(true);
					exerciseComplete.setText("Completed");
					exerciseComplete.setDisable(true);
					int i = index + 1;
					logExercises(i, pane);
				});
			}


		}
		
		////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////
		///////////////////////Cardio Exercises/////////////////////////
		////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////
		else if(currentExercise.getType().equalsIgnoreCase("Cardio")) {
			currentCardio = (CardioExercise) currentExercise;
			
			hasLaps = new CheckBox("Did laps");
			hasResistance = new CheckBox("Used resistance");
			hasDistance = new CheckBox("Tracked distance");
			
			VBox checkBoxes = new VBox();
			checkBoxes.getChildren().addAll(hasLaps, hasResistance, hasDistance);
			
			hasLaps.setOnAction(e ->{
				if(hasLaps.isSelected()) {
					lapLabel = new Label("Laps Completed:");
					lapLog = new TextField();
					lapLog.setPrefWidth(50);
					pane.add(lapLabel, 2, index + 1);
					pane.add(lapLog, 3, index + 1);
				}
				else {
					pane.getChildren().removeAll(lapLabel, lapLog);
				}
			});
			
			hasResistance.setOnAction(e ->{
				if(hasResistance.isSelected()) {
					resistanceLabel = new Label("Resistance Level:");
					resistanceLog = new TextField();
					resistanceLog.setPrefWidth(50);
					pane.add(resistanceLabel, 4, index + 1);
					pane.add(resistanceLog, 5, index + 1);
				}
				else {
					pane.getChildren().removeAll(resistanceLabel, resistanceLog);
				}
			});
			
			hasDistance.setOnAction(e -> {
				if(hasDistance.isSelected()) {
					distanceLabel = new Label("Distance(Miles):");
					distanceLog = new TextField();
					distanceLog.setPrefWidth(50);
					pane.add(distanceLabel, 6, index + 1);
					pane.add(distanceLog, 7, index + 1);
				}
				else {
					pane.getChildren().removeAll(distanceLabel, distanceLog);
				}
			});
			
			pane.add(nameLabel, 0, index + 1);
			pane.add(checkBoxes, 1, index + 1);
			exerciseComplete = new Button("Exercise Complete");
			pane.add(exerciseComplete, 8, index + 1);
			
			
			exerciseComplete.setOnAction(e ->{
				
				if(hasLaps.isSelected()) {
					currentCardio.setHasLaps(true);
					currentCardio.setLaps(Integer.parseInt(lapLog.getText()));
					hasLaps.setDisable(true);
					lapLog.setDisable(true);
				}
				
				if(hasResistance.isSelected()) {
					currentCardio.setHasResistance(true);
					currentCardio.setResistanceLevel(Integer.parseInt(resistanceLog.getText()));
					hasResistance.setDisable(true);
					resistanceLog.setDisable(true);

				}
				
				if(hasDistance.isSelected()) {
					currentCardio.setHasDistance(true);
					currentCardio.setDistance(Double.parseDouble(distanceLog.getText()));
					distanceLog.setDisable(true);
					hasDistance.setDisable(true);
				}
				
				exerciseComplete.setText("Completed");
				exerciseComplete.setDisable(true);
				completedWorkout.addExercise(currentCardio);
				int i = index + 1;
				logExercises(i, pane);
			});
		}
		
		
	}
	
}
