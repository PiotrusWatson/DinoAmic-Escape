package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Player extends GameObject{
	private static int x = 64;
	private static int y = 64;
	private int facing = 90;
	private static int moveSpeed = 1;
	
	
	
	private SpriteSheet WalkSprite;
	private Animation WalkAnimation;
	
	public Player(int xCoord, int yCoord, byte layer) throws SlickException {
		super(x, y, layer);

		
		// TODO Auto-generated constructor stub
	}
	
	public int getArrayPosX(){
		return this.xCoord / SCALE;
	}
	
	
	public int getArrayPosY(){
		return this.yCoord / SCALE;
	}
	
	public void init(GameContainer container) throws SlickException{
		WalkSprite = new SpriteSheet("src/res/DINODEANWeaponPNG.png", 64, 64);
		WalkAnimation = new Animation(WalkSprite, 100);
		
	}
	public void update(){
		
	}
	
	public void moveLeft(){
		facing = 270;
		this.xCoord -= moveSpeed;
		if( xCoord <= 64){
			this.xCoord += moveSpeed;
		}
	}
	public void moveRight(int[][] grid){
		facing = 90;
			this.xCoord += moveSpeed;
			if(xCoord >= (grid[0].length)*64){
				this.xCoord -= moveSpeed;
			}
		

	}
	public void moveUp(){
		facing = 0;
		this.yCoord -= moveSpeed;
		if( yCoord <= 64){
			this.yCoord += moveSpeed;
		}
	}
	public void moveDown(int[][] grid){
		facing = 180;
		this.yCoord += moveSpeed;
		if(yCoord >= (grid.length)*64){
			this.yCoord -= moveSpeed;
		}

	}
	public void render(GameContainer container, Graphics g) throws SlickException{
		WalkAnimation.getCurrentFrame().setRotation(facing);
		WalkAnimation.draw(this.xCoord, this.yCoord);
		// TODO Auto-generated method stub
		
	}
	
}
