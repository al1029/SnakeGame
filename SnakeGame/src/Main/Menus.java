package Main;

import java.awt.*;

public class Menus {
	
	GamePanel gp;
	Apple apple;
	
	
	public Menus(GamePanel gp, Apple apple) {
		this.gp = gp;
		this.apple = apple;
	}

	public void startMenu(Graphics g) {
		//draw title screen
		g.setColor(Color.white);
		g.setFont(new Font("chewy", Font.BOLD, 60));
		FontMetrics metrics1 = g.getFontMetrics(g.getFont());
		g.drawString("Snake", (gp.SCREEN_WIDTH - metrics1.stringWidth("Snake")) / 2, 150);
		
		//draw "press Enter to Start..."
		g.setFont(new Font("chewy", Font.BOLD, 30));
		FontMetrics metrics2 = g.getFontMetrics(g.getFont());
		g.drawString("Press Enter to Start...", (gp.SCREEN_WIDTH - metrics2.stringWidth("Press Enter to Start...")) / 2, 300);
		
	}
	
	public void gameOverMenu(Graphics g) {
		//draw game over text
		g.setColor(Color.white); 
		g.setFont(new Font("chewy", Font.BOLD, 60));
		FontMetrics metrics1 = g.getFontMetrics(g.getFont());
		g.drawString("Game Over", (gp.SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, 150);
		
		//draw "press enter to return to continue..."
		g.setFont(new Font("chewy", Font.BOLD, 30));
		FontMetrics metrics2 = g.getFontMetrics(g.getFont());
		g.drawString("Press Enter to Continue...", (gp.SCREEN_WIDTH - metrics2.stringWidth("Press Enter to Continue...")) / 2, 300);
		
		//draw score
		g.setColor(Color.red);
		g.setFont(new Font("chewy", Font.BOLD, 25));
		FontMetrics metrics3 = g.getFontMetrics(g.getFont());
		g.drawString("Score: " + apple.applesEaten, (gp.SCREEN_WIDTH - metrics3.stringWidth("Score: " + apple.applesEaten)) / 2, g.getFont().getSize());
		
	}
}
