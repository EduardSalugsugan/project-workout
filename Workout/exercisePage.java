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
import javafx.geometry.VPos;
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

public class exercisePage {
	
	private static Button goBack;
	private static GridPane layout;
	private static Stage window = new Stage();
	private static Scene page;

	public static void display() {
		window.setOnCloseRequest(e -> window.close());
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
	    gridPane.setVgap(20);
	    gridPane.setHgap(20);
	    
//		ColumnConstraints columnOneConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
//		columnOneConstrains.setHalignment(HPos.RIGHT);
//		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
//		columnTwoConstrains.setHgrow(Priority.ALWAYS);
//		
		//gridPane.getColumnConstraints().addAll(columnOneConstrains, columnTwoConstrains);
	    
		Label headerLabel = new Label("Cardio or Weight Training Exercises?");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		gridPane.add(headerLabel, 0, 0);
		GridPane.setHgrow(headerLabel, Priority.ALWAYS);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setValignment(headerLabel, VPos.TOP);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		
		Button cardio = new Button("Cardio");
		GridPane.setHalignment(cardio, HPos.CENTER);
		GridPane.setMargin(cardio, new Insets(0, 175, 0, 0));
		gridPane.add(cardio, 0, 1);
		cardio.setOnAction(e -> setCardioWindow());
		
		Button strength = new Button("Strength");
		GridPane.setHalignment(strength, HPos.CENTER);
		GridPane.setMargin(strength, new Insets(0, 0, 0, 175));
		gridPane.add(strength, 0, 1);
		strength.setOnAction(e -> setStrengthWindow());
		
		Button addNewCardio = new Button("Add new cardio exercise");
		GridPane.setHalignment(addNewCardio, HPos.CENTER);
		GridPane.setMargin(addNewCardio, new Insets(0, 200, 0, 0));
		//GridPane.setValignment(addNewCardio, VPos.CENTER);
		gridPane.add(addNewCardio, 0, 3);
		addNewCardio.setOnAction(e -> {
			window.close();
			addCardioExerciseWindow.display();
		});
		
		Button addNewStrength = new Button("Add new strength exercise");
		GridPane.setHalignment(addNewStrength, HPos.CENTER);
		GridPane.setMargin(addNewStrength, new Insets(0, 0, 0, 200));
		//GridPane.setValignment(addNewStrength, VPos.CENTER);
		gridPane.add(addNewStrength, 0, 3);
		addNewStrength.setOnAction(e -> {
			window.close();
			addStrengthExerciseWindow.display();
		});

		return gridPane;
	}
	
	private static GridPane cardioExercise() {
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(0, 40, 40, 0));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
		ListView<String> cardioList = new ListView<String>();
		ObservableList<String> cardioExercises = FXCollections.observableArrayList();
		
		
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


}