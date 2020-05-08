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

public class foodPlanPage{
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene foodplan;
	private static String style = "    -fx-background-color: radial-gradient(center 50% 50% , radius 80% , #69696b ,   #3a3a3a);" + 
			"    -fx-padding: 10;\n" +
			"    -fx-text-fill:  #c6f5f9 ;\n";

	private static String buttonStyle = " -fx-background-color: rgba(3, 252, 248, 0.4);"
	+ " -fx-background-radius: 10; -fx-text-fill: #c6f5f9; -fx-font: 14px Arial; -fx-font-weight: Bold;";
	
	public static void display() {
		setFoodPlanWindow();
	}
	
	
	private static void setFoodPlanWindow() {
		window.setTitle("Food Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		foodplan = new Scene(layout, 400, 400); 
		window.setScene(foodplan);
		window.show();
		
    }
    
	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Food Plan Suggestions");
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		
		VBox foodplan = new VBox();
		foodplan.setAlignment(Pos.CENTER);
		foodplan.setSpacing(25);

		Button Gain = new Button("Muscle Gain");
        Gain.setPrefSize(150, 20);
        Gain.setOnAction(e -> {
            window.close();
            muscleGain.display();
		});
		Button Lost = new Button("Weight Lost");
        Lost.setPrefSize(150, 20);
        Lost.setOnAction(e -> {
			window.close();
			
		});
		Button goBack = new Button("Back");
		goBack.setPrefSize(150, 20);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});
		foodplan.getChildren().addAll(Gain, Lost, goBack);
		
		pane.add(foodplan, 0 , 1);
		
		return pane;
	}
	
	

}
