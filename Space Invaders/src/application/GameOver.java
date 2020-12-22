package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
	
	private Stage window;
	
	public GameOver(Stage window) {
		this.window = window;
	}
	
	public Scene getScene() {
		Label lbl_title = new Label("GAME OVER");
		
		Button btn_start = new Button("RETRY");
		btn_start.setOnAction(e -> {
			Game game = new Game(window);			
			Scene gameScene = game.getGameScene();	
			window.setScene(gameScene);
		});
		
		Button btn_menu = new Button("MENU");
		
		btn_menu.getStyleClass().add("danger");
		btn_menu.setOnAction(e -> {
			Menu menu = new Menu(window);
			Scene menuScene = menu.getMenuScene();
			window.setScene(menuScene);
		});
		
		VBox menu = new VBox(40);
		menu.getChildren().addAll(lbl_title, btn_start, btn_menu);
		menu.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(menu, 800, 800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		return scene;
	}
}
