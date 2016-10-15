package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Metiorite extends GameObject {
	private Image shadow;
	private Image met;
	private int rate;
	private int[] ranArray;
	private boolean isMet;
	private int x;
	private int y;
	private int xIndex;
	private int yIndex;
	private int time = 0;
	
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
	
	public void update(int alpha){
		time += alpha;
	}


	
	public void render(GameContainer container, Graphics g,int noCol, int noRows) throws SlickException{

		met = new Image("src/res/met.png");
		shadow = new Image("src/res/shadow.png");

		
		int random = (int)(Math.random()*100);		
		if(isMet){
			if(time<1000){
				shadow.draw(x,y);
			} else if(time < 2000){
				met.draw(x,y);
			} else {
				isMet = false;
			}

		} else if(random == 0){
			xIndex = (int)(Math.random()*noCol);
			yIndex = (int)(Math.random()* noRows);
			
			x = 64 + (xIndex*64);
			y = 64 + (yIndex*64);
			
			shadow.draw(x,y);
			isMet = true;
			time = 0;
		}


		// TODO Auto-generated method stub
		
	}
	public int getX(){
		return xIndex;
	}
	
	public int getY(){
		return yIndex;
	}

}
