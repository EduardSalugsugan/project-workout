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

public class accountPage {
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static Account account;
//	private static Account changedAccount;
	
	public static void display() {
		account = Account.getCurrentAccount();
		setAccountWindow();
	}
	
	
	private static void setAccountWindow() {
		window.setTitle("User Account");
		window.centerOnScreen();
		layout = createAccountMainPage();
		page = new Scene(layout, 220, 325); 
		window.setScene(page);
		window.show();
	}
	
	private static GridPane createAccountMainPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setVgap(5);
		
		Label nameLabel = new Label("" +account.getUsername());
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

		
		VBox accountOptionsBox = new VBox();
		accountOptionsBox.setAlignment(Pos.CENTER);
		accountOptionsBox.setSpacing(5);
		Button changeAccountName = new Button("Change Name");
		changeAccountName.setPrefSize(200, 70);
		Button changePass = new Button("Change Password");
		changePass.setPrefSize(200, 70);
		Button updateAge = new Button("Update Age");
		updateAge.setPrefSize(200, 70);
		Button updateWeight = new Button("Update Weight");
		updateWeight.setPrefSize(200, 70);
		
		Button logOut = new Button("Log out");
		logOut.setPrefSize(200, 70);
		logOut.setOnAction(e ->{
			showLogOutAlert(Alert.AlertType.CONFIRMATION, window, "Logged Out", "Account logged out");
		});
		
		Button goBack = new Button("Back");
		goBack.setPrefSize(200, 70);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});
		accountOptionsBox.getChildren().addAll(changeAccountName, changePass, updateAge, updateWeight, logOut, goBack);
		
		pane.add(accountOptionsBox, 0 , 1);

		return pane;
	}
	
	private static void showLogOutAlert(Alert.AlertType alertType, Window win, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(win);
		alert.show();
		alert.setOnCloseRequest(e -> {
			Account.logOut();
			window.close();
			homePage.display();
		});
		
	}
	
	
	

}
