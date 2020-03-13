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

public class exercisePage extends Application implements EventHandler<ActionEvent>{
	
	Button cardio;
	Button strength;
	Button goBack;
	GridPane layout;
	Stage stage;
	Scene selectionPage;
	Scene cardioPage;
	Scene strengthPage;

	//Placeholder exercises used to test code for now 
	Exercise benchPress = new Exercise("Strength", "Bench Press");
	Exercise sprint = new Exercise("Cardio", "Sprint");
	
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		stage.setTitle("Exercise Page");
		stage.centerOnScreen();
		
		layout = createExerciseHomePage();
		
		selectionPage = new Scene(layout, 450, 300);
		
		stage.setScene(selectionPage);
		stage.show();
		
		
	}
	
	private GridPane createExerciseHomePage() {
	
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
		cardio.setOnAction(this);
		cardio.setTranslateX(60);
		GridPane.setHalignment(cardio, HPos.CENTER);
		gridPane.add(cardio, 1, 2);
		
		strength = new Button("Strength");
		strength.setOnAction(this);
		GridPane.setHalignment(strength, HPos.CENTER);
		gridPane.add(strength, 2, 2);

		return gridPane;
	}
	
	private GridPane cardioExercise() {
		
		GridPane gridPane = new GridPane();
		
		ListView<String> cardioList = new ListView<String>();
		ObservableList<String> cardioExercises = FXCollections.observableArrayList();
		cardioList.setPadding(new Insets(40, 40, 40, 40));
		cardioExercises.add(benchPress.getName());
		cardioExercises.add(sprint.getName());
		cardioList.setItems(cardioExercises);
		goBack = new Button("Return");
		goBack.setOnAction(this);
		gridPane.add(goBack, 1, 1);
		
		gridPane.add(cardioList, 2, 2);
		
		
		return gridPane;
		
	}
	
	private GridPane strengthExercise() {
		
		GridPane gridPane = new GridPane();
		
		goBack = new Button("Back");
		goBack.setOnAction(this);
		gridPane.add(goBack, 1, 1);
		
		return gridPane;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == cardio) {
			layout = cardioExercise();
			cardioPage = new Scene(layout, 450, 300);
			stage.setScene(cardioPage);
		}
			
		
		if(event.getSource() == strength) {
			layout = strengthExercise();
			strengthPage = new Scene(layout, 450, 300);
			stage.setScene(strengthPage);
		}
		
		
		if(event.getSource() == goBack) {
			stage.setScene(selectionPage);
		}
			
	}
	
    
   
}