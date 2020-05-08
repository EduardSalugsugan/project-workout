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

public class veganGains{
	
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
		page = new Scene(layout, 400, 800); 
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
		
		Label nameLabel = new Label("Meal Plan For Vegan");
		nameLabel.setStyle(labelStyle);
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

        VBox muscle = new VBox();
        muscle.setAlignment(Pos.CENTER_LEFT);
        muscle.setSpacing(25);

        Text breakfast = new Text("Breakfast (Meal One): 6am\n(281 calories, 11 g protein)\n1 whole-wheat English muffin\n1 1/2 Tbsp. almond butter");
        breakfast.setStyle(textStyle);
        Text snack = new Text("Snack (Meal Two): 9am\n(154 calories, 5 g protein)\n20 unsalted dry-roasted almonds");
        snack.setStyle(textStyle);
        Text lunch = new Text("Lunch (Meal Three): 12pm\n(325 calories, 18 g protein)\n1 serving Green Salad with Edamame & Beets");
        lunch.setStyle(textStyle);
        Text snack2 = new Text("Snack (Meal Four): 3pm\n(32 calories, 1 g protein)\n1/2 cup raspberries");
        snack2.setStyle(textStyle);
        Text dinner = new Text("Dinner (Meal Five): 6pm\n(428 calories, 16 g protein)\n1 serving Thai Tofu & Vegetable Curry with Zucchini Noodles");
        dinner.setStyle(textStyle);
        Text daily = new Text("Daily Totals:\n1,220 calories, 51 g protein, 87 g carbohydrate, 31 g fiber,\n81 g fat, 25 g saturated fat, 1,496 mg sodium");
        daily.setStyle(textStyle);
        Text tmi = new Text("To make it 1,500 calories:\nAdd 1 medium apple to breakfast, increase to 1/3 cup almonds\nat A.M. snack, and add 5 walnut halves to P.M. snack.");
        tmi.setStyle(textStyle);
        Text tmi2 = new Text("To make it 2,000 calories:\nAdd 1 medium apple to breakfast, increase to 1/3 cup almonds at \nA.M. snack and add 1 large pear, add White Bean & Avocado Toast\nto lunch, and add 1/3 cup walnut halves to P.M. snack.");
        tmi2.setStyle(textStyle);
        Button back = new Button("Back");
        back.setStyle(buttonStyle);
        back.setOnAction(e-> {
            window.close();
            mealPlanPage.display();
		});
        muscle.getChildren().addAll(breakfast, snack, lunch, snack2, dinner, daily, tmi, tmi2, back);
        pane.add(muscle, 0 , 1);
		return pane;
	}

}