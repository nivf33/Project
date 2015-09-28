package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MyMaze3dGenerator extends Abstract_Generator {

	// Data Members
	private Maze3d maze;
	private Stack<Position> st;
	
	// Constructor
	public MyMaze3dGenerator() {
		st = new Stack<Position>();
	}
	
	public Maze3d getMaze() {
		return maze;
	}
	
	// Generate the Maze
	public Maze3d generate(sizeOfMaze size) {
		
		int max = 1;
		maze = new Maze3d(size);
		
		Initialization(size);
		
		st.push(maze.getStartPosition());
		maze.setExit(maze.getStartPosition());
		buildTrack(maze.getStartPosition(), max);
		
		return maze;
	}
	
	// Build the track 
	public Position buildTrack(Position curr, int max)
	{
		// Check if the stack is empty
		if(st.empty() != true)
		{
			// Get a random cell which is unvisited
			Position tmp = getRandomCell(curr);
			
			// Check if the current cell has any unvisited cells
			if(tmp != null)
			{
				maze.setArray(tmp, 0);
				st.push(tmp);
				if(st.size() > max)
				{
					max = st.size();
					maze.setExit(tmp);
				}
				
				return(buildTrack(tmp,max));
			}
			else
			{
				curr = st.pop();
				return (buildTrack(curr, max));
			}
		}
		else
		{
			return curr;
		}
	}
	
	// Calculate all the possible movements and return a random move to do
	public Position getRandomCell(Position pos)
	{
		Position result;
		ArrayList <Position> Options = new ArrayList<Position>();
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		
		// Check Down
		if(maze.isCellValid(x-1, y, z))
		{
			if((maze.getCellValue(x-1, y, z) == 1) && (isAreaValid(x-1, y, z) == 1))
			{
				Options.add(new Position(x-1, y, z));
			}		
		}
		
		// Check Up
		if(maze.isCellValid(x+1, y, z))
		{
			if((maze.getCellValue(x+1, y, z) == 1) && (isAreaValid(x+1, y, z) ==1))
			{
				Options.add(new Position(x+1, y, z));
			}		
		}
		
		// Check Right
		if(maze.isCellValid(x, y, z+1))
		{
			if((maze.getCellValue(x, y, z+1) == 1) && (isAreaValid(x, y, z+1)==1))
			{
				Options.add(new Position(x, y, z+1));
			}		
		}
		
		// Check Left
		if(maze.isCellValid(x, y, z-1))
		{
			if((maze.getCellValue(x, y, z-1) == 1) && (isAreaValid(x, y, z-1)==1))
			{
				Options.add(new Position(x, y, z-1));
			}		
		}
		
		// Check Forward
		if(maze.isCellValid(x, y-1, z))
		{
			if((maze.getCellValue(x, y-1, z) == 1) && (isAreaValid(x, y-1, z)==1))
			{
				Options.add(new Position(x, y-1, z));
			}		
		}
		
		// Check Backwards
		if(maze.isCellValid(x, y+1, z))
		{
			if((maze.getCellValue(x, y+1, z) == 1) && (isAreaValid(x, y+1, z)==1))
			{
				Options.add(new Position(x, y+1, z));
			}		
		}
	
		// Check if there is any possible move to return
		if(Options.size() == 0)
		{
			result = null;
		}
		else
		{
			result = Options.get(new Random().nextInt(Options.size()));
		}
		
		return result;
	}
	
	// Return how much zeroed cells are near a position
	public int isAreaValid(int x, int y, int z)
	{
		int counter = 0;
		
		// Check Down
		if(x-1 >= 0)
			if(maze.getCellValue(x-1, y, z) == 0)
				counter ++;
			
		// Check Up
		if(x+1 < maze.getSize().getX())
			if(maze.getCellValue(x+1, y, z) == 0)
				counter ++;
		
		// Check Left
		if(z-1 >= 0)
			if(maze.getCellValue(x, y, z-1) == 0)
				counter ++;
		
		// Check Right
		if(z+1 < maze.getSize().getZ())
			if(maze.getCellValue(x, y, z+1) == 0)
				counter ++;
		
		// Check Forward
		if(y-1 >= 0)
			if(maze.getCellValue(x, y-1, z) == 0)
				counter ++;
		
		// Check Backwards
		if(y+1 < maze.getSize().getY())
			if(maze.getCellValue(x, y+1, z) == 0)
				counter ++;
		
			return counter;
	}

	
	//Initialize the maze with walls
	public void Initialization(sizeOfMaze size)
	{
		Random num;
		int x, y, z;
		Position curr;
		
		// FIll all the maze with walls
		for(int i = 0; i < maze.getSize().getX(); i++)
		{
			for(int j = 0; j < maze.getSize().getY(); j++)
			{
				for(int k = 0; k < maze.getSize().getZ(); k++)
				{
					maze.setArray(i,j,k,1);
				}
			}
		}
		
		// Initialize Entrance
		num = new Random();
		x = num.nextInt(size.getX());
		y = num.nextInt(size.getY());
		z = num.nextInt(size.getZ());
		curr = new Position(x,y,z);
		maze.setEntrance(curr);
	}
}