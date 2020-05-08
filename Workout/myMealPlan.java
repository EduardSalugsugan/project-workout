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
	private static String style = "    -fx-background-color: radial-gradient(center 50% 50% , radius 80% , #69696b ,   #3a3a3a);" + 
			"    -fx-padding: 10;\n" +
			"    -fx-text-fill:  #c6f5f9 ;\n";

	private static String buttonStyle = " -fx-background-color: rgba(3, 252, 248, 0.4);"
	+ " -fx-background-radius: 10; -fx-text-fill: #c6f5f9; -fx-font: 14px Arial; -fx-font-weight: Bold;";
	private static String labelStyle = "-fx-text-fill: #c6f5f9;";
	private static String textStyle = "-fx-fill: #c6f5f9;";
	private static String a[];

	public static void display() throws FileNotFoundException {
		setFoodPlanWindow();
	}

	private static void setFoodPlanWindow() throws FileNotFoundException {
		window.setTitle("Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		page = new Scene(layout, 400, 550);
		window.setScene(page);
		window.show();
		window.setResizable(false);
	}

	private static GridPane createFoodPlanPage() throws FileNotFoundException {
		//myMeal meal = myMeal.getCurrentMealPlan();
		Account account = Account.getCurrentAccount();

		GridPane pane = new GridPane();
		pane.setStyle(style);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label(account.getUsername() + " Meal Plan");
		nameLabel.setStyle(labelStyle);
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
		
		String temp1 = "Breakfast (Meal One): 6am\n" + a[1].replaceAll("\\+ ","\n");
		String temp2 = "Snack (Meal Two): 9am\n" + a[2].replaceAll("\\+ ","\n");
		String temp3 = "Lunch (Meal Three): 12pm\n" + a[3].replaceAll("\\+ ","\n");
		String temp4 = "Snack (Meal Four): 3pm\n" + a[4].replaceAll("\\+ ","\n");
		String temp5 = "Dinner (Meal Five): 6pm\n" + a[5].replaceAll("\\+ ","\n");
		String temp6 = "Late-Night/Before Bed Meal (Meal Six): 9pm\n" + a[6].replaceAll("\\+ ","\n");
		String temp7 = "Notes:\n" + a[7].replaceAll("\\+ ","\n");

		Text breakfast = new Text(temp1);
		breakfast.setStyle(textStyle);
		Text snack1 = new Text(temp2);
		snack1.setStyle(textStyle);
		Text lunch = new Text(temp3);
		lunch.setStyle(textStyle);
		Text snack2 = new Text(temp4);
		snack2.setStyle(textStyle);
		Text dinner = new Text(temp5);
		dinner.setStyle(textStyle);
		Text snack3 = new Text(temp6);
		snack3.setStyle(textStyle);
		Text notes = new Text(temp7);
        notes.setStyle(textStyle);
        Button back = new Button("Back");
        back.setStyle(buttonStyle);
        back.setOnAction(e-> {
            window.close();
            mealPlanPage.display();
        });

        muscle.getChildren().addAll(breakfast, snack1, lunch, snack2, dinner, snack3, notes, back);
		pane.add(muscle, 0 , 1);
		scan.close();
		return pane;
	}

}