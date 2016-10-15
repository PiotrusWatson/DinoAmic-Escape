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

import GameObjects.Player;
import GameObjects.GameObject;
import GameObjects.Timer;


public class SetupClass extends BasicGame {
	public Player player;
	public Player player2;
	/*
	 * windowWidth = width of the window
	 * windowHeight = height of the window
	 * fullScreen if true makes game fullScreen
	 */
	private static int windowWidth = 1000;
	private static int windowHeight = 700;
	private static boolean fullScreen = false; // set to true for two players


	private Timer timer;
	private int time;

	private static boolean two_player = false;
	
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
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {

		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_S)){
			player.moveDown();
		}
		else if (input.isKeyDown(Input.KEY_A)){
			player.moveLeft();
		}
		else if (input.isKeyDown(Input.KEY_D)){
			player.moveRight();
		}
		else if (input.isKeyDown(Input.KEY_W)){
			player.moveUp();
		}
		
		if (input.isKeyDown(Input.KEY_RIGHT)){
			player2.moveRight();
		}
		else if (input.isKeyDown(Input.KEY_LEFT)){
			player2.moveLeft();
		}
		else if (input.isKeyDown(Input.KEY_UP)){
			player2.moveUp();
		}
		else if (input.isKeyDown(Input.KEY_DOWN)){
			player2.moveDown();
		}
		time = timer.update(delta);

	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		player.render(container, g);
		if (two_player){
		player2.render(container, g);}
		g.drawString(Integer.toString(time),0,0);


	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(windowWidth, windowHeight, fullScreen);
		app.start();
		
	}








}
