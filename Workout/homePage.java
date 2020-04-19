import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
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
		pane.setVgap(25);
		//pane.setGridLinesVisible(true);
		//The loginButton will take the user to the login page
		loginButton = new Button("Login");
		pane.add(loginButton, 0, 0);
		loginButton.setOnAction(e -> {
			window.close();
			loginPage.display();
		});
		GridPane.setHalignment(loginButton, HPos.CENTER);
		
		accountButton = new Button("Account Information");
		pane.add(accountButton, 0, 1);
		accountButton.setOnAction(e -> {
			window.close();
			accountPage.display();
		});
		GridPane.setHalignment(accountButton, HPos.CENTER);

		beginButton = new Button("Start workout");
		pane.add(beginButton, 0, 2);
		GridPane.setHalignment(beginButton, HPos.CENTER);
		beginButton.setOnAction(e -> startWorkoutPage.display());

		
		workoutsButton = new Button("View workouts");
		pane.add(workoutsButton, 0, 3);
		workoutsButton.setOnAction(e -> {
			window.close();
			workoutPage.display();
		});
		GridPane.setHalignment(workoutsButton, HPos.CENTER);
		
		
		exercisesButton = new Button("View exercises");
		pane.add(exercisesButton, 0, 4);
		exercisesButton.setOnAction(e -> {
			window.close();
			exercisePage.display();
		});
		GridPane.setHalignment(exercisesButton, HPos.CENTER);

		foodPlanButton = new Button("Food Plans");
		pane.add(foodPlanButton, 0, 5);
		foodPlanButton.setOnAction(e -> {
			window.close();
			mealPlanPage.display();
		});
		GridPane.setHalignment(foodPlanButton, HPos.CENTER);

		return pane; 
		
	}
	
}