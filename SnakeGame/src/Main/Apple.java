	package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	
	GamePanel gp;
	Snake snake;

	public int appleX;
	public int appleY;
	public int applesEaten = 0;
	private Random random;
	
	public Apple(GamePanel gp, Snake snake) {
		this.gp = gp;
		this.snake = snake;
	}
	
	public void newApple() {
		random = new Random();
		appleX = random.nextInt((int) (gp.SCREEN_WIDTH / gp.TILE_SIZE)) * gp.TILE_SIZE;
		appleY = random.nextInt((int) (gp.SCREEN_HEIGHT / gp.TILE_SIZE)) * gp.TILE_SIZE;
		for(int i = 0; i < snake.bodyParts; i++) {
			if(appleX == snake.x[i] && appleY == snake.y[i]) {
				System.out.println("Overlap Avoided");
				newApple();
			}
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, gp.TILE_SIZE, gp.TILE_SIZE);
	}
	
	public void checkApple() {
		if(snake.x[0] == appleX && snake.y[0] == appleY) {
			snake.bodyParts++;
			applesEaten++;
			newApple();
			
		}
	}
	
}
