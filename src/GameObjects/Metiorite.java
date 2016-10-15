package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;
import org.newdawn.slick.Image;

public class Metiorite extends GameObject {
	Image img;
	
	
	public void init(GameContainer container) throws SlickException{
		img = new Image("res/myimage.png");
		
	}

	public Metiorite(int xCoord, int yCoord, byte layer) {
		super(xCoord, yCoord, layer);
		this.layer = 6;
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g){
		img.draw(50,50);
	}

}
