package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Timer extends GameObject {

	int time;
	public Timer(){
		super(0,0,(byte)0);
		time = 30000;
	}
	
	public int update(int delta){
		time -= delta;
		return time;
	}
	public void render(Graphics g, int width){
		g.setColor(Color.red);
		g.fillRect(64, 2, width-128, 64);
		if (time > 0){
		g.setColor(Color.green);
		g.fillRect(64, 2, time/35, 64);
		g.setColor(Color.white);
		g.drawString(Integer.toString(time),500,20);}
	}
	
	
}
