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
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sun.security.tools.keytool.Main;


public class addStrengthExerciseWindow {
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static TextField name;
	private static TextField type;
	private static BufferedWriter writer;
	
	public static void display() {
		
		window.setOnCloseRequest(e ->{
			window.close();
		});
		
		setAddWindow();
		
	}
	
	public static void setAddWindow(){
		
		window.setTitle("Add new exercise");
		window.centerOnScreen();
		layout = createAddLayout();
	    page = new Scene(layout, 450, 300);
		window.setScene(page);
		window.show();
	}
	
	public static GridPane createAddLayout() {
		
		GridPane gridPane = new GridPane();
		
		//gridPane.setAlignment(Pos.CENTER);
		
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		ColumnConstraints columnOneConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstrains.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		
		gridPane.getColumnConstraints().addAll(columnOneConstrains, columnTwoConstrains);
		
		Label headerLabel = new Label("Add new exercise");
		headerLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 20));
		
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets( 20, 0, 20, 0));
		
		
		Label nameLabel = new Label("Exercise Name: ");
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		gridPane.add(nameLabel, 0, 1);
		
		name = new TextField();
		gridPane.add(name, 1, 1);
		
		Label typeLabel = new Label("Upper or Lower Body : ");
		GridPane.setHalignment(typeLabel, HPos.LEFT);
		GridPane.setHgrow(typeLabel, Priority.ALWAYS );
		gridPane.add(typeLabel, 0, 2);
		
		type = new TextField();
		GridPane.setHalignment(type, HPos.RIGHT);
		gridPane.add(type, 1, 2);
		
	
		Button save = new Button("Save Exercise");
		
		//gridPane.add(save, 0, 3);
		save.setOnAction(e -> {
			try {
				saveExercise();
			}
			catch(IOException i) {
				System.out.println("Error");
			}
		});
		
		Button goBack = new Button("Cancel");
		goBack.setOnAction(e -> {
			window.close();
			exercisePage.display();
		});
		
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(save, goBack);
		buttonBox.setSpacing(20);
		buttonBox.setAlignment(Pos.CENTER);
		GridPane.setRowIndex(gridPane, 4);
		GridPane.setRowSpan(gridPane, 2);
		
		gridPane.add(buttonBox, 0, 4);
		return gridPane;
		
	}
	
	private static void saveExercise() throws IOException {
		
		if(name.getText().isEmpty() || type.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, layout.getScene().getWindow(), "Error", "Enter all information");
			return;
		}
		
		try {
			String exerciseInfo = name.getText() + ", " + type.getText();
			File exerciseFile = new File("Exercises.txt");
			if(exerciseFile.createNewFile()) {
				System.out.println("File created: " + exerciseFile.getName());
			}
			else
				System.out.println("File already exists");
			
			writer = new BufferedWriter(new FileWriter(exerciseFile));
			writer.write(exerciseInfo);
			writer.close();
			showAlert(Alert.AlertType.CONFIRMATION, layout.getScene().getWindow(), "Success", "Exercise added");
			
			
		} catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
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
