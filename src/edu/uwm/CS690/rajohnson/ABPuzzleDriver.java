package edu.uwm.CS690.rajohnson;

import java.util.ArrayDeque;
import java.util.Scanner;


public class ABPuzzleDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int puzzleSize = -1;
		Scanner s = new Scanner(System.in);
		while(puzzleSize < 3 || (puzzleSize % 2 == 0))
		{
			System.out.print("Enter a puzzle size that is an odd number and is greater than 2: ");
			puzzleSize = s.nextInt();
		}
		
		char[] startState = new char[puzzleSize];
		
		int halfwayPoint = (int)Math.floor(puzzleSize/2.0);
		
		for(int i = 0; i < puzzleSize-1; i++)
		{
			if(i < halfwayPoint)
			{
				startState[i] = 'A';
			}
			else
			{
				startState[i] = 'B';
			}
			
		}
		startState[puzzleSize-1] = 'X';
		
		System.out.println("Starting AB Puzzle with size " + puzzleSize + " : " + new String(startState));
		
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
		
		AStarSearch uninformedAStar = new AStarSearch(new NoCostHeuristic());
		
		ArrayDeque<PuzzleNode> badHeuristicGoal = (ArrayDeque<PuzzleNode>) uninformedAStar.search(start);
		if(badHeuristicGoal != null)
		{
			for(PuzzleNode n : badHeuristicGoal)
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
