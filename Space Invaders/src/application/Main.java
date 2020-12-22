package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	private Stage window;
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			
			Menu menu = new Menu(window);
			//Game game = new Game();
			
			Scene menuScene = menu.getMenuScene();
			//Scene gameScene = game.getGameScene();
			
			window.setScene(menuScene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
