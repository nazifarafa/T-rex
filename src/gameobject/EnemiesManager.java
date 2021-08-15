package gameobject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.Resource;

public class EnemiesManager {
	
	private BufferedImage cactus1;
	private BufferedImage cactus2;
	private BufferedImage block1;
	private Random rand;
	
	private List<Enemy> enemies;
	private MainCharacter mainCharacter;
	
	public EnemiesManager(MainCharacter mainCharacter) {
		rand = new Random();
		cactus1 = Resource.getResouceImage("data/newcactus1.png");
		cactus2 = Resource.getResouceImage("data/newcactus2.png"); 
		block1 = Resource.getResouceImage("data/singleblockeasy.png");  
		enemies = new ArrayList<Enemy>();
		this.mainCharacter = mainCharacter;
		enemies.add(createEnemy());
		enemies.add(createmoreEnemy());
	}
	
	public void update() {
		for(Enemy e : enemies) {
			e.update();
		}
		Enemy enemy = enemies.get(0);
		if(enemy.isOutOfScreen()) {
			mainCharacter.upScore();
			enemies.clear();
			enemies.add(createEnemy());
			enemies.add(createmoreEnemy());
		}
	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	private Enemy createEnemy() {
		// if (enemyType = getRandom)
		int type = rand.nextInt(3);
		if(type == 0) {
			return new Cactus(mainCharacter, 900, cactus1.getWidth() - 10, cactus1.getHeight() - 10, cactus1);
		} else if (type==1) {
			return new Cactus(mainCharacter, 900, cactus2.getWidth() - 10, cactus2.getHeight() - 10, cactus2);
		}
		else 
		{
			return new Block(mainCharacter, 600, block1.getWidth(), block1.getHeight(), block1);
		}
	}
	
	
	
	private Enemy createmoreEnemy() {
		// if (enemyType = getRandom)
		int type2 = rand.nextInt(1);
		if(type2 == 0) {
			return new Cactus(mainCharacter, 350, cactus1.getWidth() - 10, cactus1.getHeight() - 10, cactus1);
		} else  {
			return new Lowerblock(mainCharacter, 850, block1.getWidth()-10 , block1.getHeight()-10, block1);
		}
	}
	
	
	
	
	
	
	
	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (mainCharacter.getBound().intersects(e.getBound())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(createEnemy());
		enemies.add(createmoreEnemy());
	}
	
}
