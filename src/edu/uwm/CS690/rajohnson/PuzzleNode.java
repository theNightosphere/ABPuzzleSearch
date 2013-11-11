package edu.uwm.CS690.rajohnson;
//TODO: Override .equals method so that if my puzzle == other puzzle then they are the same. 
public class PuzzleNode {
	private char[] puzzle = new char[7];
	private int my_g;
	private int my_h;
	public PuzzleNode(char[] puzzleInstance, int g, int h)
	{
		puzzle = puzzleInstance;
		my_g = g;
		my_h = h;
		
	}
}
