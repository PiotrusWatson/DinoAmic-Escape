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
import levelGen.MapGrid;
import GameObjects.Block;
//import org.newdawn.slick.geom.Rectangle;



public class SetupClass extends BasicGame {
	public Player player;
	public Block block;
	public Player player2;
	public Metiorite met;
	public MapGrid map;
	public int[][] grid;
	public static int fps = 1000;
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
		
		
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		
		
		if(timer.getTime()<= 0){
			System.exit(0);
		}

		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_S)){
			player.moveDown(grid,block);
		}
		else if (input.isKeyPressed(Input.KEY_A)){
			player.moveLeft(grid,block);
			
		}
		else if (input.isKeyPressed(Input.KEY_D)){
			
			player.moveRight(grid, block);
			
		}
		else if (input.isKeyPressed(Input.KEY_W)){
			player.moveUp(grid, block);
			
		}

		timer.update(delta);
		
		if(timer.getTime() == 0 || timer.getTime() < 0){
			
		}

		met.update(delta);

	}

	public void render(GameContainer container, Graphics g) throws SlickException {


		if (two_player){
		player2.render(container, g);}
		timer.render(g, windowWidth); //window width needed for timer bar
		block.render(container, g,false);
		
		//for(int row=0;row<(int)(WindowHeight/64);row++){
			//for(int col=0;col<(int)(wind))
		//}
		



		
		boolean isRock = false;
		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				block.yCoord = (i+1)*64;
				block.xCoord = (j+1)*64;
				if (grid[i][j] == 2){
					isRock = true;
					//System.out.println(met.getX());
					//System.out.println(i + " " + met.getX() + " " + j + " " + met.getY());
					if((i == met.getY()) && j == met.getX()){
						grid[i][j] = 0;
						isRock = false;
						//System.out.println("_-----------------------------------------------------------------------------------");
					}
				}
				block.render(container, g,isRock);
				isRock = false;
			}
		}
		player.render(container, g);
		met.render(container,g,grid[0].length,grid.length);


	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(windowWidth, windowHeight, fullScreen);
		app.start();
		
	}
}