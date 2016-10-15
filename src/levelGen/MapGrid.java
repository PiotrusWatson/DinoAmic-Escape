package levelGen;

import java.util.Random;

public class MapGrid {
	
	//Stores a grid of numbers where each number represents a game object
	int[][] grid;
	
	public MapGrid(int length, int height){
		grid = new int[height][length];
	}
	
	
	//Generates a grid
	public void generateGrid(int numberOfBlocks){
		
		//Stores if an important object has been placed
		boolean playerPlaced = false;
		boolean exitPlaced = false;
		
		//Used to later generate random numbers
		Random rand = new Random();
		int randNumber;
		
		//loops for every element of the grid and sets it a value
		//1 represents the player and 0 represents the exit
		for (int i = 0; i< grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
					
				randNumber = rand.nextInt(numberOfBlocks) + 2;
				grid[i][j]=randNumber;
				
				//Makes sure that the player and exit is placed
				if (j==0 && i==((grid.length)-1) && playerPlaced==false){
					grid[i][j] = 1;
					playerPlaced= true;	
				}
				else if(j == 0 && playerPlaced == false){
					randNumber = rand.nextInt(2) + 0;
					if(randNumber == 1){
						grid[i][j] = 1;
						playerPlaced= true;
					}
				}
				
				if (j==((grid[i].length)-1) && i==((grid.length)-1) && exitPlaced == false){
						grid[i][j] = 0;
						exitPlaced = true;
				}
				else if (j==((grid[i].length)-1) && exitPlaced == false){
					randNumber = rand.nextInt(2) + 0;
					if(randNumber == 1){
						grid[i][j] = 0;
						exitPlaced= true;
					}
				}
				
					
				
				
				
				
			}
		}
	
	}
		

	public String toString() {
		String array = "";
		for(int i = 0; i<=((grid.length)-1); i++){
			for(int j = 0; j<=((grid[i].length)-1); j++){
				array += "" + grid[i][j];
			}
		}
		return "Grid height: " + grid.length + " Grid Length: " + grid[0].length + " array: " + array;
	}
	
	public static void main(String[] args){
		MapGrid map = new MapGrid(4,4);
		map.generateGrid(4);
		System.out.println(map);
	}
}
