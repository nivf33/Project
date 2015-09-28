package algorithms.mazeGenerators;

public class Maze3d {

	// Data Members
	private sizeOfMaze size;
	private int [] [] [] Array;
	private Position entrance;
	private Position exit;

	public Maze3d(sizeOfMaze size) {
		this.size=new sizeOfMaze(size.getX(), size.getY(), size.getZ());
		Array = new int[size.getX()][size.getY()][size.getZ()]; 
	}

	public sizeOfMaze getSize() {
		return size;
	}

	public void setSize(sizeOfMaze size) {
		this.size.setX(size.getX());
		this.size.setY(size.getY());
		this.size.setZ(size.getZ());
	}
	
	public int[][][] getArray() {
		return Array;
	}
	
	public void setArray(Position pos, int num) {
		Array[pos.getX()][pos.getY()][pos.getZ()] = num;
	}
	
	public void setArray(int x, int y, int z, int num) {
		Array[x][y][z] = num;
	}
	
	public Position getStartPosition() {
		return entrance;
	}

	public void setEntrance(Position entrance) {
		this.entrance = entrance;
		Array[entrance.getX()][entrance.getY()][entrance.getZ()] = 0;
	}

	public Position getGoalPosition() {
		return exit;
	}

	public void setExit(Position exit) {
		this.exit = exit;
		Array[exit.getX()][exit.getY()][exit.getZ()] = 0;
	}
	
	public int getCellValue(Position pos)
	{
		return Array[pos.getX()][pos.getY()][pos.getZ()]; 
	}
	
	public int getCellValue(int x, int y, int z)
	{
		return Array[x][y][z]; 
	}
	
	
	// Check if a position is in the maze range
	public boolean isCellValid(int x, int y, int z)
	{
		if((x < 0) || (y < 0) || (z < 0))
		{
			return false;
		}
		else
		{
			if((x > (size.getX()-1)) || (y > (size.getY()-1)) || (z > (size.getZ()-1)))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public int[][] getCrossSectionByX(int x){
		
		int y,z;
		int [][] CrossSection = new int[size.getY()][size.getZ()];
	
		for(y = 0; y < size.getY(); y++){
			for(z = 0; z < size.getZ(); z++){
				CrossSection [y][z] = Array[x][y][z];
			}
		}
		return CrossSection;
}
	public int[][] getCrossSectionByY(int y){
		
		int x,z;
		int [][] CrossSection = new int[size.getX()][size.getZ()];
		
		for(x = 0; x < size.getX(); x++){
			for(z = 0; z < size.getZ(); z++){
				CrossSection [x][z] = Array[x][y][z];
			}
		}
		return CrossSection;
	}
	public int[][] getCrossSectionByZ(int z){
		
		int x,y;
		int [][] CrossSection = new int[size.getX()][size.getY()];
		
		for(x = 0; x < size.getX(); x++){
			for(y = 0; y < size.getY(); y++){
				CrossSection [x][y] = Array[x][y][z];
			}
		}
		return CrossSection;
	}
	
	public void printMaze()
	{
		for(int i = 0; i < size.getX(); i++)
		{
			for(int j = 0; j < size.getY(); j++)
			{
				for(int k = 0; k < size.getZ(); k++){
				
					System.out.print((getArray())[i][j][k]);
					System.out.print(",");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Entrance");
		System.out.println(getStartPosition().getX());
		System.out.println(getStartPosition().getY());
		System.out.println(getStartPosition().getZ());
		System.out.println();
		System.out.println("Exit");
		System.out.println(getGoalPosition().getX());
		System.out.println(getGoalPosition().getY());
		System.out.println(getGoalPosition().getZ());
	}
}
