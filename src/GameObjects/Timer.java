package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Timer extends GameObject {

	int time;
	public Timer(){
		super(0,0,(byte)0);
		time = 10000;
	}
	
	public void update(int delta){
		time -= delta;
	}
	
	public int getTime(){
		return time;
	}
	public void render(Graphics g){
		g.drawString(Integer.toString(time),0,0);
	}
	
	
}
