package endGame;
import org.lwjgl.input.Mouse;
//import java.awt.Font;
//import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState{
	//private static org.newdawn.slick.Font font = new org.newdawn.slick.Font("serif", Font.BOLD,14);
	public int mouseXPos;
	public int mouseYPos;
	public static int id = 2;
	Image banner;
	TextField play;
	
	
	@Override
	public void init(GameContainer container, StateBasedGame arg1) throws SlickException {
		banner = new Image("src/res/banner.png");
		//play = new TextField(container, font , 64, 3*64, 64, 500);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		banner.draw(64, 64);
		play.render(container, g);
		
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
}


