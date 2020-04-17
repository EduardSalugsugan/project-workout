
import java.io.File;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class addWorkoutPage {
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static TextField name;
	private static ComboBox<String> typeBox;
	private static Workout workout;
	private static File workoutFile = new File("workoutFile.txt");
	
	
	public static void display() {
		window.setOnCloseRequest(e -> window.close());
		setAddWindow();
	}
	
	public static void setAddWindow(){
		
		window.setTitle("Add new exercise");
		window.centerOnScreen();
		layout = createAddLayout();
	    page = new Scene(layout, 450, 400);
		window.setScene(page);
		window.show();
	}
	
	private static GridPane createAddLayout() {
		
		GridPane gridPane = new GridPane();
		

		//Set the style settings for the pane
		gridPane.setPadding(new Insets(50, 40, 40, 40));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnOneConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstrains.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(columnOneConstrains, columnTwoConstrains);
		
		
		//Add label, buttons, and controls for the pane
		gridPane = addUIControls(gridPane);

		return gridPane;
		
	}
	
	private static GridPane addUIControls(GridPane pane) {
		GridPane gridPane = pane;
		Label headerLabel = new Label("Create New Workout Routine");
		headerLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		gridPane.setVgap(40);
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets( 0, 0, 20, 0));
		
		Label nameLabel = new Label("Set Name: ");
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		Label typeLabel = new Label("Workout type: ");
		GridPane.setHalignment(typeLabel, HPos.LEFT);
		GridPane.setHgrow(typeLabel, Priority.ALWAYS);
		nameLabel.setPrefHeight(30);
		typeLabel.setPrefHeight(30);
		
		
		
		VBox labelBox = new VBox();
		labelBox.setSpacing(25);
		labelBox.getChildren().addAll(nameLabel, typeLabel);
		gridPane.add(labelBox, 0, 1);
		
		
		TextField nameField = new TextField();
		nameField.setPrefHeight(30);
		typeBox = new ComboBox<String>();
		typeBox.getItems().addAll("Strength" , "Cardio");
		typeBox.setPrefWidth(300);
		typeBox.setPrefHeight(30);
		
		VBox selectionBox = new VBox();
		selectionBox.setSpacing(25);
		selectionBox.getChildren().addAll(nameField, typeBox);
		gridPane.add(selectionBox, 1, 1);
		
		Button goBack = new Button("Back");
		goBack.setOnAction(e -> {
			window.close();
			workoutPage.display();
		});
		
		gridPane.add(goBack, 1, 4);
		
		
		return pane;
	}
	

}
