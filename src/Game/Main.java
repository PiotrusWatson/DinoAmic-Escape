package Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import endGame.GameOver;

public class Main extends StateBasedGame{
	
	
	
	public Main(String name) {
		super(name);
		
	}
	
	public static int windowWidth = 1000;
	public static int windowHeight = 700;
	
	public static int width = 1000; //determines actual width of game
	public static int height = 700; //ditto with actual height of game
	
	public static final int MAXWIDTH = 2000;
	public static final int MAXHEIGHT = 1400;
	
	public static void setWidth(int w){
		width = w;
	}
	
	public static void setHeight(int h){
		height = h;
	}
	
	
	public static void updateSize(int updater)
	{
		if (width <= MAXWIDTH && height <= MAXHEIGHT){
			width += updater;
			height += updater;
		}
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		app = new AppGameContainer(new ScalableGame(new Main("Default Title"), width, height));
		app.setDisplayMode(windowWidth, windowHeight, false);
		app.setAlwaysRender(true);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Menu());
		addState(new SetupClass());
		addState(new GameOver());
		
	}

}
