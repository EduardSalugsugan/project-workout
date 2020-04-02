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
import javafx.stage.Stage;
import javafx.stage.Window;
import sun.security.tools.keytool.Main;

public class workoutPage {
	
	private static Stage window = new Stage();
	
	public static void display() {
		
		window.setOnCloseRequest(e -> closeWindow());
		setWorkoutPage();
		
	}
	
	private static void setWorkoutPage() {
		
		window.setTitle("Workouts");
		window.centerOnScreen();
		GridPane layout = createWorkoutPage();
		Scene page = new Scene(layout, 450, 450);
		window.setScene(page);
		window.show();
	}
	private static GridPane createWorkoutPage() {
		GridPane workoutPage = new GridPane();
		
	    workoutPage.setPadding(new Insets(40, 40, 40, 40));
	    workoutPage.setVgap(10);
	    workoutPage.setHgap(20);
		Label headerLabel = new Label("Workouts");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		workoutPage.add(headerLabel, 0, 0, 3, 2);
		
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		return workoutPage;
		
	}
	
	private static void closeWindow() {
		window.close();
		homePage.display();
		
	}

}
