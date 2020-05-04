import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class workoutPage{
	
	private static Stage window = new Stage();
	private static ObservableList<String> viewableWorkouts;
	private static ArrayList<Workout> completedWorkouts;
	
	public static void display(){
		
		window.setOnCloseRequest(e -> closeWindow());
		setWorkoutPage();
		
	}
	
	private static void setWorkoutPage(){
		
		window.setTitle("Workouts");
		window.centerOnScreen();
		GridPane layout = createWorkoutPage();
		Scene page = new Scene(layout, 450, 300);
		window.setScene(page);  
		window.show();
	}
	
	private static GridPane createWorkoutPage() {
		
		
		//Set gridpane settings
		
		
		GridPane gridPane = new GridPane();
		//gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
		
		//Create and fill the list of exercises that can be viewed
		ListView<String> workoutListView = new ListView<String>();
		viewableWorkouts = Workout.loadWorkouts();
		workoutListView.setItems(viewableWorkouts);

		
		
		GridPane.setHalignment(workoutListView, HPos.CENTER);
		gridPane.add(workoutListView, 0, 0);
		ColumnConstraints column0 = new ColumnConstraints(370);
		RowConstraints row0 = new RowConstraints(200); 
		column0.setHalignment(HPos.CENTER);
		gridPane.getColumnConstraints().add(column0);
		gridPane.getRowConstraints().add(row0);
		

		//Placeholder, will eventually open new dialog box with exercise information
		Button view = new Button("View workout routine");
		view.setOnAction(e -> {
			//TO DO: Open a new window that will show each exercise in the selected workout
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
		

		
		//Add buttons to an HBox for style purposes 
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(view, createWorkout, goBack);
		buttonBox.setSpacing(20);
		buttonBox.setAlignment(Pos.BASELINE_CENTER);
		gridPane.add(buttonBox, 0, 1);
		
		return gridPane;
	}
	
	
	private static void closeWindow() {
		window.close();
		homePage.display();
		
	}

}
