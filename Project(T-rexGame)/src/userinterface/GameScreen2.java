package userinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import gameobject.Clouds;
import gameobject.EnemiesManager;
import gameobject.Land;
import gameobject.MainCharacter;
import util.Resource;

public class GameScreen2 extends JPanel implements Runnable, KeyListener {

	private static final int START_GAME_STATE = 0;
	private static final int GAME_PLAYING_STATE = 1;
	private static final int GAME_OVER_STATE = 2;
	
	private Land land;
	private MainCharacter mainCharacter;
	private EnemiesManager enemiesManager;
	private Clouds clouds;
	private Thread thread;

	private boolean isKeyPressed;

	private int gameState = START_GAME_STATE;

	private BufferedImage replayButtonImage;
	private BufferedImage gameOverButtonImage;

	public GameScreen2() {
		mainCharacter = new MainCharacter();
		land = new Land(GameWindow.SCREEN_WIDTH, mainCharacter);
		mainCharacter.setSpeedX(4);
		replayButtonImage = Resource.getResouceImage("data/replay_button2.png"); 
		gameOverButtonImage = Resource.getResouceImage("data/rsz_gameover.png"); 
		enemiesManager = new EnemiesManager(mainCharacter);
		clouds = new Clouds(GameWindow.SCREEN_WIDTH, mainCharacter);
	}

	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}

	public void gameUpdate() {
		if (gameState == GAME_PLAYING_STATE) {
			clouds.update();
			land.update();
			mainCharacter.update();
			enemiesManager.update();
			if (enemiesManager.isCollision()) {
				mainCharacter.playDeadSound();
				gameState = GAME_OVER_STATE;
				mainCharacter.dead(true);
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.decode("#e2f3f2"));
		g.fillRect(0, 0, getWidth(), getHeight()); 

		switch (gameState) {
		case START_GAME_STATE:
			mainCharacter.draw(g);
			break;
		case GAME_PLAYING_STATE:
		case GAME_OVER_STATE:
			clouds.draw(g);
			land.draw(g);
			enemiesManager.draw(g);
			mainCharacter.draw(g);
			g.setColor(Color.black);
			g.drawString("HI " + mainCharacter.score, 500, 20);
			if (gameState == GAME_OVER_STATE) {
				g.drawImage(gameOverButtonImage, 160, 30, null); 
				g.drawImage(replayButtonImage, 283, 80, null);
				 
			}
			break;
		}
	}

	@Override
	public void run() {

		//int fps = 100;
	//	long msPerFrame = 1000 * 1000000 / fps;
	//	long lastTime = 0;
	//	long elapsed;
		
	//	int msSleep;
	// nanoSleep;

	//	long endProcessGame;
	//	long lag = 0;

		while (true) {
			gameUpdate();
			repaint();
			//endProcessGame = System.nanoTime();
		//	elapsed = (lastTime + msPerFrame - System.nanoTime());
		//	msSleep = (int) (elapsed / 1000000);
		//	nanoSleep = (int) (elapsed % 1000000);
		//	if (msSleep <= 0) {
		//		lastTime = System.nanoTime();
		//		continue;
		//	}
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//	lastTime = System.nanoTime();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!isKeyPressed) {
			isKeyPressed = true;
			switch (gameState) {
			case START_GAME_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameState = GAME_PLAYING_STATE;
				}
				if(e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
					new Frame2();
				}
				break;
			case GAME_PLAYING_STATE:
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					mainCharacter.jump();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					mainCharacter.down(true);
				}
				if (e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
					new Frame2();
				}

				break;
			case GAME_OVER_STATE:
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					gameState = GAME_PLAYING_STATE;
					resetGame();
				}
				if (e.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
					new Frame2();
				}
				break;

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isKeyPressed = false;
		if (gameState == GAME_PLAYING_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				mainCharacter.down(false);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private void resetGame() {
		enemiesManager.reset();
		mainCharacter.dead(false);
		mainCharacter.reset();
	}

}
