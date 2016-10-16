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
		super(0,0);
		time = 40000;
	}
	
	public void update(int delta){
		time -= delta;
	}
	
	public int getTime(){
		return time;
	}
	public void render(Graphics g, int width){
		g.setColor(Color.red);
		g.fillRect(64, 2, width-128, 64);
		if (time > 0){
		g.setColor(Color.green);
		g.fillRect(64, 2, time/35, 64);
		g.setColor(Color.white);
		g.drawString(Integer.toString(time/1000),500,20);}
	}
	public void reduce(int value){
		time -= value;
	}
	
}
