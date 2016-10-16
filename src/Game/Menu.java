package Game;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{
	public int mouseXPos;
	public int mouseYPos;
	public static int id = 0;
	Image banner;
	Image play;
	
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		banner = new Image("src/res/banner.png");
		play = new Image("src/res/playButton.png");
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		//g.setColor(Color.blue);
		//g.fillRect(0, 0, 1920, 1080);
		banner.draw(500, 64);
		//play.draw(64, 3*64);
		g.setColor(Color.green.darker((float)0.3));
		g.fillRect(500, 256, 512, 256);
		g.setColor(Color.white);
		mouseXPos = Mouse.getX();
		mouseYPos = Mouse.getY();
		if(mouseXPos>=500 && mouseXPos <=1012 && mouseYPos <= 682+256 && mouseYPos >= 682){		g.setColor(Color.green.brighter((float)0.3));
		g.fillRect(500, 256, 512+200, 256); 
		g.setColor(Color.white);
		}
		g.drawString("Play", 550, 256);

		
		
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		mouseXPos = Mouse.getX();
		mouseYPos = Mouse.getY();
		System.out.println(mouseYPos);
		Input input = container.getInput(); 
		if(mouseXPos>=64 && mouseXPos <=564 && mouseYPos <= 500 && mouseYPos >= 445 && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
			
			sbg.getState(1).init(container, sbg);
			sbg.enterState(1);
		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
}


