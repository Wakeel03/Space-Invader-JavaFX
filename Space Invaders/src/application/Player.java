package application;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Player {

	private final int WIDTH = 30, HEIGHT = 30, SPEED = 25, y = 725;
	private int x = 380;
	
	private ArrayList<Bullet> bullets;
	
	public Player() {
		bullets = new ArrayList<Bullet>();
	}
	
	public void tick(ArrayList<Enemy> enemies) {
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getY() <= -30) {
				bullets.remove(i);
			}
			
			bullets.get(i).tick();
			
			for (int j = 0; j < enemies.size(); j++) {
				if (bullets.get(i).hit(enemies.get(j))) {
					enemies.remove(j);
					bullets.remove(i);
					Game.score++;
				}
					
			}
		}
	}
	
	public void render(GraphicsContext g) {
		
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
						
		g.setFill(Color.GREEN);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public void move(int index) {
		x += (index * SPEED);
	}
	
	public void shoot() {
		bullets.add(new Bullet(x + (WIDTH/2), y));
	}
}
