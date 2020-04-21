import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

public class createMealPlan{
	
	private static Stage window = new Stage();
	private static GridPane layout;
    private static Scene createMyPlan;
    private static myMeal meal;
    private static File mealFile = new File("mealPlan.txt");
	
	public static void display() {
		setCreatePlanWindow();
	}
	
	private static void setCreatePlanWindow() {
		window.setTitle("Create Meal Plan");
		window.centerOnScreen();
		layout = createFoodPlanPage();
		createMyPlan = new Scene(layout, 400, 800); 
		window.setScene(createMyPlan);
		window.show();
		window.setResizable(false);
    }
    
	private static GridPane createFoodPlanPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Create Meal Plan");
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);
		
		VBox create = new VBox();
		create.setAlignment(Pos.CENTER_LEFT);
		create.setSpacing(15);

        Label breakfast = new Label("Breakfast");
		TextField breakfastTextField = new TextField();
        breakfastTextField.setPrefHeight(40);
        
        Label snack1 = new Label("Snack 1");
		TextField snack1TextField = new TextField();
        snack1TextField.setPrefHeight(40);

        Label lunch = new Label("Lunch");
		TextField lunchTextField = new TextField();
        lunchTextField.setPrefHeight(40);

        Label snack2 = new Label("Snack 2");
		TextField snack2TextField = new TextField();
        snack2TextField.setPrefHeight(40);

        Label dinner = new Label("Dinner");
		TextField dinnerTextField = new TextField();
        dinnerTextField.setPrefHeight(40);

        Label snack3= new Label("Snack 3");
		TextField snack3TextField = new TextField();
        snack3TextField.setPrefHeight(40);

        Label notes = new Label("Notes");
		TextField notesTextField = new TextField();
        notesTextField.setPrefHeight(40);

        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(80,20);
        
        Button back = new Button("Back");
        back.setPrefSize(80,20);


		create.getChildren().addAll(breakfast,breakfastTextField,snack1,snack1TextField,lunch,lunchTextField,snack2,snack2TextField,dinner,dinnerTextField,snack3,snack3TextField,notes,notesTextField,submitButton,back);
		
        pane.add(create, 0 , 1);
        
		submitButton.setOnAction(e -> {
			meal = new myMeal();
			meal.setBreakfast(breakfastTextField.getText());
			meal.setSnack1(snack1TextField.getText());
			meal.setLunch(lunchTextField.getText());
			meal.setSnack2(snack2TextField.getText());
            meal.setDinner(dinnerTextField.getText());
            meal.setSnack3(snack3.getText());
            meal.setNotes(notesTextField.getText());
			try {
                saveAccount();
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

		try(FileWriter fw = new FileWriter(mealFile, true)) {
			BufferedWriter writer = new BufferedWriter(fw);
			mealInfo = meal.getBreakfast() + "," + meal.getSnack1() + "," + meal.getLunch() +
					"," + meal.getSnack2() + "," + meal.getDinner() + "," + meal.getSnack3() + "," + meal.getNotes() + "\n";
			
			writer.write(mealInfo);
			writer.close();
		
		}catch(IOException e) {
			System.out.println("Error");
		}	

		
	}

}
