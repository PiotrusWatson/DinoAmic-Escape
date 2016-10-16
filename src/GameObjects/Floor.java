package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Floor extends GameObject{
	
	public Image floorSprite;
	
	public void init(GameContainer container) throws SlickException{
		floorSprite = new Image("src/res/floor.png");
	}
	
	public void render(GameContainer container, Graphics g){
		floorSprite.draw((float)this.xCoord, (float)this.yCoord);			
	}
	
	public void update(){
		
	}
	
	public Floor(int xCoord, int yCoord) throws SlickException{
		super(xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}
}
