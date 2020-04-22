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

public class myMealPlan{
	
	private static Stage window = new Stage();
	private static GridPane layout;
    private static Scene page;
	private static myMeal meal = myMeal.getCurrentMealPlan();
	private static Account account = Account.getCurrentAccount();
    
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
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label(account.getUsername() + " Meal Plan");
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.LEFT);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

        VBox muscle = new VBox();
        muscle.setAlignment(Pos.CENTER_LEFT);
        muscle.setSpacing(25);

        Text breakfast = new Text(meal.getBreakfast());
        Text snack1 = new Text(meal.getSnack1());
        Text lunch = new Text(meal.getLunch());
        Text snack2 = new Text(meal.getSnack2());
        Text dinner = new Text(meal.getDinner());
        Text snack3 = new Text(meal.getSnack3());
        Text notes = new Text(meal.getNotes());
        
        Button back = new Button("Back");
        back.setOnAction(e-> {
            window.close();
            mealPlanPage.display();
        });
        
        muscle.getChildren().addAll(breakfast, snack1, lunch, snack2, dinner, snack3, notes, back);
        pane.add(muscle, 0 , 1);
		return pane;
	}

}