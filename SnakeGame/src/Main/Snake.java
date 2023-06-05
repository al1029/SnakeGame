package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {

	GamePanel gp;
	KeyMovement keyM;
	
	//game screen array
	public final int[] x;
	public final int[] y;
	public int bodyParts = 3;
	
	public Snake(GamePanel gp, KeyMovement keyM) {
		this.gp = gp;
		this.keyM = keyM;
		x = new int[gp.GAME_TILES];
		y = new int[gp.GAME_TILES];
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < bodyParts; i++) {
			g.setColor(new Color(0, 204, 0));
			g.fillRect(x[i], y[i], gp.TILE_SIZE, gp.TILE_SIZE);
		}
	}
	
	public void move() {
		
		for(int i = bodyParts; i > 0; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(keyM.direction){
		case "up": 
			y[0] -= gp.TILE_SIZE;
			break;
		case "down":
			y[0] += gp.TILE_SIZE;
			break;
		case "left":
			x[0]-= gp.TILE_SIZE;
			break;
		case "right":
			x[0] += gp.TILE_SIZE;
			break;
		};
		
	}
	
	public void checkCollision() {
		
		for(int i = bodyParts; i > 0; i--) {
			if (x[0] == x[i] && y[0] == y[i]) {
				gp.state = GamePanel.STATE.GAME_OVER;
			}
		}
		
		if(x[0] < 0) {
			gp.state = GamePanel.STATE.GAME_OVER;
		}
		if(x[0] > gp.SCREEN_WIDTH) {
			gp.state = GamePanel.STATE.GAME_OVER;

		}
		if(y[0] < 0) {
			gp.state = GamePanel.STATE.GAME_OVER;

		}
		if(y[0] > gp.SCREEN_HEIGHT) {
			gp.state = GamePanel.STATE.GAME_OVER;

		}
	}
	
	
	
	
	
	
	
}
