package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Enemy {

	private final int WIDTH = 20, HEIGHT = 20, SPEED = 2;
	private int x, y;
	
	//private ArrayList<Bullet> bullets;
	
	public Enemy() {
		//bullets = new ArrayList<Bullet>();
		x = (int)(Math.random() * 800);
		y = 0;
	}
	
	public void tick() {
		/*for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
			
			if (bullets.get(i).getY() <= -30) {
				bullets.remove(i);
			}
		}*/
		
		y += SPEED;
	}
	
	public void render(GraphicsContext g) {
		
		/*for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}*/
						
		g.setFill(Color.GREEN);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	/*public void shoot() {
		bullets.add(new Bullet(x + (WIDTH/2), y));
	}*/
}
