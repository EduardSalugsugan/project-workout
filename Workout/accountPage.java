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
import javafx.stage.Stage;

public class accountPage {
	
	private static Stage window = new Stage();
	private static GridPane layout;
	private static Scene page;
	private static Account account;
	private static Account changedAccount;
	
	public static void display() {
		account = Account.getCurrentAccount();
		setAccountWindow();
	}
	
	
	private static void setAccountWindow() {
		window.setTitle("User Account");
		window.centerOnScreen();
		layout = createAccountMainPage();
		page = new Scene(layout, 300, 350); 
		window.setScene(page);
		window.show();
		
	}
	
	
	private static GridPane createAccountMainPage() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(50, 20, 20, 20));
		pane.setVgap(25);
		
		Label nameLabel = new Label("Welcome " + account.getUsername());
		nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		pane.add(nameLabel, 0, 0);
		GridPane.setHalignment(nameLabel, HPos.CENTER);
		GridPane.setValignment(nameLabel, VPos.TOP);
		GridPane.setHgrow(nameLabel, Priority.ALWAYS);

		
		VBox accountOptionsBox = new VBox();
		accountOptionsBox.setAlignment(Pos.CENTER);
		accountOptionsBox.setSpacing(25);
		Button changeAccountName = new Button("Change Name");
		changeAccountName.setPrefSize(150, 20);
		Button changePass = new Button("Change Password");
		changePass.setPrefSize(150, 20);
		Button updateAge = new Button("Update Age");
		updateAge.setPrefSize(150, 20);
		Button updateWeight = new Button("Update Weight");
		updateWeight.setPrefSize(150, 20);
		Button goBack = new Button("Back");
		goBack.setPrefSize(150, 20);
		goBack.setOnAction(e -> {
			window.close();
			homePage.display();
		});
		accountOptionsBox.getChildren().addAll(changeAccountName, changePass, updateAge, updateWeight, goBack);
		
		pane.add(accountOptionsBox, 0 , 1);
		
		
		
		return pane;
	}
	
	

}
