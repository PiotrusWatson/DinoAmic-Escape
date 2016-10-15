package levelGen;

import java.util.Random;

public class MapGrid {
	/*
	 * 0 = Exit
	 * 1 = Empty
	 * 2 = Block .. and so on
	 */
	//Stores a grid of numbers where each number represents a game object
	int[][] grid;
	
	public MapGrid(int length, int height){
		grid = new int[height][length];
	}
	
	
	//Generates a grid
	public void generateGrid(int numberOfBlocks){
		
		int rows = ((grid.length)-1);
		int cols = ((grid[0].length)-1);
		
		//Used to later generate random numbers
		Random rand = new Random();
		int randNumber;
		
		//loops for every element of the grid and sets it a value
		//1 represents the player and 0 represents the exit
		for (int i = 0; i< grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){	
				randNumber = rand.nextInt(numberOfBlocks) + 1;
				grid[i][j]=randNumber;
					
			}
		}
		
		randNumber = rand.nextInt(rows);
		grid[randNumber][0]= 1;
		
		randNumber = rand.nextInt(rows);
		grid[randNumber][cols]= 0 ;
		
		
		
	
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


	public int[][] getGrid() {
		return grid;
	}
}
