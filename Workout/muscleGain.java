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

public class muscleGain{
	
	private static Stage window = new Stage();
	private static GridPane layout;
    private static Scene page;
	
	public static void display() {
		setFoodPlanWindow();
	}
	
	private static void setFoodPlanWindow() {
		window.setTitle("Food Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		page = new Scene(layout, 500, 700); 
		window.setScene(page);
		window.show();
		
    }
    
	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Food Plan For Muscle Gain");
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

        VBox muscle = new VBox();
        muscle.setAlignment(Pos.CENTER_LEFT);
        muscle.setSpacing(25);

        Text breakfast = new Text("Breakfast (Meal One): 6am\n1 grapefruit\nPlain oatmeal sweetened with cinnamon and stevia\nEgg-white omelet with chicken and veggies");
        Text snack = new Text("Snack (Meal Two): 9am\nSimple smoothie: 1 cup almond milk (or skim milk) + 1 scoop protein powder\nHandful of almonds");
        Text lunch = new Text("Lunch (Meal Three): 12pm\n1 piece fresh fruit\n1-2 grilled chicken breasts\n2 handful-sized servings of brown rice\n1 serving green veggies of choice (green beans, broccoli, asparagus, etc.)");
        Text snack2 = new Text("Snack (Meal Four): 3pm\n1 cup Greek yogurt\nHandful of berries");
        Text dinner = new Text("Dinner (Meal Five): 6pm\nLarge salad with mixed veggies\n1 baked regular or sweet potato\nBaked salmon filet or 1 grilled steak\n1 serving pineapple");
        Text snack3 = new Text("Late-Night/Before Bed Meal (Meal Six): 9pm\nSimple smoothie: 1 cup almond milk (or skim milk) + 1 scoop protein powder\nSalmon filet or 1 grilled steak\n1-2 plain rice cakes with natural peanut butter");
        Button back = new Button("Back");
        back.setOnAction(e-> {
            window.close();
            mealPlanPage.display();
		});
        muscle.getChildren().addAll(breakfast,snack,lunch,snack2,dinner,snack3,back);
        pane.add(muscle, 0 , 1);
		return pane;
	}

}