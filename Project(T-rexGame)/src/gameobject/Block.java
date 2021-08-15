package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.color.*;
import java.awt.image.BufferedImage;

public class Block extends Enemy {
	
	public static final int Y_pos = 90;
	
	private int Xpos;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter m;
	
	private Rectangle rectBound;
	
	public Block(MainCharacter m, int Xpos, int width, int height, BufferedImage image) {
		this.Xpos = Xpos;
		this.width = width;
		this.height = height;
		this.image = image;
		this.m = m;
		rectBound = new Rectangle();
	}
	
	public void update()
	{
		Xpos-= m.getSpeedX();
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(image, Xpos, Y_pos - image.getHeight(), null);
		g.setColor(Color.red);
	}
	public Rectangle getBound() {
		rectBound = new Rectangle();
		rectBound.x = (int) Xpos + (image.getWidth() - width)/2;
		rectBound.y = Y_pos - image.getHeight() + (image.getHeight() - height)/2;
		rectBound.width = width;
		rectBound.height = height;
		return rectBound;
	}

	@Override
	public boolean isOutOfScreen() {
		if(Xpos < -image.getWidth()) {
			return true;
		}
		return false;
	}
	
}

	
	
	
	
	
	
	
	
	
	


