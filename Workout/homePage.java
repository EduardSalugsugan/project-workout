import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class homePage  {

	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static Button loginButton;
	private static Button beginButton;
	private static Button workoutsButton;
	private static Button exercisesButton;
	private static Button accountButton;
	private static Button foodPlanButton;

	//The display method allows the GUI page to be called from other pages
	public static void display() {
		setHomeWindow();
	}
	
	private static void setHomeWindow() {
		
		window.setTitle("Make a selection");
		window.centerOnScreen();
		layout = createHomePage();
		page = new Scene(layout, 200, 315);
		window.setScene(page);
		window.show();
		
	}
	
	private static GridPane createHomePage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20, 0, 20, 0));
		pane.setVgap(5);
		//pane.setGridLinesVisible(true);
		//The loginButton will take the user to the login page
		loginButton = new Button("Login");
		loginButton.setPrefSize(200, 70);
		pane.add(loginButton, 0, 0);
		loginButton.setOnAction(e -> {
			window.close();
			loginPage.display();
		});
		GridPane.setHalignment(loginButton, HPos.CENTER);
		
		accountButton = new Button("Account Information");
		accountButton.setPrefSize(200, 70);
		pane.add(accountButton, 0, 1);
		accountButton.setOnAction(e -> {
			if(!Account.isLoggedIn()) {
				showAlert(Alert.AlertType.ERROR, window, "Not logged in", "Please log into an account to view this page");
				return;
			}
			else {	
				window.close();
				accountPage.display();
			}
		});
		GridPane.setHalignment(accountButton, HPos.CENTER);

		beginButton = new Button("Start Workout");
		beginButton.setPrefSize(200, 70);
		pane.add(beginButton, 0, 2);
		GridPane.setHalignment(beginButton, HPos.CENTER);
		beginButton.setOnAction(e -> {
			if(!Account.isLoggedIn()) {
				showAlert(Alert.AlertType.ERROR, window, "Not logged in", "Please log into an account to view this page");
				return;
			}
			else {
				window.close();
				startWorkoutPage.display();
			}
		});

		workoutsButton = new Button("View Completed Workouts");
		workoutsButton.setPrefSize(200, 70);
		pane.add(workoutsButton, 0, 3);
		workoutsButton.setOnAction(e -> {
			if(!Account.isLoggedIn()) {
				showAlert(Alert.AlertType.ERROR, window, "Not logged in", "Please log into an account to view this page");
				return;
			}
			else {
				window.close();
				workoutPage.display();
			}
		});
		GridPane.setHalignment(workoutsButton, HPos.CENTER);
		
		
		exercisesButton = new Button("View Exercises");
		exercisesButton.setPrefSize(200, 70);
		pane.add(exercisesButton, 0, 4);
		exercisesButton.setOnAction(e -> {
			if(!Account.isLoggedIn()) {
				showAlert(Alert.AlertType.ERROR, window, "Not logged in", "Please log into an account to view this page");
				return;
			}
			else {
				window.close();
				exercisePage.display();
			}
		});
		GridPane.setHalignment(exercisesButton, HPos.CENTER);

		foodPlanButton = new Button("Meal Plans");
		foodPlanButton.setPrefSize(200, 70);
		pane.add(foodPlanButton, 0, 5);
		foodPlanButton.setOnAction(e -> {
			if(!Account.isLoggedIn()) {
				showAlert(Alert.AlertType.ERROR, window, "Not logged in", "Please log into an account to view this page");
				return;
			}
			else {
				window.close();
				mealPlanPage.display();
			}
		});
		GridPane.setHalignment(foodPlanButton, HPos.CENTER);

		return pane; 
		
	}
	
	private static void showAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.show();
	}
	
}