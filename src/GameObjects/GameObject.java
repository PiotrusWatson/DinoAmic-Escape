package GameObjects;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class GameObject {
	//A base by which all objects in the game can use and modify
	
	public int xCoord;
	public int yCoord;
	public byte layer;
	public static final int SCALE = 64;
	private Rectangle boundingBox = new Rectangle(xCoord, yCoord, xCoord + SCALE, yCoord + SCALE);
	
	public Rectangle getBoundingBox()
	{
		return this.boundingBox;
	}
	
	public boolean intersects(GameObject obj)
	{
		if (obj.getBoundingBox() == null)
		{
			return false;
		}
		return this.getBoundingBox().intersects(obj.getBoundingBox());
	}
	
	
	public int getXCoord(){
		return xCoord;
	}
	public int getYCoord(){
		return yCoord;
	}
	
	public byte getLayer(){
		return layer;
	}
	
	public void setXCoord(int xCoord){
		this.xCoord = xCoord;
	}
	
	public void setYCoord(int yCoord){
		this.yCoord = yCoord;
	}
	
	public void setLayer(byte layer){
		this.layer = layer;
	}
	
	public GameObject(int xCoord, int yCoord, byte layer)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.layer = layer;
	}

}
