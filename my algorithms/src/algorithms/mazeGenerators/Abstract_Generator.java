package algorithms.mazeGenerators;

import java.lang.System;

public abstract class Abstract_Generator implements Maze3dGenerator{

	public String measureAlgorithmTime(sizeOfMaze size)
	{
		Long t1, t2;
		t1 = System.currentTimeMillis();
		generate(size);
		t2 = System.currentTimeMillis();
		
		String s = "It took: " + Long.toString(t2-t1) + " milliseconds to generate";
		
		return s;
	}
	
}
