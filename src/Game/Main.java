package Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame{
	
	
	
	public Main(String name) {
		super(name);
		
	}
	
	public static int windowWidth = 1920;
	public static int windowHeight = 1080;
	
	public static int width = 2000; //determines actual width of game
	public static int height = 1400; //ditto with actual height of game
	
	public static final int MAXWIDTH = 2000;
	public static final int MAXHEIGHT = 1400;
	
	public static ScalableGame sg;
	
	public static void setWidth(int w){
		width = w;
	}
	
	public static void setHeight(int h){
		height = h;
	}
	
	
	public static void updateSize(int updater) throws SlickException
	{
		if (width <= MAXWIDTH && height <= MAXHEIGHT){
			width += updater;
			height +=updater;
			sg.recalculateScale();
		}
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		sg = new ScalableGame((Game) new Main("Default Title"), width, height);
		app = new AppGameContainer(sg);
		app.setDisplayMode(windowWidth, windowHeight, true);//true 
		app.setAlwaysRender(true);
		app.start();

	}
	

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Menu());
		addState(new SetupClass());
		
	}

}
