
import java.io.File;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class viewExercisePage {

	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static StrengthExercise strengthExercise;
	private static CardioExercise cardioExercise;
	
	
	public static void displayStrength(StrengthExercise exercise) {
		strengthExercise = exercise; 
		setViewWindow("Strength");
		window.setOnCloseRequest(e -> window.close());
	}
	
	public static void displayCardio(CardioExercise exercise) {
		cardioExercise = exercise;
		setViewWindow("Cardio");
		window.setOnCloseRequest(e -> window.close());
	}
	
	private static void setViewWindow(String type) {
		
		window.setTitle("");
		window.centerOnScreen();
		if(type.equalsIgnoreCase("Strength"))
			layout = createViewStrengthPage();
		else
			layout = createViewCardioPage();
		page = new Scene(layout, 250, 300);		
		window.setScene(page);
		window.show();
		
	}
	
	private static GridPane createViewStrengthPage() {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setAlignment(Pos.TOP_CENTER);
		//pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20,10,20,10));
		pane.setVgap(30);
//		ColumnConstraints column0 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
//		ColumnConstraints column1 = new ColumnConstraints(10, 10, Double.MAX_VALUE);
//		ColumnConstraints column2 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	//	RowConstraints row0 = new RowConstraints(20, 20, Double.MAX_VALUE);
		//pane.getRowConstraints().addAll(row0);
	//	pane.getColumnConstraints().addAll(column0, column1, column2);
		
		
		
		
		Label nameLabel = new Label(strengthExercise.getName());
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		pane.add(nameLabel, 0, 0, 2, 1);
		
		
		Label areaLabel = new Label(strengthExercise.getTargetMuscleArea() +" Exercise");
		areaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//areaLabel.setAlignment(Pos.BASELINE_CENTER);
		///GridPane.setHalignment(typeLabel, HPos.CENTER);
		//pane.add(typeLabel, 0, 1);
		
		Label muscle = new Label("Targets" + strengthExercise.getMainTargetMuscle());
		muscle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//muscle.setAlignment(Pos.BASELINE_CENTER);
		//GridPane.setHalignment(type, HPos.RIGHT);
		//pane.add(type, 1, 1);
		
		Label weightType = new Label(strengthExercise.getWeightType());
		
		Label equiptment = new Label("Exercise uses " + strengthExercise.getWeightType() + " " + strengthExercise.getEquiptmentNeeded());
		equiptment.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//equiptment.setAlignment(Pos.BASELINE_CENTER);
		


		VBox titleBox = new VBox();
		titleBox.setAlignment(Pos.BASELINE_CENTER);
		titleBox.getChildren().addAll(areaLabel, muscle,weightType, equiptment);
		titleBox.setSpacing(10);
		pane.add(titleBox, 0, 1, 1, 2);
		
		
		VBox exerciseInfoBox = new VBox();
		//exerciseInfoBox.getChildren().addAll(exerciseType);
		pane.add(exerciseInfoBox, 1, 1, 1, 2);
		
		return pane;
	}
	
	private static GridPane createViewCardioPage() {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setAlignment(Pos.TOP_CENTER);
		//pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(40,40,40,40));
		pane.setVgap(20);
//		ColumnConstraints column0 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
//		ColumnConstraints column1 = new ColumnConstraints(10, 10, Double.MAX_VALUE);
//		ColumnConstraints column2 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	//	RowConstraints row0 = new RowConstraints(20, 20, Double.MAX_VALUE);
		//pane.getRowConstraints().addAll(row0);
	//	pane.getColumnConstraints().addAll(column0, column1, column2);
		
		
		
		
		Label nameLabel = new Label(cardioExercise.getName());
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		pane.add(nameLabel, 0, 0, 2, 1);
		
		
		Label typeLabel = new Label("Type: ");
		typeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		typeLabel.setAlignment(Pos.BASELINE_LEFT);
		//GridPane.setHalignment(typeLabel, HPos.CENTER);
		//pane.add(typeLabel, 0, 1);
		
		Label type = new Label("Info: ");
		type.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		type.setAlignment(Pos.BASELINE_LEFT);
		//GridPane.setHalignment(type, HPos.RIGHT);
		//pane.add(type, 1, 1);
		
		Label muscleLabel = new Label("Muscle Group:");
		muscleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		muscleLabel.setAlignment(Pos.BASELINE_LEFT);
		

		VBox titleBox = new VBox();
		titleBox.getChildren().addAll(typeLabel, type, muscleLabel);
		titleBox.setSpacing(10);
		pane.add(titleBox, 0, 1, 1, 2);
		
		
		VBox exerciseInfoBox = new VBox();
		//exerciseInfoBox.getChildren().addAll(exerciseType);
		pane.add(exerciseInfoBox, 1, 1, 1, 2);
		
		return pane;
	}
}
