package algorithms.mazeGenerators;

public interface Maze3dGenerator {

	public Maze3d generate(sizeOfMaze size);
	
	public String measureAlgorithmTime(sizeOfMaze size);
}
