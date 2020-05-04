import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class loginPage {

	String checkUser, checkPW;
	private static GridPane logPane = createLoginForm();
	private static GridPane signPane = createLoginForm();
	private static Scene logScene = new Scene(logPane, 450, 300);
	private static Scene signScene = new Scene(signPane, 450, 375);
	private static Stage main = new Stage();
	private static File accountFile = new File("Accounts.txt");
	private static File currentAccount = new File("currentAccount.txt");
	private static Account account;
	
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
		
		loginButton.setOnAction(e -> {
			try {
				if(signIn(userName.getText(), passwordField.getText()) == true){
					showLoggedInAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Success", "Login Successful");
				}
				else
					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error", "Incorrect Username or Password");
			}catch(IOException i) {
				System.out.println("Error");
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
		
		Label genderLabel = new Label("Gender: ");
		gridPane.add(genderLabel, 0, 3);
		
		ComboBox<String>genderBox = new ComboBox<String>();
		genderBox.setPrefWidth(250);
		genderBox.getItems().addAll("Male", "Female");
		genderBox.setPrefHeight(40);
		gridPane.add(genderBox, 1, 3);
		
		Label ageLabel = new Label("Age: ");
		gridPane.add(ageLabel, 0, 4);
		
		TextField age = new TextField();
		gridPane.add(age, 1, 4);
		
				
		Label userWeightLabel = new Label("Weight(lbs): ");
		gridPane.add(userWeightLabel, 0, 5);
		
		TextField userWeight = new TextField();
		userWeight.setPrefHeight(40);
		gridPane.add(userWeight, 1, 5);
		
		Button loginButton = new Button("Login");
		loginButton.setPrefHeight(40);
		loginButton.setDefaultButton(true);
		loginButton.setPrefWidth(100);
		gridPane.add(loginButton, 1, 6, 2, 1);
		GridPane.setHalignment(loginButton, HPos.LEFT);
		GridPane.setMargin(loginButton, new Insets(20, 0, 20, 0));
		loginButton.setOnAction(e -> {
			logUIControls(logPane);
			main.setScene(logScene);
			main.show();
		});

		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 6, 2, 1);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
		
		
		submitButton.setOnAction(e -> {
			account = new Account();
			account.setUsername(userName.getText());
			account.setPassword(passwordField.getText());
			account.setAge(Integer.parseInt(age.getText()));
			account.setGender(genderBox.getValue());
			account.setWeight(Integer.parseInt(userWeight.getText()));
			try {
				saveAccount();
			}
			catch(IOException i) {
				System.out.println("Error");
			}
			
		});
		
		
	}
	
	private static boolean signIn(String userName, String passWord) throws IOException{
		
		ArrayList<Account> accounts = Account.getAllAccounts(accountFile.getName());
		BufferedWriter writer;
		
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getUsername().equals(userName) && accounts.get(i).getPassword().equals(passWord)) {
				if(!currentAccount.exists()) {
					currentAccount.createNewFile();
					System.out.println("File created: " + accountFile.getName());
				}
				try {
					writer = new BufferedWriter(new FileWriter(currentAccount));
					String currentAccountString = accounts.get(i).getUsername() + "," + accounts.get(i).getPassword() + "," +
							accounts.get(i).getAge() + "," + accounts.get(i).getGender() + "," + accounts.get(i).getWeight();
					writer.write(currentAccountString);
					writer.close();
					
				}catch(IOException e) {
					System.out.println("Error");
				}
				
				return true;
			}
		}
		
		return false;
		
	}
	
	private static void saveAccount() throws IOException {
		
		String accountInfo = "";

		if(!accountFile.exists()) {
			accountFile.createNewFile();
			System.out.println("File created: " + accountFile.getName());
		}

		
		
		if(account.getUsername().isEmpty() || account.getPassword().isEmpty()||
				account.getGender().equals(null) || account.getAge() == 0|| account.getWeight() == 0 ) {
			showAlert(Alert.AlertType.ERROR, signPane.getScene().getWindow(), "Error", "Please enter all information");
			return;
		}
		
		try(FileWriter fw = new FileWriter(accountFile, true)) {
			BufferedWriter writer = new BufferedWriter(fw);
			accountInfo = account.getUsername() + "," + account.getPassword() + "," + account.getAge() +
					"," + account.getGender() + "," + account.getWeight() +"\n";
			
			writer.write(accountInfo);
			writer.close();
			showAlert(Alert.AlertType.CONFIRMATION, signPane.getScene().getWindow(), "Success", "Registration Successful");
		
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
	
	private static void showLoggedInAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.setOnCloseRequest(e ->{
			main.close();
			homePage.display();
		});
		alert.show();
	}

	public static void closeWindow() {
		main.close();
		homePage.display();
	}


}
	

