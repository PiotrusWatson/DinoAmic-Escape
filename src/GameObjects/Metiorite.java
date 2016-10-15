package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Metiorite extends GameObject {
	private Image img;
	private int rate;
	private int[] ranArray;
	
	public Metiorite(int difficulty) throws SlickException  {
		super(0, 0, (byte)0);
		rate = difficulty + 10;
		ranArray = new int[rate];
		for(int i=0;i<rate;i++){
			ranArray[i] = (int)(Math.random() * 1000);
		}
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException{
		
	}
	
	public void update(){
		
	}


	
	public void render(GameContainer container, Graphics g, int time) throws SlickException{
			img.draw(50 ,50);



		// TODO Auto-generated method stub
		
	}
	//public void render(Graphics g,int time){

		/*
		for(int i=0;i<rate;i++){
			System.out.println(time + " " + ranArray[i]);
			if(time > (ranArray[i] * 10) && time < ((ranArray[i] * 10) + 100)){
				img.draw(50,50);
			}
		}
		*/

	//}

}
