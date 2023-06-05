package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMovement implements KeyListener {

	GamePanel gp;
	
	public String direction = "right";
	
	public KeyMovement(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//start menu key input
		if(gp.state == GamePanel.STATE.START_MENU) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				gp.startGame();
			}
		}
		//game input
		else if (gp.state == GamePanel.STATE.GAME) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				if (direction != "down") {
					direction = "up";
				}
				break;
			case KeyEvent.VK_A:
				if (direction != "right") {
					direction = "left";
				}
				break;
			case KeyEvent.VK_S:
				if (direction != "up") {
					direction = "down";
				}
				break;
			case KeyEvent.VK_D:
				if (direction != "left") {
					direction = "right";
				}
				break;
			}
		}
		//game over menu input
		else {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				gp.startGame();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
