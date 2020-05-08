import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class mealPlanPage {

	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene foodplan;
	private static File mealFile = new File("mealPlan.txt");
	private static boolean bool2;
	private static boolean b;
	private static String style = "    -fx-background-color: radial-gradient(center 50% 50% , radius 80% , #69696b ,   #3a3a3a);" + 
			"    -fx-padding: 10;\n" +
			"    -fx-text-fill:  #c6f5f9 ;\n";
	private static String textStyle = "-fx-text-fill: #c6f5f9;";
	private static String buttonStyle = " -fx-background-color: rgba(3, 252, 248, 0.4);"
	+ " -fx-background-radius: 10; -fx-text-fill: #c6f5f9; -fx-font: 14px Arial; -fx-font-weight: Bold;";

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
		pane.setStyle(style);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);

		Label nameLabel = new Label("Meal Plans");
		nameLabel.setStyle(textStyle);
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

		VBox foodplan = new VBox();
		foodplan.setAlignment(Pos.CENTER);
		foodplan.setSpacing(5);

		Button Gain = new Button("Muscle Gains");
		Gain.setStyle(buttonStyle);
		Gain.setPrefSize(200, 70);
		Gain.setOnAction(e -> {
			window.close();
			muscleGain.display();
		});

		Button Lost = new Button("Weight Lost");
		Lost.setStyle(buttonStyle);
		Lost.setPrefSize(200, 70);
		Lost.setOnAction(e -> {
			window.close();
			weightLost.display();
		});

		Button Vegan = new Button("Vegan Diet");
		Vegan.setStyle(buttonStyle);
		Vegan.setPrefSize(200, 70);
		Vegan.setOnAction(e -> {
			window.close();
			veganGains.display();
		});

		Button MyPlan = new Button("My Plan");
		MyPlan.setStyle(buttonStyle);
		MyPlan.setPrefSize(200, 70);
		MyPlan.setOnAction(e -> {
			try {
				b = f();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			if(b == false){
				showAlert(Alert.AlertType.ERROR, window.getScene().getWindow(), "Error", "Create a My Plan first");
				System.out.println("Profile not found");
				return;
			}
			bool2 = false;
			if (!mealFile.exists()) {
				showAlert(Alert.AlertType.ERROR, window.getScene().getWindow(), "Error", "Create a My Plan first");
				System.out.println("File doesn't exist");
			} else {
				window.close();
				try {
					myMealPlan.display();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		Button Create = new Button("Create my meal plan");
		Create.setStyle(buttonStyle);
		Create.setPrefSize(200, 70);
		Create.setOnAction(e -> {
			window.close();
			createMealPlan.display();
		});

		Button goBack = new Button("Back");
		goBack.setStyle(buttonStyle);
		goBack.setPrefSize(200, 70);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});

		foodplan.getChildren().addAll(Gain, Lost, Vegan, MyPlan, Create, goBack);

		pane.add(foodplan, 0, 1);

		return pane;
	}

	private static void showAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.show();
	}

	private static boolean f() throws FileNotFoundException {
		Account account = Account.getCurrentAccount();
		File file = new File("tempMeal.txt");
		Scanner scan = new Scanner(file);
		String found = account.getUsername();
		String a[];
		String temp;
		while(scan.hasNextLine()) {
			temp = scan.nextLine();
			a = temp.split(",");
			if (a[0].equals(found)){
				bool2 = true;
				break;
			}
		}
		scan.close();
		return bool2;
	}

}
