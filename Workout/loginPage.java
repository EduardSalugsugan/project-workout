import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class loginPage implements EventHandler<ActionEvent>{

	String checkUser, checkPW;
	private static GridPane logPane = createLoginForm();
	private static GridPane signPane = createLoginForm();
	private static Scene logScene = new Scene(logPane, 450, 300);
	private static Scene signScene = new Scene(signPane, 450, 300);
	private static Stage main = new Stage();
	
	public static void display() {
		setLoginWindow();
	}
	
	private static void setLoginWindow() {
		main.setOnCloseRequest(e -> closeWindow());
		main.setTitle("User Login");
		main.centerOnScreen();
		logUIControls(logPane);
		main.setScene(logScene);
		main.show();
	}

	private static GridPane createLoginForm() {
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		ColumnConstraints columnOneConstrains = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstrains.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		
		gridPane.getColumnConstraints().addAll(columnOneConstrains, columnTwoConstrains);
		
		return gridPane;
	}
	
	private static void logUIControls(GridPane gridPane) {
		Label headerLabel = new Label("Login Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		Label userNameLabel = new Label("Username: ");
		gridPane.add(userNameLabel, 0, 1);
		
		TextField userName = new TextField();
		userName.setPrefHeight(40);
		gridPane.add(userName, 1, 1);
		
		Label passwordLabel = new Label("Password: ");
		gridPane.add(passwordLabel, 0, 2);
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(40);
		gridPane.add(passwordField, 1, 2);

		Button signUpButton = new Button("Sign Up");
		signUpButton.setPrefHeight(20);
		signUpButton.setDefaultButton(true);
		signUpButton.setPrefWidth(80);
		gridPane.add(signUpButton, 1, 3, 2, 1);
		GridPane.setHalignment(signUpButton, HPos.LEFT);
		GridPane.setMargin(signUpButton, new Insets(20, 0, 20, 0));

		Button loginButton = new Button("Login");
		loginButton.setPrefHeight(20);
		loginButton.setDefaultButton(true);
		loginButton.setPrefWidth(80);
		gridPane.add(loginButton, 0, 3, 2, 1);
	//	GridPane.setHalignment(loginButton, HPos.CENTER);
		GridPane.setMargin(loginButton, new Insets(20, 0, 20, 0));
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			private BufferedWriter writer;

			@Override
			public void handle(ActionEvent event) {
				if(userName.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Please enter you name");
					return;
				}
				if(passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Please enter a password");
					return;
				}
				try {
					String accountInfo = userName.getText() + ", " + passwordField.getText() + ", ";
					File accountFile = new File("Accounts.txt");
					
					BufferedReader reader = new BufferedReader(new FileReader(accountFile));
					String fileReader;
					while((fileReader = reader.readLine()) != null) {
						if(fileReader.contains(userName.getText()) && fileReader.contains(passwordField.getText())) {
							showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Success", "Login Successful");
							break;
						}
						else {
							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Incorrect Username or Password");
						}
					}
					reader.close();
					userName.setText("");
					passwordField.setText("");
				}catch(IOException e) {
					System.out.println("An error has occured");
					e.printStackTrace();
				}
			}
		});

		signUpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				signUIControls(signPane);
				main.setScene(signScene);
				main.show();
			}
		
		});
	}

	private static void signUIControls(GridPane gridPane) {
		Label headerLabel = new Label("Sign Up Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		Label userNameLabel = new Label("Username: ");
		gridPane.add(userNameLabel, 0, 1);
		
		TextField userName = new TextField();
		userName.setPrefHeight(40);
		gridPane.add(userName, 1, 1);
		
		Label passwordLabel = new Label("Password: ");
		gridPane.add(passwordLabel, 0, 2);
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(40);
		gridPane.add(passwordField, 1, 2);
				
		Label userWeightLabel = new Label("Weight(lbs): ");
		gridPane.add(userWeightLabel, 0, 3);
		
		TextField userWeight = new TextField();
		userWeight.setPrefHeight(40);
		gridPane.add(userWeight, 1, 3);
		
		Button loginButton = new Button("Login");
		loginButton.setPrefHeight(40);
		loginButton.setDefaultButton(true);
		loginButton.setPrefWidth(100);
		gridPane.add(loginButton, 1, 4, 2, 1);
		GridPane.setHalignment(loginButton, HPos.LEFT);
		GridPane.setMargin(loginButton, new Insets(20, 0, 20, 0));

		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 4, 2, 1);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
		
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			private BufferedWriter writer;

			@Override
			public void handle(ActionEvent event) {
				if(userName.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Please enter you name");
					return;
				}
				if(userWeight.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Please enter you weight");
					return;
				}
				if(passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Please enter a password");
					return;
				}
				try {
					String accountInfo = userName.getText() + ", " + passwordField.getText() + ", " + userWeight.getText();
					File accountFile = new File("Accounts.txt");
					if(accountFile.createNewFile()) {
						System.out.println("File created: " + accountFile.getName());
					}
					else 
						System.out.println("File already exists");
					
					writer = new BufferedWriter(new FileWriter(accountFile));
					writer.write(accountInfo);
					writer.close();
					showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Success", "Registration Successful");
				}catch(IOException e) {
					System.out.println("An error has occured");
					e.printStackTrace();
				}
				
			}
		});

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				main.setScene(logScene);
				main.show();
			}
		
		});
	}

	private static void showAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.show();
	}

	public static void closeWindow() {
		main.close();
		homePage.display();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
	

