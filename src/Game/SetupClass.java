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


public class SetupClass extends BasicGame {
	public Player player;
	/*
	 * windowWidth = width of the window
	 * windowHeight = height of the window
	 * fullScreen if true makes game fullScreen
	 */
	private static int windowWidth = 1000;
	private static int windowHeight = 700;
	private static boolean fullScreen = false;

	
	public SetupClass(String title) {
		super(title);
		
	}
	@Override
	public void init(GameContainer container) throws SlickException {
		player = new Player(1, 2, (byte) 3);
		player.init(container);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {

		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_S)){
			player.moveDown();
		}
		if (input.isKeyDown(Input.KEY_A)){
			player.moveLeft();
		}
		if (input.isKeyDown(Input.KEY_D)){
			player.moveRight();
		}
		if (input.isKeyDown(Input.KEY_W)){
			player.moveUp();
		}

	}

	public void render(GameContainer container, Graphics arg1) throws SlickException {
		player.render(container, arg1);
	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(windowWidth, windowHeight, fullScreen);
		app.start();
		
	}








}
