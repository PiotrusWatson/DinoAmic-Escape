package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;


public class MeteioriteGround extends GameObject{
	
	public Image met;
	
	
	public MeteioriteGround(int xCoord, int yCoord) throws SlickException{
		super(xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException{
		met = new Image("src/res/met.png");
		}
	
	public void render(GameContainer container, Graphics g){

		met.draw((float)this.xCoord, (float)this.yCoord);
	}
	
	public void update(){
		
	}

}