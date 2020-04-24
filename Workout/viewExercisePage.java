
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
		page = new Scene(layout, 350, 300);		
		window.setScene(page);
		window.show();
		
	}
	
	private static GridPane createViewStrengthPage() {
		GridPane pane = new GridPane();
		//pane.setGridLinesVisible(true);
		pane.setAlignment(Pos.TOP_CENTER);
		//pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(40,10,20,10));
		pane.setVgap(30);
		
		
		
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
		
		Label muscle = new Label("Targets " + strengthExercise.getMainTargetMuscle() + " Muscles");
		muscle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//muscle.setAlignment(Pos.BASELINE_CENTER);
		//GridPane.setHalignment(type, HPos.RIGHT);
		//pane.add(type, 1, 1);
		Label weightType;
		if(strengthExercise.getWeightType().equalsIgnoreCase("Body Weight")) {
			weightType = new Label("Bodyweight exercise");
			
		}
		else if(strengthExercise.getWeightType().equalsIgnoreCase("Free Weights")) {
			weightType = new Label("Free weights required");
		}
		
		else {
			weightType = new Label("Uses weight machine");
		}
		
		Label equiptment = new Label("Uses " + strengthExercise.getEquiptmentNeeded());
		//equiptment.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		//equiptment.setAlignment(Pos.BASELINE_CENTER);
		


		VBox titleBox = new VBox();
		titleBox.setAlignment(Pos.BASELINE_CENTER);
		titleBox.getChildren().addAll(areaLabel, muscle, weightType, equiptment);
		titleBox.setSpacing(10);
		pane.add(titleBox, 0, 1, 1, 2);
		
		
		VBox exerciseInfoBox = new VBox();
		//exerciseInfoBox.getChildren().addAll(exerciseType);
		pane.add(exerciseInfoBox, 1, 1, 1, 2);
		
		return pane;
	}
	
	private static GridPane createViewCardioPage() {
		GridPane pane = new GridPane();
		//pane.setGridLinesVisible(true);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(40,40,40,40));
		pane.setVgap(20);

		
		
		
		Label nameLabel = new Label(cardioExercise.getName());
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		pane.add(nameLabel, 0, 0, 2, 1);
		

		VBox titleBox = new VBox();
		titleBox.setSpacing(10);
		Label equiptmentLabel = new Label("Equiptment needed: ");
		titleBox.getChildren().addAll(equiptmentLabel);
		pane.add(titleBox, 0, 1, 1, 2);
		
		
		VBox exerciseInfoBox = new VBox();
		Label equiptment = new Label(cardioExercise.getEquiptmentNeeded());
		exerciseInfoBox.getChildren().addAll(equiptment);
		pane.add(exerciseInfoBox, 1, 1, 1, 2);
		
		return pane;
	}
}
