package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;


public class Block extends GameObject{
	
	private SpriteSheet blockSprite;
	private Animation explode;
	private Image blockStatic;
	public int health;
	public static int maxHealth;
	final public static int ID = 2;
	//public Image floor;
	
	
	public Block(int xCoord, int yCoord) throws SlickException{
		super(xCoord, yCoord);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException{
		blockSprite = new SpriteSheet("src/res/hardRockAnimationSSheet.png", SCALE, SCALE);
		explode = new Animation(blockSprite, 100);
		blockStatic = explode.getImage(0);
		maxHealth = 50;
		health = maxHealth;
		//floor = new Image("src/res/floor.png");
		}
	
	public void render(GameContainer container, Graphics g){
		//floor.draw((float)this.xCoord, (float)this.yCoord);
		//if(isRock){
			blockStatic.draw((float)this.xCoord, (float)this.yCoord);			
		//}

	}
	
	public void update(){
		
	}
	
	public void takeDamage(int damage){
		health -= damage;
	}
	
	public void destroyBlock(){
		explode.draw(this.xCoord, this.yCoord);
		if (explode.getFrame() == explode.getFrameCount() - 1)
		{
			
		}
	}

}
