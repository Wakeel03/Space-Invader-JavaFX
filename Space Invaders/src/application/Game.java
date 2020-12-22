package application;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game {
	
	private final int FPS = 60;
	public static int score = 0;
	
	private int level = 1;
	
	private Player player;
	
	private ArrayList<Enemy> enemies;
	
	private boolean gameover;
	
	private Stage window;
	
	private AnimationTimer timer;
	
	public Game(Stage window) {
		this.window = window;
	}
	
	public void init() {
		score = 0;
		gameover = false;
		player = new Player();
		enemies = new ArrayList<Enemy>();
	}

	public Scene getGameScene() {
		VBox root = new VBox();
		Canvas canvas = new Canvas(800, 800);
		GraphicsContext g = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		init();
		
		timer = new AnimationTimer() {
			long lastTick = 0;
			long lastTimeEnemy = 0;

			@Override
			public void handle(long now) {
				if(lastTick == 0) {
					lastTick = now;
					
					tick();
					render(g);
					
					return;
				}
				
				if (((now - lastTimeEnemy)/1000000000) > 3/level) {
					enemies.add(new Enemy());
					lastTimeEnemy = now;
				}
				
				if (now - lastTick > 1000000000/FPS) {
					lastTick = now;
					tick();
					render(g);
				}
			}
			
		};
		timer.start();
		
		Scene scene = new Scene(root,800,800);
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
			if (key.getCode() == KeyCode.A) {
				player.move(-1);
			}else if(key.getCode() == KeyCode.D) {
				player.move(1);
			}else if (key.getCode() == KeyCode.SPACE) {
				player.shoot();
			}
		});
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}
	
	private void tick() {
		
		if (gameover) return;
		
		player.tick(enemies);
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
			if (enemies.get(i).getY() >= 725)
				gameover = true;
		}
		
		if (score > 0 && score % 20 == 0) {
			level++;
		}
	}
	
	private void render(GraphicsContext g) {
		
		if (gameover) {
			
			timer.stop();
			
			GameOver go = new GameOver(window);
			//Menu go = new Menu(window);
			window.setScene(go.getScene());
			
			return;
		}
		
		g.clearRect(0, 0, 800, 800);
		
		player.render(g);
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
			
		}
		
		g.setFill(Color.BLUE);
		g.setFont(new Font("", 30));
		g.fillText("Score: " + score, 10, 30);
	}
	
}
