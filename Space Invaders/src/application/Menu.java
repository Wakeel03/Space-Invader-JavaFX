package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu {
	
	private Stage window;
	
	public Menu(Stage window) {
		this.window = window;
	}

	public Scene getMenuScene() {
		Label lbl_title = new Label("Space Invaders");
		Button btn_start = new Button("START");
		btn_start.setOnAction(e -> {
			Game game = new Game(window);			
			Scene gameScene = game.getGameScene();	
			window.setScene(gameScene);
		});
		
		Button btn_exit = new Button("EXIT");
		
		btn_exit.getStyleClass().add("danger");
		btn_exit.setOnAction(e -> {
			System.exit(0);
		});
		
		VBox menu = new VBox(40);
		menu.getChildren().addAll(lbl_title, btn_start, btn_exit);
		menu.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(menu,800,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}
	
}
