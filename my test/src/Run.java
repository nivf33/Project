import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import algorithms.mazeGenerators.sizeOfMaze;

public class Run {

		private static void testMazeGenerator(Maze3dGenerator mg){
			
		// prints the time it takes the algorithm to run
		System.out.println(mg.measureAlgorithmTime(new sizeOfMaze(3, 4, 5)));
		
		// generate another 3d maze
		Maze3d maze=mg.generate(new sizeOfMaze(6, 7, 8));
		
		// get the maze entranceS
		Position p=maze.getStartPosition();
		
		// print the position
		System.out.println(p); // format "{x,y,z}"
		
		// get all the possible moves from a position
//		String[] moves = maze.getPossibleMoves(p);
//		// print the moves
//		for(String move : moves)
//		System.out.println(move);
		
		// prints the maze exit position
		System.out.println(maze.getGoalPosition());
		
		try{
		// get 2d cross sections of the 3d maze
		int[][] maze2dx=maze.getCrossSectionByX(2);
		printMaze2D(maze2dx);
		int[][] maze2dy=maze.getCrossSectionByY(5);
		printMaze2D(maze2dy);
		int[][] maze2dz=maze.getCrossSectionByZ(0);
		printMaze2D(maze2dz);
		// this should throw an exception!
		maze.getCrossSectionByX(-1);
		} catch (IndexOutOfBoundsException e){
		System.out.println("good!");
		}
	}
		
		// Print 2D dimension maze 
		public static void printMaze2D(int matrix[][])
		{
			int row, column;
			
			for (row = 0; row < matrix.length; row++)
			{
				for(column = 0; column < matrix[1].length; column++)
				{
						System.out.print(matrix[row][column]);
						System.out.print(" ");
				}
				
				System.out.println();
			}
			
			System.out.println();
			System.out.println();
		}
		
		public static void main(String[] args) {
			testMazeGenerator(new SimpleMaze3dGenerator());
			testMazeGenerator(new MyMaze3dGenerator());
		}
	}
