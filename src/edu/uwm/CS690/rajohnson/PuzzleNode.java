package edu.uwm.CS690.rajohnson;
//TODO: Override .equals method so that if my puzzle == other puzzle then they are the same. 
public class PuzzleNode {
	private char[] puzzle = new char[7];
	private int my_g;
	private int my_h;
	private PuzzleNode parent;
	
	public PuzzleNode(char[] puzzleInstance, PuzzleNode nodeParent)
	{
		puzzle = puzzleInstance;
		parent = nodeParent;
		my_g = 0;
		my_h = 0;
	}
	
	public int getG()
	{
		return my_g;
	}
	
	public void setG(int new_g)
	{
		my_g = new_g;
	}
	
	public int getH()
	{
		return my_h;
	}
	
	public void setH(int new_h)
	{
		my_h = new_h;
	}
	
	public char[] getPuzzle()
	{
		return puzzle;
	}
	
	public void setPuzzle(char[] new_puzzle)
	{
		puzzle = new_puzzle;
	}
	
	public PuzzleNode getParent()
	{
		return parent;
	}
	
	/**
	 * 
	 * @return f(n) = h(n) + g(n)
	 */
	public int getTotalCost()
	{
		return my_g + my_h;
	}
	
	public int calculateCost(char[] startingPuzzle)
	{
		int cost = 0;
		
		int i;
		for(i = 0; i < startingPuzzle.length; i++)
		{
			if(startingPuzzle[i] == 'X')
				break;
		}
		
		int j;
		for(j = 0; j < puzzle.length; j++)
		{
			if(puzzle[j] == 'X')
				break;
		}
		
		cost = Math.abs(i-j);
		
		return cost;
	}
	
}
