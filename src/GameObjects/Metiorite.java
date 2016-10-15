package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;
import org.newdawn.slick.Image;

public class Metiorite extends GameObject {
	Image img;
	int rate;
	int[] ranArray;
	
	public void init(GameContainer container) throws SlickException{
		img = new Image("src/res/floor.png");
	}

	public Metiorite(int difficulty) {
		super(0, 0, (byte)0);
		rate = difficulty + 10;
		ranArray = new int[rate];
		for(int i=0;i<rate;i++){
			ranArray[i] = (int)(Math.random() * 100);
		}
		// TODO Auto-generated constructor stub
	}
	
	public void render(Graphics g,int time){
		for(int i=0;i<rate;i++){
			if(time > (ranArray[i] * 10) && time < ((ranArray[i] * 10) - 10)){
				img.draw(time,time);
			}
		}

	}

}
