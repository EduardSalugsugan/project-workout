import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class workoutPage{
	
	private static Stage window = new Stage();
	private static ObservableList<String> viewableWorkouts;
	
	public static void display(){
		window.setOnCloseRequest(e -> closeWindow());
		setWorkoutPage();
		
	}
	
	private static void setWorkoutPage(){
		
		window.setTitle("Workouts");
		window.centerOnScreen();
		GridPane layout = createWorkoutPage();
		Scene page = new Scene(layout, 425, 300);
		window.setScene(page);  
		window.show();
	}
	
	private static GridPane createWorkoutPage() {
		
		
		//Set gridpane settings
		
		
		GridPane gridPane = new GridPane();
		//gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(20, 40, 0, 40));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);
		
		
		//Create and fill the list of exercises that can be viewed
		ListView<String> workoutListView = new ListView<String>();
		viewableWorkouts = Workout.loadCompletedWorkouts();
		workoutListView.setItems(viewableWorkouts);

		
		
		GridPane.setHalignment(workoutListView, HPos.CENTER);
		gridPane.add(workoutListView, 0, 0);
		ColumnConstraints column0 = new ColumnConstraints(370);
		RowConstraints row0 = new RowConstraints(200); 
		column0.setHalignment(HPos.CENTER);
		gridPane.getColumnConstraints().add(column0);
		gridPane.getRowConstraints().add(row0);
		


		Button view = new Button("View workout stats");
		view.setOnAction(e -> {
			ArrayList<Workout> completedWorkouts = Workout.getCompletedWorkouts();
			Workout selectedCompletedWorkout = completedWorkouts.get(workoutListView.getSelectionModel().getSelectedIndex());
			completedWorkoutWindowSetup(selectedCompletedWorkout);
		});
		
		Button createWorkout = new Button("Create new workout");
		GridPane.setHalignment(createWorkout, HPos.LEFT);
		createWorkout.setOnAction(e -> {
			window.close();
			addWorkoutPage.display();
		});
		
		Button goBack = new Button("Back");
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});
		int prefWidth = 150;
		int prefHeight = 40;
		view.setPrefSize(prefWidth, prefHeight);
		createWorkout.setPrefSize(prefWidth, prefHeight);
		goBack.setPrefSize(75, prefHeight);
		
		
		//Add buttons to an HBox for style purposes 
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(view, createWorkout, goBack);
		buttonBox.setSpacing(20);
		buttonBox.setAlignment(Pos.BASELINE_CENTER);
		gridPane.add(buttonBox, 0, 1);
		
		return gridPane;
	}
	
	
	
	private static void completedWorkoutWindowSetup(Workout completed) {
		
		window.setTitle("Workouts");
		window.centerOnScreen();
		GridPane layout = showCompletedWorkout(completed);
		Scene page = new Scene(layout, 650, 450);
		window.setScene(page);  
		window.show();
		
	}
	
	private static GridPane showCompletedWorkout(Workout completed) {
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setVgap(10);
		pane.setPadding(new Insets(20, 0, 20, 0));
		Label name = new Label(completed.getWorkoutName());
		GridPane.setHalignment(name, HPos.CENTER);
		name.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 28));
		pane.add(name, 0, 0);
		int height = 30;
		
		VBox exerciseBox = new VBox();
		for(int i = 0; i < completed.length(); i++) {
			HBox fullInfoBox = new HBox();
			Button exerciseName = new Button(completed.getExercise(i).getName());
			exerciseName.setPrefSize(220, height);
			exerciseName.setFont(Font.font("Arial", FontWeight.BLACK, 14));
			final int index = i;
			exerciseName.setOnAction(e -> {
				if(completed.getExercise(index).getType().equals("Strength")) {
					viewExercisePage.displayStrength((StrengthExercise) completed.getExercise(index)); 
				}
				else {
					viewExercisePage.displayCardio((CardioExercise) completed.getExercise(index)); 
				}
			});
			fullInfoBox.getChildren().add(exerciseName);
			
			if(completed.getExercise(i).getType().equalsIgnoreCase("Strength")) {
				StrengthExercise strength = (StrengthExercise)completed.getExercise(i);
				
				if(strength.getWeightType().equalsIgnoreCase("Free Weights") || strength.getWeightType().equalsIgnoreCase("Machine Resistance")) {
					Label weightUsed = new Label("Weight used: " + strength.getWeightUsed());
					weightUsed.setPrefHeight(height);
					fullInfoBox.getChildren().add(weightUsed);
				}
				Label reps = new Label("Reps Completed: " + strength.getRepitions());
				Label sets = new Label("Sets Completed: " + strength.getSets());
				reps.setPrefHeight(height);
				sets.setPrefHeight(height);
				fullInfoBox.getChildren().addAll(reps, sets);
			}
			fullInfoBox.setSpacing(10);
			fullInfoBox.setStyle("-fx-padding: 5;" + "-fx-border-style: solid;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: black;");
			exerciseBox.setSpacing(10);
			exerciseBox.getChildren().add(fullInfoBox);
		}
		exerciseBox.setAlignment(Pos.CENTER);
		pane.add(exerciseBox, 0, 2);
		return pane;
		
	}
	
	
	private static void closeWindow() {
		window.close();
		homePage.display();
		
	}

}
