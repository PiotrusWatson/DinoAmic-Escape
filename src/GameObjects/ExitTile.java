package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;


public class ExitTile extends GameObject{
	
	public Image door;
	
	
	public ExitTile(int xCoord, int yCoord, byte layer) throws SlickException{
		super(xCoord, yCoord, layer);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException{
		door = new Image("src/res/exit.png");
		}
	
	public void render(GameContainer container, Graphics g){

		door.draw((float)this.xCoord, (float)this.yCoord);
	}
	
	public void update(){
		
	}

}