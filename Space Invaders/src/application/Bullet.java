package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Bullet {

	private final int WIDTH = 10, HEIGHT = 10, SPEED = 25;
	private int x, y;
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		y -= SPEED;
	}
	
	public void render(GraphicsContext g) {
						
		g.setFill(Color.BLACK);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public int getY() {
		return y;
	}
	
	public boolean hit(Enemy enemy) {
		
		if (x >= enemy.getX() && x <= enemy.getX() + enemy.getWidth() && y >= enemy.getY() && y <= enemy.getY() + enemy.getHeight())
			return true;
		
		if (enemy.getX() - x < WIDTH && x + WIDTH <= enemy.getX() + enemy.getWidth() && enemy.getY() - y < HEIGHT && y + HEIGHT <= enemy.getY() + enemy.getHeight())
			return true;
		
		return false;
	}
}
