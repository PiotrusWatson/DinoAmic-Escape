package GameObjects;

public class Timer extends GameObject {
	
	int time;
	public Timer(){
		super(0,0,(byte)0);
		time = 10000;
	}
	
	public int update(int delta){
		time -= delta;
		return time;
	}
	
	
}
