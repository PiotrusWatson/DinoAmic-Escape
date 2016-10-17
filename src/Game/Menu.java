package Game;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object;
//import java.io.*;

public class Menu extends BasicGameState{
	//Font font;
	public int mouseXPos;
	public int mouseYPos;
	public static int id = 0;
	Image banner;
	Image play2;
	Image dino;
	Image quit;
	Image score;
	//TrueTypeFont ttf;
	int windowWidth = Main.width;
	int windowHeight = Main.height;
	String everything = "";
	//String fileName = "src/res/highScores.txt";
	//String line = null;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		banner = new Image("src/res/banner.png");
		//play = new Image("src/res/playButton.png");
		play2 = new Image("src/res/playbuttonclear.png");
		dino = new Image ("src/res/DDStationary.png");
		quit = new Image ("src/res/quitpic.png");
		score = new Image ("src/res/scorepic.png");
	    String line = "";
		BufferedReader br;
		
		br = null;
		try {
			br = new BufferedReader(new FileReader("src/res/highScores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		    StringBuilder sb = new StringBuilder();
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        try {
					line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    everything = sb.toString();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(everything);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		banner.draw(windowWidth/4, 64);
		//play.draw(64, 3*64);
		g.setColor(Color.green.darker((float)0.3));
		g.fillRect(windowWidth/4, windowHeight/3, 512, 256);//play button
		g.setColor(Color.white);
		mouseXPos = Mouse.getX();
		mouseYPos = Mouse.getY();
		// play button
		if(mouseXPos>=windowWidth/4 && mouseXPos <=(windowWidth/4)+512 && mouseYPos <= windowHeight/3+256 && mouseYPos >= windowHeight/3){
		g.setColor(Color.green.brighter((float)0.3));
		g.fillRect(windowWidth/4, windowHeight/3, 512+200, 256); 
		}
		//ttf.drawString(32.0f, 32.0f, "PLAY", Color.white);
		g.setColor(Color.red.darker((float)0.3));
		g.fillRect(windowWidth/4, (windowHeight/2)+64, 512, 256);//quit button
		mouseXPos = Mouse.getX();
		mouseYPos = Mouse.getY();
		// System.out.println((windowHeight/2) +64);
		if(mouseXPos>=windowWidth/4 && mouseXPos <=(windowWidth/4)+512 && mouseYPos <= (windowHeight/2)+64+-256 && mouseYPos >= (295)){
		g.setColor(Color.red.brighter((float)0.3));
		g.fillRect(windowWidth/4, (windowHeight/2)+64, 512+200, 256); 
		}
		g.setColor(Color.white);
		play2.draw(windowWidth/4, windowHeight/3);
		quit.draw(windowWidth/4, (windowHeight/2)+64);
		dino.draw(windowWidth/2, 64);
		score.draw(windowWidth-600, (windowHeight/4)-250);
		
		g.drawString(everything, windowWidth-512, windowHeight/4);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		mouseXPos = Mouse.getX();
		mouseYPos = Mouse.getY();
		//System.out.println(mouseYPos);
		Input input = container.getInput(); 
		if(mouseXPos>=windowWidth/4 && mouseXPos <=(windowWidth/4)+512 && (mouseYPos <= windowHeight/3+256 && mouseYPos >= windowHeight/3) && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
			
			sbg.getState(1).init(container, sbg);
			sbg.enterState(1);
		}
		if((mouseXPos>=windowWidth/4 && mouseXPos <=(windowWidth/4)+512 && mouseYPos <= (windowHeight/2)+64+-256 )&& mouseYPos >= (295)&& input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ){
		System.exit(0);}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}
	
}


