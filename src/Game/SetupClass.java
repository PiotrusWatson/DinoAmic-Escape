package Game;


import java.awt.event.InputEvent;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Sound;
import org.newdawn.slick.Music;

//import com.sun.javafx.geom.Rectangle;

import GameObjects.Player;
import GameObjects.GameObject;
import GameObjects.MeteioriteGround;
import GameObjects.Metiorite;
import GameObjects.Timer;
import endGame.endGame;
import levelGen.MapGrid;
import GameObjects.Block;
import GameObjects.ExitTile;
//import org.newdawn.slick.geom.Rectangle;
import GameObjects.Floor;



public class SetupClass extends BasicGameState {
	
	public static int id = 1;
	public Player player;
	public Player player2;
	
	public Block block;
	public Floor floor;
	public Metiorite met;
	public MeteioriteGround metiorite;
	
	
	public MapGrid map;
	public int[][] grid;
	public static int fps = 1000;
	public boolean reduced = false;
	public ExitTile exit;
	

	public Sound grunt;
	public Sound levelEnd;
	public Sound rockBreak;
	public Sound gameOver;
	public Sound pain;
	public Sound meteorHit;
	public Music run;
	/*
	 * windowWidth = width of the window
	 * windowHeight = height of the window
	 * fullScreen if true makes game fullScreen
	 */
	
	private static boolean fullScreen = false;
	
	
	private Timer timer;
	public static int score = 0;
	private static boolean two_player = false; // set to true for two players
	

	
	public boolean occupiedSlot(int coordX, int coordY)
	{
		if (grid[coordX][coordY] != 0)
			return true;
		else
			return false;
	}
	

	private String String(int time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	
	public static void main(String[] args) throws SlickException {
		//AppGameContainer app = new AppGameContainer((Game) new ScalableGame(new SetupClass("Setup Test"), width, height));
		//app.setDisplayMode(windowWidth, windowHeight, fullScreen);
		//app.start();
		
	}

	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		player = new Player(1, 2);
		player2 = new Player(5, 6);
		player.init(container);
		player2.init(container);
		timer = new Timer();
		met = new Metiorite(MapGrid.level);
		
		block = new Block(1, 2);
		block.init(container);
		floor = new Floor(1, 2);
		floor.init(container);
		map=new MapGrid(((Main.width/64)-1),((Main.height/64)-1));
		map.generateGrid(2);
		grid = map.getGrid();
		exit = new ExitTile(1, 2);
		exit.init(container);
		
		grunt = new Sound("src/res/grunt.ogg");
		levelEnd = new Sound("src/res/levelEnd.ogg");
		rockBreak = new Sound("src/res/meteorstrike.ogg");
		gameOver = new Sound("src/res/gameover.ogg");
		pain = new Sound("src/res/pain.ogg");
		meteorHit = new Sound("src/res/rockbreak.ogg");
		
		run = new Music("src/res/Run!.ogg");

		metiorite = new MeteioriteGround(1, 2);
		metiorite.init(container);
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if (two_player){
		player2.render(container, g);}
		timer.render(g, Main.windowWidth); //window width needed for timer bar
		block.render(container, g);
		
		

		for(int i = 0; i < grid.length;i++){
			for(int j = 0; j < grid[0].length; j++){
				floor.yCoord = (i+1)*64;
				floor.xCoord = (j+1)*64;
				floor.render(container, g);
				
				
				if (grid[i][j] == 2){
					//sets it to place a block
					
					block.yCoord = (i+1)*64;
					block.xCoord = (j+1)*64;
					block.render(container, g);
					
					if((i == met.getY()) && j == met.getX()){
						grid[i][j] = 1;

					}
				}
				
				if(grid[i][j] == 0){
					exit.yCoord = (i+1)*64;
					exit.xCoord = (j+1)*64;
					exit.render(container, g);
				}
				
				if(grid[i][j] == 3){
					metiorite.yCoord = (i+1)*64;
					metiorite.xCoord = (j+1)*64;
					metiorite.render(container, g);
				}
			}
		}
		player.render(container, g);
		met.render(container,g,grid[0].length,grid.length,player.getArrayPosX(),player.getArrayPosY());
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		// win state
				if (!run.playing())
					run.loop();
				if (player.xCoord == exit.xCoord && player.yCoord == exit.yCoord){
					int time = timer.getTime();
					/*String time2 = String(time);
					endGame.finish(time2);*/
					score += time;
					MapGrid.level += 1;
					levelEnd.play();
					//Main.updateSize(40);
					sbg.getState(sbg.getCurrentStateID()).init(container, sbg);
					sbg.enterState(sbg.getCurrentStateID());
				}
				
				
				if(timer.getTime()<= 0){ //loss state
					gameOver.play();
					if (!gameOver.playing()){
					sbg.getState(2).init(container, sbg);
					sbg.enterState(2);}
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
						grunt.play();
						rockBreak.play();
						player.headbutting = true;
					}
				}
				
				timer.update(delta);
				
				if(timer.getTime() == 0 || timer.getTime() < 0){
					
				}
				
				if(met.getTime() > 1000){
					grid[met.getY()][met.getX()] = 3;
					if(met.getY() == player.getArrayPosY() -1 && met.getX() == player.getArrayPosX()-1){
						if(reduced == false){
							timer.reduce(10000);
							pain.play();
							reduced = true;
						}
						
					}
				}
				if(met.getTime()<1000){
					reduced = false;
				}

				met.update(delta);

			}

		
	}
