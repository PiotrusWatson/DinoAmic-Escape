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
		
		//Stores if which border a player and exit is placed in;
		int playerPlaced = -1;
		int exitPlaced = -1;
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
				
				//Makes sure that the player and exit is placed
				if (j==0 && i==((grid.length)-1) && playerPlaced==-1){
					grid[i][j] = 1;
					playerPlaced= 0;
					System.out.println("case1");
				}
				else if(((j == 0 && exitPlaced != 0)|| (j==cols && exitPlaced!=2) || (i==0 && exitPlaced !=1) || ((i == rows && exitPlaced != 3)) && playerPlaced == -1)){
					randNumber = rand.nextInt(2) + 0;
					System.out.println("case2");
					if(randNumber == 1){
						grid[i][j] = 1;
						
						if(i==0){
							playerPlaced= 1;
						}
						else if(i== rows){
							playerPlaced = 3;
						}
						else if(j==0){		
							playerPlaced = 0;
						}
						else{
							playerPlaced = 2;
						}
						
					}
				}
				
				if (j==((grid[i].length)-1) && i==((grid.length)-1) && exitPlaced == -1){
					
						grid[i][j] = 0;
						exitPlaced = 2;
						System.out.println("case3");
				}
				else if(((j == 0 && playerPlaced != 0)|| (j==cols && playerPlaced!=2) || (i==0 && playerPlaced !=1) || ((i == rows && playerPlaced != 3))&& exitPlaced == -1)){
					System.out.println("case4");
					randNumber = rand.nextInt(2) + 0;
					if(randNumber == 1){
						grid[i][j] = 0;
						
						if(i==0){
							exitPlaced= 1;
						}
						else if(i== rows){
							exitPlaced = 3;
						}
						else if(j==0){		
							exitPlaced = 0;
						}
						else{
							exitPlaced = 2;
						}
						
					}
				}
				
					
				
				
				
				
			}
		}
	
	}
		

	//public String toString() {
		//String array = "";
		//for(int i = 0; i<=((grid.length)-1); i++){
			//for(int j = 0; j<=((grid[i].length)-1); j++){
				//array += "" + grid[i][j];
			//}
		//}
		//return "Grid height: " + grid.length + " Grid Length: " + grid[0].length + " array: " + array;
	//}
	
	public static void main(String[] args){
		MapGrid map = new MapGrid(4,4);
		map.generateGrid(4);
		System.out.println(map);
	}


	public int[][] getGrid() {
		return grid;
	}
}
