package Main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
			
				JFrame gameWindow = new JFrame();
				gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameWindow.setResizable(false);
				gameWindow.setTitle("Snake");
				
				GamePanel panel = new GamePanel();
				
				gameWindow.add(panel);
				gameWindow.pack();
				gameWindow.setLocationRelativeTo(null);
				gameWindow.setVisible(true);
				
			}
			
		});
		
	}

}
