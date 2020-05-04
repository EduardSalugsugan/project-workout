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

public class startWorkoutPage {
	
	private static Button goBack;
	private static GridPane layout;
	private static Stage window = new Stage();
	private static Scene page;
	private static ObservableList<String> workouts;
	private static ArrayList<Workout> allWorkouts = Workout.getAllWorkouts();
	private static Workout selectedWorkout;

	
	//The display method allows the GUI page to be called from other pages
	public static void display() {
		window.setOnCloseRequest(e -> window.close());
		setWorkoutSelectWindow();
		
	}
	
	
	private static void setWorkoutSelectWindow() {
		
		window.setTitle("Workouts");
		window.centerOnScreen();
		layout = createStartWorkoutPage();
		page = new Scene(layout, 500, 340);
		window.setScene(page);
		window.show();
		
	}
	
	
	private static GridPane createStartWorkoutPage() {
		
		//Set gridpane settings
		
		
		GridPane gridPane = new GridPane(); 
		//gridPane.setGridLinesVisible(true);
		gridPane.setPadding(new Insets(20, 40, 40, 40));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
		Label headerLabel = new Label("Select a workout routine to start");
		headerLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		
		ColumnConstraints column0 = new ColumnConstraints(420);
		RowConstraints row0 = new RowConstraints(40); 
		column0.setHalignment(HPos.CENTER);
		gridPane.getColumnConstraints().add(column0);
		gridPane.getRowConstraints().add(row0);
		
		gridPane.add(headerLabel, 0, 0);
		
		//Create and fill the list of exercises that can be viewed
		ListView<String> workoutListView = new ListView<String>();
		workouts = Workout.loadWorkouts();
		workoutListView.setItems(workouts);
		
		
		//Settings for the listview style
		GridPane.setHalignment(workoutListView, HPos.CENTER);
		gridPane.add(workoutListView, 0, 1);
		RowConstraints row1 = new RowConstraints(180); 

		gridPane.getRowConstraints().add(row1);
		
		Button createWorkout = new Button("Create new workout");
		createWorkout.setPrefWidth(200);
		GridPane.setHalignment(createWorkout, HPos.LEFT);
		createWorkout.setOnAction(e -> {
			window.close();
			addWorkoutPage.display();
		});
		
		Button view = new Button("View Selected Workout");
		view.setPrefWidth(200);
		view.setOnAction(e ->{
			//selectedWorkout = allWorkouts.get(workoutListView.getSelectionModel().getSelectedIndex());
		});

		//Placeholder, will eventually open new dialog box with exercise information
		Button select = new Button("Start Selected Workout");
		select.setPrefWidth(200);
		select.setOnAction(e -> {
			if(workouts.size() > allWorkouts.size()) {
				allWorkouts = Workout.getAllWorkouts();
			}
			selectedWorkout = allWorkouts.get(workoutListView.getSelectionModel().getSelectedIndex());
			workoutTrackingPage.display(selectedWorkout);
		});

		goBack = new Button("Back");
		goBack.setPrefWidth(200);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});
		
		VBox firstButtons = new VBox();
		firstButtons.setSpacing(10);
		firstButtons.getChildren().addAll(createWorkout, view);
		
		VBox secondButtons = new VBox();
		secondButtons.setSpacing(10);
		secondButtons.getChildren().addAll(select, goBack);
		
		//Add buttons to an HBox for style purposes 
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(firstButtons, secondButtons);
		buttonBox.setSpacing(20);
		buttonBox.setAlignment(Pos.BASELINE_CENTER);
		gridPane.add(buttonBox, 0, 2);
		
		return gridPane;
		
	}
	
	
	

}