package Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{
	
	
	
	public Main(String name) {
		super(name);
		
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		app = new AppGameContainer(new Main("Default Title"));
		app.setDisplayMode(1000, 700, false);
		app.setAlwaysRender(true);
		app.start();

	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Menu());
		addState(new SetupClass());
		
	}

}
