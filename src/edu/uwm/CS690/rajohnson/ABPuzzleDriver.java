package edu.uwm.CS690.rajohnson;

import java.util.ArrayDeque;

//TODO: Method to generate possible steps from current step.

public class ABPuzzleDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting AB Puzzle with size seven: [A,A,A,B,B,B,X]");
		
		char[] startState = {'A','A','A','B','B','B','X'};
		PuzzleNode start = new PuzzleNode(startState, null);
		
		AStarSearch aStar = new AStarSearch(new DisplacedTileCount());
		
		ArrayDeque<PuzzleNode> goal = (ArrayDeque<PuzzleNode>) aStar.search(start);
		if(goal != null)
		{
			for(PuzzleNode n : goal)
			{
				System.out.println(new String(n.getPuzzle()));
				System.out.println("\th(n):" + n.getH() + " g(n):" + n.getG());
			}
		}
		else
		{
			System.out.println("No solution found :(");
		}

	}

}
