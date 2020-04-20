import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class mealPlanPage{
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene foodplan;
	
	public static void display() {
		setFoodPlanWindow();
	}
	
	
	private static void setFoodPlanWindow() {
		window.setTitle("Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		foodplan = new Scene(layout, 300, 500); 
		window.setScene(foodplan);
		window.show();
		window.setResizable(false);
    }
    
	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Meal Plan Suggestions");
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		
		VBox foodplan = new VBox();
		foodplan.setAlignment(Pos.CENTER);
		foodplan.setSpacing(25);

		Button Gain = new Button("Muscle Gains");
        Gain.setPrefSize(150, 20);
        Gain.setOnAction(e -> {
            window.close();
            muscleGain.display();
		});

		Button Lost = new Button("Weight Lost");
        Lost.setPrefSize(150, 20);
        Lost.setOnAction(e -> {
			window.close();
			weightLost.display();	
		});

		Button Vegan = new Button("Vegan Diet");
        Vegan.setPrefSize(150, 20);
        Vegan.setOnAction(e -> {
			window.close();
			veganGains.display();	
		});

		Button MyPlan = new Button("My Plan");
        MyPlan.setPrefSize(150, 20);
       	MyPlan.setOnAction(e -> {
		//	window.close();
			myMealPlan.display();	
		});

		Button goBack = new Button("Back");
		goBack.setPrefSize(150, 20);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});

		foodplan.getChildren().addAll(Gain, Lost, Vegan, MyPlan, goBack);
		
		pane.add(foodplan, 0 , 1);
		
		return pane;
	}
	
	

}
