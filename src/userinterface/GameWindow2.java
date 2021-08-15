package userinterface;

import javax.swing.JFrame;

public class GameWindow2 extends JFrame {
	
	public static final int SCREEN_WIDTH = 600;
	private GameScreen2 gameScreen;
	
	public GameWindow2() {
		super("Java T-Rex game");
		setSize(SCREEN_WIDTH, 175);
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		gameScreen = new GameScreen2();
		addKeyListener(gameScreen);
		add(gameScreen);
	}
	
	public void startGame() {
		setVisible(true);
		gameScreen.startGame();
	}
	
	/*public static void main(String args[]) {
		(new GameWindow()).startGame();
	}*/
}