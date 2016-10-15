package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Player extends GameObject{
	private static int x = 128;
	private static int y = 64;
	private int facing = 90;
	private static int moveSpeed = 64;
	
	
	
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
		
		System.out.println(isAllowedRight(grid, block));}
	}
	public void moveUp(){
		facing = 0;
		if (this.yCoord > 64){
		this.yCoord -= moveSpeed;}

	}
	public void moveDown(int[][] grid){
		facing = 180;
		if(yCoord < (grid.length)*64){
			this.yCoord += moveSpeed;
		}

	}
	
	public boolean isAllowedLeft(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] == 2){
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
				if (grid[i][j] == 2){
					if ((this.xCoord  == block.xCoord)&& (this.yCoord -64 == block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}/*
	public boolean isAllowedUp(int[][] grid, Block block){
		boolean allowed = true;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j<grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] == 2){
					if ((this.xCoord - 64 >= block.xCoord + 64) && (this.yCoord >= block.yCoord + 64 || this.yCoord + 64 >= block.yCoord)){
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
				if (grid[i][j] == 2){
					if ((this.xCoord + 64 >= block.xCoord || this.xCoord) && (this.yCoord >= block.yCoord + 64 || this.yCoord + 64 >= block.yCoord)){
						allowed = false;
					}
				}
			}
		}
		return allowed;
	}*/
	public void render(GameContainer container, Graphics g) throws SlickException{
		WalkAnimation.getCurrentFrame().setRotation(facing);
		WalkAnimation.draw(this.xCoord, this.yCoord);
		// TODO Auto-generated method stub
		
	}

	
}
