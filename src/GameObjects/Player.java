package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Player extends GameObject{
	private static int x = 64;
	private static int y = 64;
	
	private SpriteSheet dinoSprite;
	private Animation dinoAnimation;
	
	public Player(int xCoord, int yCoord, byte layer) throws SlickException {
		super(x, y, layer);

		
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException{
		dinoSprite = new SpriteSheet("src/res/DINODEANWeaponPNG.png", 64, 64);
		dinoAnimation = new Animation(dinoSprite, 100);
		
	}
	public void update(){
		
	}
	
	public void moveLeft(){
		this.xCoord -= 1;
	}
	public void moveRight(){
		this.xCoord += 1;
	}
	public void moveUp(){
		this.yCoord -= 1;
	}
	public void moveDown(){
		this.yCoord += 1;
	}
	public void render(GameContainer container, Graphics arg1) throws SlickException{
		dinoAnimation.draw(this.xCoord, this.yCoord);
		// TODO Auto-generated method stub
		
	}
	
}
