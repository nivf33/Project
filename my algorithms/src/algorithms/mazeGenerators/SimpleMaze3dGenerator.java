package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMaze3dGenerator extends Abstract_Generator{

		// Data Members
		private Random num;;
		private Maze3d maze;
		private Position pos;
		
		public SimpleMaze3dGenerator() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Maze3d generate(sizeOfMaze size)
		{
			num = new Random();
			maze = new Maze3d(size);
			
			// Initialize all the maze walls
			for(int i = 0; i < size.getX(); i++)
			{
				for(int j = 0; j < size.getY(); j++)
				{
					for(int k = 0; k < size.getZ(); k++)
					{
						pos = new Position(i,j,k);
						maze.setArray(pos, 1);
					}
				}
			}
			
			int x,y,z;
			
			// Initialize Entrance
			x = num.nextInt(size.getX());
			y = num.nextInt(size.getY());
			z = num.nextInt(size.getZ());
			pos = new Position(x,y,z);
			maze.setEntrance(pos);
			num=new Random();
			
			// Initialize Exit
			x = num.nextInt(size.getX()) ;
			y = num.nextInt(size.getY());
			z = num.nextInt(size.getZ());
			pos = new Position(x,y,z);
			maze.setExit(pos);
			
			trackBuild(maze);
			
			return maze;
		}
		
		// Build a track for random entrance and exit
		public void trackBuild(Maze3d maze)
		{
			Position currPos =new Position(maze.getStartPosition().getX(),maze.getStartPosition().getY(),maze.getStartPosition().getZ());
			int exitX = maze.getGoalPosition().getX();
			int exitY = maze.getGoalPosition().getY();
			int exitZ = maze.getGoalPosition().getZ();
			int diffX = maze.getStartPosition().getX() - maze.getGoalPosition().getX();
			int diffY = maze.getStartPosition().getY() - maze.getGoalPosition().getY();
			int diffZ = maze.getStartPosition().getZ() - maze.getGoalPosition().getZ();
			
			// Build track for dimension X   
			if(diffX > 0)
			{
				for(int loop = currPos.getX(); loop >= exitX; loop--)
				{
					maze.setArray(currPos, 0);
					currPos.setX(loop);
				}
			}
			else
			{
				for(int loop = currPos.getX(); loop <= exitX; loop++)
				{
					maze.setArray(currPos, 0);
					currPos.setX(loop);
				}
			}
			
			// Build track for dimension Y 
			if(diffY > 0)
			{
				for(int loop = currPos.getY(); loop >= exitY; loop--)
				{
					maze.setArray(currPos, 0);
					currPos.setY(loop);
				}
			}
			else
			{
				for(int loop = currPos.getY(); loop <= exitY; loop++)
				{
					maze.setArray(currPos, 0);
					currPos.setY(loop);
				}
			}	
			
			// Build track for dimension Z
			if(diffZ > 0)
			{
				for(int loop = currPos.getZ(); loop >= exitZ; loop--)
				{
					maze.setArray(currPos, 0);
					currPos.setZ(loop);
				}
			}
			else
			{
				for(int loop = currPos.getZ(); loop <= exitZ; loop++)
				{
					maze.setArray(currPos, 0);
					currPos.setZ(loop);
				}
			}
		}
}