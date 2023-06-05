package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2902743083222949938L;
	public final int SCREEN_WIDTH = 600;
	public final int SCREEN_HEIGHT = 600;
	public final int TILE_SIZE = 25;
	public final int GAME_TILES = (SCREEN_WIDTH * SCREEN_HEIGHT) / TILE_SIZE;
	static final int DELAY = 100;
	private Timer timer;
	
	public enum STATE {
		START_MENU,
		GAME,
		GAME_OVER
	};
	public STATE state = STATE.START_MENU;
	
	KeyMovement keyM = new KeyMovement(this);
	Snake snake = new Snake(this, keyM);
	Apple apple = new Apple(this, snake);
	Menus menu = new Menus(this, apple);
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.addKeyListener(keyM);
		this.setFocusable(true); 
	}
	
	public void startMenu(Graphics g) {
		menu.startMenu(g);
	}
	
	public void startGame() {
		apple.newApple();
		state = STATE.GAME;
		timer = new Timer(DELAY, this);
		timer.start();	
	}
	
	public void gameOver(Graphics g) {
		stopTimer();
		menu.gameOverMenu(g);
		snake.bodyParts = 3;
		apple.applesEaten = 0;
		keyM.direction = "right";
		for(int i = 0; i < snake.x.length; i ++) {
			snake.x[i] = 0;
			snake.y[i] = 0;
		}
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if(state == STATE.START_MENU) {
			startMenu(g);
		}
		else if(state == STATE.GAME) {
			snake.draw(g);
			apple.draw(g);
			g.setColor(Color.red);
			g.setFont(new Font("chewy", Font.BOLD, 25));
			FontMetrics metrics3 = g.getFontMetrics(g.getFont());
			g.drawString("Score: " + apple.applesEaten, (SCREEN_WIDTH - metrics3.stringWidth("Score: " + apple.applesEaten)) / 2, g.getFont().getSize());
		}
		else if(state == STATE.GAME_OVER) {
			gameOver(g);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(state == STATE.GAME) {
			snake.move();
			apple.checkApple();
			snake.checkCollision();
		}
		repaint();
	}
}
