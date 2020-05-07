import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class myMealPlan {

	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static myMeal meal = myMeal.getCurrentMealPlan();
	private static Account account = Account.getCurrentAccount();
	private static String a[];

	public static void display() throws FileNotFoundException {
		setFoodPlanWindow();
	}

	private static void setFoodPlanWindow() throws FileNotFoundException {
		window.setTitle("Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		page = new Scene(layout, 400, 800);
		window.setScene(page);
		window.show();
		window.setResizable(false);
	}

	private static GridPane createFoodPlanPage() throws FileNotFoundException {
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

		File file = new File("tempMeal.txt");
		Scanner scan = new Scanner(file);
		String found = account.getUsername();
		String temp;
		while(scan.hasNextLine()) {
			temp = scan.nextLine();
			a = temp.split(",");
			if (a[0].equals(found)){
				break;
			}
		}
		
		Text breakfast;
		Text snack1;
		Text lunch;
		Text snack2;
		Text dinner;
		Text snack3;
		Text notes;
		
		String temp1 = a[1].replaceAll("\\+ ","\n");
		String temp2 = a[2].replaceAll("\\+ ","\n");
		String temp3 = a[3].replaceAll("\\+ ","\n");
		String temp4 = a[4].replaceAll("\\+ ","\n");
		String temp5 = a[5].replaceAll("\\+ ","\n");
		String temp6 = a[6].replaceAll("\\+ ","\n");
		String temp7 = a[7].replaceAll("\\+ ","\n");

		breakfast = new Text(temp1);
		snack1 = new Text(temp2);
		lunch = new Text(temp3);
		snack2 = new Text(temp4);
		dinner = new Text(temp5);
		snack3 = new Text(temp6);
		notes = new Text(temp7);
        
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