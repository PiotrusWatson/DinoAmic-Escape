package Game;

import java.awt.event.InputEvent;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class SetupClass extends BasicGame {

	private int y;
	private int x;
	public SetupClass(String title) {
		super(title);
		
	}
	

	public void init(GameContainer container) throws SlickException {
	}

	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_S)){
			y += 1;
		}
		if (input.isKeyDown(Input.KEY_A)){
			x -= 1;
		}
		if (input.isKeyDown(Input.KEY_D)){
			x += 1;
		}
		if (input.isKeyDown(Input.KEY_W)){
			y -= 1;
		}

	}

	public void render(GameContainer container, Graphics arg1) throws SlickException {
		Image img = new Image("src/res/testimage.png");
		img.draw(this.x,this.y);
	}
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(1000, 700, false);
		app.start();
		
	}








}
