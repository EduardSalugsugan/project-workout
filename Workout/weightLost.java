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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class weightLost{
	
	private static Stage window = new Stage();
	private static GridPane layout;
    private static Scene page;
	private static String style = "    -fx-background-color: radial-gradient(center 50% 50% , radius 80% , #69696b ,   #3a3a3a);" + 
			"    -fx-padding: 10;\n" +
			"    -fx-text-fill:  #c6f5f9 ;\n";

	private static String buttonStyle = " -fx-background-color: rgba(3, 252, 248, 0.4);"
	+ " -fx-background-radius: 10; -fx-text-fill: #c6f5f9; -fx-font: 14px Arial; -fx-font-weight: Bold;";
	private static String labelStyle = "-fx-text-fill: #c6f5f9;";
	private static String textStyle = "-fx-fill: #c6f5f9;";
	
	public static void display() {
		setFoodPlanWindow();
	}
	
	private static void setFoodPlanWindow() {
		window.setTitle("Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		page = new Scene(layout, 500, 700); 
		window.setScene(page);
		window.show();
		window.setResizable(false);
    }
    
	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setStyle(style);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Meal Plan For Weight Lost");
		nameLabel.setStyle(labelStyle);
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

        VBox muscle = new VBox();
        muscle.setAlignment(Pos.CENTER_LEFT);
        muscle.setSpacing(25);

        Text breakfast = new Text("Breakfast (Meal One): 6am\ngreen smoothie (made with ½ banana + ½ cup frozen mango 1 cup\nkale + ½ cup plain, low-fat Greek yogurt ½ small avocado + ½ cup nonfat milk)");
        breakfast.setStyle(textStyle);
        Text snack = new Text("Snack (Meal Two): 9am\n1 apple\n1 oz nuts");
        snack.setStyle(textStyle);
        Text lunch = new Text("Lunch (Meal Three): 12pm\n2 cups Veggie Soup");
        lunch.setStyle(textStyle);
        Text snack2 = new Text("Snack (Meal Four): 3pm\n1 cup baby carrots\nsugar snap peas\n2 tablespoons hummus");
        snack2.setStyle(textStyle);
        Text dinner = new Text("Dinner (Meal Five): 6pm\n4 oz salmon\n1 cup steamed carrots\n1 cup steamed broccoli\n2 tablespoons teriyaki sauce\n1 teaspoon sesame seeds");
        dinner.setStyle(textStyle);
        Text note = new Text("Notes:\nBake the salmon at 400°F (200°C) until firm to the touch, 10 to 15 minutes, depending\non the thickness. Chop the carrots and broccoli and steam until tender-crisp,\nabout 5 minutes for the carrots, 3 minutes for the broccoli. Drizzle everything\nwith the teriyaki sauce and sprinkle with the sesame seeds.");
        note.setStyle(textStyle);
        Button back = new Button("Back");
        back.setStyle(buttonStyle);
        back.setOnAction(e-> {
            window.close();
            mealPlanPage.display();
		});
        muscle.getChildren().addAll(breakfast,snack,lunch,snack2,dinner,note,back);
        pane.add(muscle, 0 , 1);
		return pane;
	}

}