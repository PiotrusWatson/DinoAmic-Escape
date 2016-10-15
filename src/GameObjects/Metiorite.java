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
	private boolean isMet;
	private int x;
	private int y;
	
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


	
	public void render(GameContainer container, Graphics g,int noCol, int noRows) throws SlickException{

		//System.out.println(noCol + " " + noRows);
		img = new Image("src/res/met.png");
		
		if(isMet){
			img.draw(x,y);	
		}
		
		int random = (int)(Math.random()*100);
		if(random == 0){
			x = 64 + ((int)(Math.random()*noCol)*64);
			y = 64 + ((int)(Math.random()* noRows)*64);
			//System.out.println(x + " " + y);
			img.draw(x,y);
			isMet = true;
		} else if(isMet){
			img.draw(x,y);	
		}


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
