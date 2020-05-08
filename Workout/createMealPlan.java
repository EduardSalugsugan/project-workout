import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class createMealPlan{
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene createMyPlan;
    private static myMeal meal;
	private static File mealFile = new File("mealPlan.txt");
	private static Scanner scan;
	private static String style = "    -fx-background-color: radial-gradient(center 50% 50% , radius 80% , #69696b ,   #3a3a3a);" + 
			"    -fx-padding: 10;\n" +
			"    -fx-text-fill:  #c6f5f9 ;\n";

	private static String buttonStyle = " -fx-background-color: rgba(3, 252, 248, 0.4);"
	+ " -fx-background-radius: 10; -fx-text-fill: #c6f5f9; -fx-font: 14px Arial; -fx-font-weight: Bold;";
	private static String labelStyle = "-fx-text-fill: #c6f5f9;";
	private static String textStyle = "-fx-fill: #c6f5f9;";
	
	public static void display() {
		setCreatePlanWindow();
	}
	
	private static void setCreatePlanWindow() {
		window.setTitle("Create Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		createMyPlan = new Scene(layout, 400, 820); 
		window.setScene(createMyPlan);
		window.show();
		window.setResizable(false);
	}

	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setStyle(style);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Create Meal Plan");
		nameLabel.setStyle(labelStyle);
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		
		VBox create = new VBox();
		create.setAlignment(Pos.CENTER_LEFT);
		create.setSpacing(15);

		Text insText = new Text("Type none if you choose to not eat on that \ncertain meal and use + to separate food");
		insText.setStyle(textStyle);
		insText.setFont(Font.font("Arial"));

        Label breakfast = new Label("Breakfast");
        breakfast.setStyle(labelStyle);
		TextField breakfastTextField = new TextField();
        breakfastTextField.setPrefHeight(40);
        
        Label snack1 = new Label("Snack 1");
        snack1.setStyle(labelStyle);
		TextField snack1TextField = new TextField();
        snack1TextField.setPrefHeight(40);

        Label lunch = new Label("Lunch");
        lunch.setStyle(labelStyle);
		TextField lunchTextField = new TextField();
        lunchTextField.setPrefHeight(40);

        Label snack2 = new Label("Snack 2");
        snack2.setStyle(textStyle);
		TextField snack2TextField = new TextField();
        snack2TextField.setPrefHeight(40);

        Label dinner = new Label("Dinner");
        dinner.setStyle(labelStyle);
		TextField dinnerTextField = new TextField();
        dinnerTextField.setPrefHeight(40);

        Label snack3= new Label("Snack 3");
        snack3.setStyle(labelStyle);
		TextField snack3TextField = new TextField();
        snack3TextField.setPrefHeight(40);

        Label notes = new Label("Notes");
        notes.setStyle(labelStyle);
		TextField notesTextField = new TextField();
        notesTextField.setPrefHeight(40);

        Button submitButton = new Button("Submit");
        submitButton.setStyle(buttonStyle);
        submitButton.setPrefSize(80,20);
        
        Button back = new Button("Back");
        back.setStyle(buttonStyle);
		back.setPrefSize(80,20);
		back.setOnAction(e -> {
			window.close();
			mealPlanPage.display();
		});

		create.getChildren().addAll(insText,breakfast,breakfastTextField,snack1,snack1TextField,lunch,lunchTextField,snack2,snack2TextField,dinner,dinnerTextField,snack3,snack3TextField,notes,notesTextField,submitButton,back);
		
        pane.add(create, 0 , 1);
        
		submitButton.setOnAction(e -> {
			meal = new myMeal();
			meal.setBreakfast(breakfastTextField.getText());
			meal.setSnack1(snack1TextField.getText());
			meal.setLunch(lunchTextField.getText());
			meal.setSnack2(snack2TextField.getText());
            meal.setDinner(dinnerTextField.getText());
            meal.setSnack3(snack3TextField.getText());
			meal.setNotes(notesTextField.getText());
			try {
				if(breakfastTextField.getText().isEmpty()||snack1TextField.getText().isEmpty()||lunchTextField.getText().isEmpty()||snack2TextField.getText().isEmpty()||dinnerTextField.getText().isEmpty()||snack3TextField.getText().isEmpty()||notesTextField.getText().isEmpty()){
					showAlert(Alert.AlertType.ERROR, window.getScene().getWindow(), "Error", "Please enter all information");
					return;
				}
				else {
					showOkAlert(Alert.AlertType.CONFIRMATION, window.getScene().getWindow(), "Success", "Your meal plan has been made");
					saveAccount();
				}
			}
			catch(IOException i) {
				System.out.println("Error");
			}	
		});
		
		return pane;

	}
	
    private static void saveAccount() throws IOException {

		String mealInfo = "";
		if(!mealFile.exists()) {
			mealFile.createNewFile();
			System.out.println("File created: " + mealFile.getName());
		}

		Account account = Account.getCurrentAccount();
		String temp;
		File tempFile = new File("tempMeal.txt");	
		try(FileWriter fw = new FileWriter(mealFile, true)) {
			BufferedWriter writer = new BufferedWriter(fw);
			mealInfo = account.getUsername() + "," + meal.getBreakfast() + "," + meal.getSnack1() + "," + meal.getLunch() + "," + meal.getSnack2() + "," + meal.getDinner() + "," + meal.getSnack3() + "," + meal.getNotes();
			writer.write(mealInfo);
			writer.close();

			File file = new File("mealPlan.txt");
			scan = new Scanner(file);
			String found = account.getUsername();
			String a[];

			FileWriter bw = new FileWriter(tempFile);
			BufferedWriter w2 = new BufferedWriter(bw);
			boolean bool = false;
			while(scan.hasNextLine()){
				temp = scan.nextLine();
				a = temp.split(",");
				if(a[0].equals(found)){
	 				if(bool){
		 				break;
	 				}	
	 			bool = true;
	 			temp = mealInfo;
	 			}
		 		w2.write(temp+"\n");
			}
			bool = false;
			w2.close();
			scan = new Scanner(tempFile);
			bw = new FileWriter(file);
			w2 = new BufferedWriter(bw);
			while(scan.hasNextLine()){
				temp = scan.nextLine();
				w2.write(temp+"\n");
			}
		scan.close();
		w2.close();
		}catch(IOException e) {
			System.out.println("Error");
		}	
	}

	private static void showAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.show();
	}
	
	private static void showOkAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.setOnCloseRequest(e ->{
			window.close();
			mealPlanPage.display();
		});
		alert.show();
	}

}
