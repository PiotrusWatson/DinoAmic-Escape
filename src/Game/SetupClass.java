package Game;


import java.awt.event.InputEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.sun.javafx.geom.Rectangle;

import GameObjects.Player;
import GameObjects.GameObject;
import GameObjects.Metiorite;
import GameObjects.Timer;
import endGame.endGame;
import levelGen.MapGrid;
import GameObjects.Block;
import GameObjects.ExitTile;
//import org.newdawn.slick.geom.Rectangle;



public class SetupClass extends BasicGame {
	public Player player;
	public Block block;
	public Player player2;
	public Metiorite met;
	public MapGrid map;
	public int[][] grid;
	public static int fps = 1000;
	public boolean reduced = false;
	public ExitTile exit;
	/*
	 * windowWidth = width of the window
	 * windowHeight = height of the window
	 * fullScreen if true makes game fullScreen
	 */

	private static int windowWidth = 1000;
	private static int windowHeight = 700;
	private static boolean fullScreen = false;


	private Timer timer;
	private static boolean two_player = false; // set to true for two players

	
	public SetupClass(String title) {
		super(title);
		
	}
	
	public boolean occupiedSlot(int coordX, int coordY)
	{
		if (grid[coordX][coordY] != 0)
			return true;
		else
			return false;
	}
	@Override
	public void init(GameContainer container) throws SlickException {

		player = new Player(1, 2, (byte) 3);
		player2 = new Player(5, 6, (byte)3);
		player.init(container);
		player2.init(container);
		timer = new Timer();
		met = new Metiorite(0);
		block = new Block(1, 2, (byte)3);
		block.init(container);
		map=new MapGrid(((windowWidth/64)-1),((windowHeight/64)-1));
		map.generateGrid(2);
		grid = map.getGrid();
		exit = new ExitTile(1, 2, (byte)3);
		exit.init(container);
		
		
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// win state
		if (player.xCoord == exit.xCoord && player.yCoord == exit.yCoord){
			int time = timer.getTime();
			String time2 = String(time);
			endGame.finish(time2);
			
			
		}
		
		
		if(timer.getTime()<= 0){
			System.exit(0);
		}

		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_S)){
			player.moveDown(grid, block);
			player.headbutting = false;

		}
		else if (input.isKeyPressed(Input.KEY_A)){
			player.moveLeft(grid,block);
			player.headbutting = false;

			
		}
		else if (input.isKeyPressed(Input.KEY_D)){
			
			player.moveRight(grid, block);
			player.headbutting = false;

			
		}
		else if (input.isKeyPressed(Input.KEY_W)){
			player.moveUp(grid, block);
			player.headbutting = false;
			
		}

		else if (input.isKeyPressed(Input.KEY_SPACE)){
			boolean valid =player.headButt(grid, block);
			if(valid){
				timer.reduce(2000);
				player.headbutting = true;
			}
		}
		
		timer.update(delta);
		
		if(timer.getTime() == 0 || timer.getTime() < 0){
			
		}
		
		if(met.getTime() > 1000){
			grid[met.getY()][met.getX()] = 1;
			if(met.getY() == player.getArrayPosY() -1 && met.getX() == player.getArrayPosX()-1){
				if(reduced == false){
					timer.reduce(10000);	
					reduced = true;
				}
				
			}
		}
		if(met.getTime()<1000){
			reduced = false;
		}

		met.update(delta);

	}

	private String String(int time) {
		// TODO Auto-generated method stub
		return null;
	}
	public void render(GameContainer container, Graphics g) throws SlickException {


		if (two_player){
		player2.render(container, g);}
		timer.render(g, windowWidth); //window width needed for timer bar
		block.render(container, g,false);
		
		



		
		boolean isRock = false;
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] == 2){
					isRock = true;
					if((i == met.getY()) && j == met.getX()){
						grid[i][j] = 1;
						isRock = false;

					}
				}
				block.render(container, g,isRock);
				isRock = false;
				if(grid[i][j] == 0){
					exit.yCoord = (i+1)*64;
					exit.xCoord = (j+1)*64;
					exit.render(container, g);
				}
			}
		}
		player.render(container, g);
		met.render(container,g,grid[0].length,grid.length,player.getArrayPosX(),player.getArrayPosY());


	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(windowWidth, windowHeight, fullScreen);
		app.start();
		
	}
}