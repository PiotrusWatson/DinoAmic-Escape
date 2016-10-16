package GameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

import levelGen.MapGrid;
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
		super(0, 0);
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


	
	public void render(GameContainer container, Graphics g,int noCol, int noRows, int playerX, int playerY) throws SlickException{


		shadow = new Image("src/res/shadow.png");

		
		int random = (int)(Math.random()*1000);		
			if(time<1000){
				shadow.draw(x,y);
			} 

		if(random == 0){
			int random2 = (int)(Math.random() *3);
			if(random2 ==0){
				xIndex = playerX-1;
				yIndex = playerY-1;			
			} else {
				xIndex = (int)(Math.random()*noCol);
				yIndex = (int)(Math.random()* noRows);
			}
			
			x = 64 + (xIndex*64);
			y = 64 + (yIndex*64);
			
			time = 0;
		}


		// TODO Auto-generated method stub
		
	}
	public int getX(){
		return xIndex;}
	
	public int getY(){
		return yIndex;
	}
	public int getTime(){
		return time;
	}

}
