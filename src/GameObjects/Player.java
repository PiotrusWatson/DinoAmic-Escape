package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import GameObjects.Timer;

public class Player extends GameObject{
	private static int x = 64;
	private static int y = 64*6;
	private int facing = 90;
	private static int moveSpeed = 64;
	public boolean headbutting = false; // used to decide weather to use headbutt animation or not

	private SpriteSheet WalkSprite;
	private Animation WalkAnimation;
	private SpriteSheet HeadbuttSprite;
	private Animation HeadbuttAnimation;
	
	public Player(int xCoord, int yCoord) throws SlickException {
		super(x, y);

		
		// TODO Auto-generated constructor stub
	}
	
	/*public int getArrayPosX(){
		return ((this.xCoord / SCALE) );
	}
	
	
	public int getArrayPosY(){
		return (this.yCoord / SCALE);
	}*/
	
	public void init(GameContainer container) throws SlickException{
		WalkSprite = new SpriteSheet("src/res/DINODEANWeaponPNG.png", SCALE, SCALE);
		WalkAnimation = new Animation(WalkSprite, 100);
		HeadbuttSprite = new SpriteSheet("src/res/DDGlasgow123.png", 64, 64);
		HeadbuttAnimation = new Animation(HeadbuttSprite, 50); //change from 100 if cycles too fast
		
	}
	public void update(){
		
	}
	
	public void moveLeft(int[][]grid, Block block){
		facing = 270;
		
		if( xCoord > 64){
			if(isAllowedLeft(grid, block)){
				this.xCoord -= moveSpeed;
			}
		}
	}
	public void moveRight(int[][] grid, Block block){
		facing = 90;
		if(xCoord < (grid[0].length)*64){
			if (isAllowedRight(grid, block)){
				this.xCoord += moveSpeed;}
		
		}
	}
	public void moveUp(int[][]grid, Block block){
		facing = 0;
		if (this.yCoord > 64){
			if(isAllowedUp(grid, block))
				this.yCoord -= moveSpeed;}

	}
	public void moveDown(int[][] grid, Block block){
		facing = 180;
		if(yCoord < (grid.length)*64){
			if(isAllowedDown(grid, block)){
				this.yCoord += moveSpeed;
			}
		}

	}
	public boolean headButt(int[][] grid, Block block){
		boolean valid = false;
		if (this.facing == 0){
			if (!isAllowedUp(grid, block)){
				int j = this.getArrayPosX();
				int i = this.getArrayPosY();
				grid[i-2][j-1] = 1;
				valid = true;
			}
		}
		else if (this.facing == 90){
			if (!isAllowedRight(grid, block)){
				int j = this.getArrayPosX() ;
				int i = this.getArrayPosY();
				grid[i-1][j] = 1;
				valid = true;
			}
		}
		else if (this.facing == 180){
			if (!isAllowedDown(grid, block)){
				int j = this.getArrayPosX();
				int i = this.getArrayPosY();
				grid[i][j-1] = 1;
				valid = true;
			}
		}
		else if (this.facing == 270){
			if (!isAllowedLeft(grid, block)){
				int j = this.getArrayPosX() ;
				int i = this.getArrayPosY();
				grid[i-1][j-2] = 1;
				valid = true;
			}
		}
		return valid;
		
	}
	
	public void tennisHit(int[][] grid, Block block){
		if (this.facing == 0){
			if (!isAllowedUp(grid, block)){
				int j = this.getArrayPosX();
				int i = this.getArrayPosY();
				grid[i-2][j-1] =
						1;

			}
		}



		
	}
	
	public boolean isAllowedLeft(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] >= 2){
					if ((this.xCoord -64 == block.xCoord)&& (this.yCoord  == block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}
	public boolean isAllowedRight(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i)*64;
				block.xCoord = (j)*64;
				if (grid[i][j] >= 2){
					if ((this.xCoord  == block.xCoord)&& (this.yCoord -64 == block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}
	
	public boolean isAllowedUp(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] >= 2){
					if ((this.xCoord  == block.xCoord)&& (this.yCoord -64 == block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}
	
	public boolean isAllowedDown(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] >= 2){
					if ((this.xCoord   == block.xCoord)&& (this.yCoord +64 == block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}
	public void render(GameContainer container, Graphics g) throws SlickException{
		if (!headbutting){
		WalkAnimation.getCurrentFrame().setRotation(facing);
		WalkAnimation.draw(this.xCoord, this.yCoord);}
		else{
			HeadbuttAnimation.getCurrentFrame().setRotation(facing);
			HeadbuttAnimation.draw(this.xCoord, this.yCoord);
			
			
		}
		// TODO Auto-generated method stub
		
	}
	public void takeDamage(){
		//add animation for taking damage here
	}
	
}
