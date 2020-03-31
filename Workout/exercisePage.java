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
import sun.security.tools.keytool.Main;

public class exercisePage implements EventHandler<ActionEvent>{
	
	private static Button cardio;
	private static Button strength;
	private static Button goBack;
	private static GridPane layout;
	private static Stage window = new Stage();
	private static Scene page;
	//private static Scene selectionPage;
	//private static Scene cardioPage;
	//private static Scene strengthPage;

	public static void display() {
		window.setOnCloseRequest(e -> closeWindow());
		setMainWindow();
		
	}
	
	private static void setMainWindow() {
		
		window.setTitle("Exercise Page");
		window.centerOnScreen();
		layout = createExerciseHomePage();
		page = new Scene(layout, 450, 300);
		window.setScene(page);
		window.show();
			
	}
	
	private static void setCardioWindow() {

		window.setTitle("Cardio exercises");
		window.centerOnScreen();
		layout = cardioExercise();
		page = new Scene(layout, 450, 300);
		window.setScene(page);
		window.show();
		
	}
	
	private static void setStrengthWindow() {
		
		window.setTitle("Strength exercises");
		window.centerOnScreen();
		layout = strengthExercise();
		page = new Scene(layout, 450, 300);
		window.setScene(page);
		window.show();
	}
	
	private static GridPane createExerciseHomePage() {
		
	    GridPane gridPane = new GridPane();
	    gridPane.setPadding(new Insets(40, 40, 40, 40));
	    gridPane.setVgap(10);
	    gridPane.setHgap(20);
		Label headerLabel = new Label("Cardio or Weight Training Exercises?");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		gridPane.add(headerLabel, 0, 0, 3, 2);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		
		cardio = new Button("Cardio");
		cardio.setTranslateX(60);
		GridPane.setHalignment(cardio, HPos.CENTER);
		gridPane.add(cardio, 1, 2);
		cardio.setOnAction(e -> setCardioWindow());
		
		strength = new Button("Strength");
		GridPane.setHalignment(strength, HPos.CENTER);
		gridPane.add(strength, 2, 2);
		strength.setOnAction(e -> setStrengthWindow());

		return gridPane;
	}
	
	private static GridPane cardioExercise() {
		
		GridPane gridPane = new GridPane();
		
		ListView<String> cardioList = new ListView<String>();
		ObservableList<String> cardioExercises = FXCollections.observableArrayList();
		cardioList.setPadding(new Insets(40, 40, 40, 40));
		cardioList.setItems(cardioExercises);
		
		goBack = new Button("Return");
		goBack.setOnAction(e -> {
			setMainWindow();
		});
		gridPane.add(goBack, 1, 1);
		gridPane.add(cardioList, 2, 2);
		
		
		return gridPane;
		
	}
	
	private static GridPane strengthExercise() {
		
		GridPane gridPane = new GridPane();
		goBack = new Button("Back");
		gridPane.add(goBack, 1, 1);
		goBack.setOnAction(e -> {
			setMainWindow();
		});
		
		return gridPane;
		
	}
	
	public static void closeWindow() {
		window.close();
		homePage.display();
	}


	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}