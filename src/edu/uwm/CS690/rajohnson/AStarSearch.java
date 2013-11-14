package edu.uwm.CS690.rajohnson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class AStarSearch {

	private Heuristic m_Heuristic;
	
	public AStarSearch(Heuristic h) {
		m_Heuristic = h;
	}
	
	public Deque<PuzzleNode> search(PuzzleNode startNode)
	{
		
		 PriorityQueue<PuzzleNode> successors = new PriorityQueue<PuzzleNode>(16, new Comparator<PuzzleNode>() {
			 @Override
			 public int compare(PuzzleNode o1, PuzzleNode o2)
			 {
                 	int h1 = o1.getTotalCost();
                 	int h2 = o2.getTotalCost();

                 	return (h1 - h2);
			 }
		 });
		
		HashSet<PuzzleNode> visitedNodes = new HashSet<PuzzleNode>();
		 
		successors.add(startNode);
		while(!successors.isEmpty())
		{
			PuzzleNode currentNode = successors.poll();
			visitedNodes.add(currentNode);
			
			for(PuzzleNode n : generateSuccessors(currentNode))
			{
				n.setG(currentNode.getG() + n.calculateCost(currentNode.getPuzzle()));
				if(isGoal(n))
				{
					//If this is the goal, then h(n) = 0
					n.setH(0);
					return generatePathFromGoal(n);
				}
				else
				{
					n.setH(m_Heuristic.calculateCost(n.getPuzzle()));
					successors.add(n);
				}
			}
		}
		
		return new ArrayDeque<PuzzleNode>();
	}
	
	
	private List<PuzzleNode> generateSuccessors(PuzzleNode parent)
	{
		int x;
		char[] parentPuzzle = parent.getPuzzle().clone();
		for(x = 0; x < parentPuzzle.length; x++)
		{
			if(parentPuzzle[x] == 'X')
				break;
		}
		
		ArrayList<PuzzleNode> successors = new ArrayList<PuzzleNode>();
		for(int i = 0; i < parentPuzzle.length; i++)
		{
			if((Math.abs(i-x) < 4) && (i != x))
			{
				char[] childPuzzle = parentPuzzle.clone();
				char tileToMove = childPuzzle[i];
				childPuzzle[i] = 'X';
				childPuzzle[x] = tileToMove;
				successors.add(new PuzzleNode(childPuzzle, parent));
			}
		}
		
		return successors;
	}
	
	/**
	 * Follows the goal node via a chain of parents to the start and returns that as a deque. 
	 * @param goal
	 * @return
	 */
	private Deque<PuzzleNode> generatePathFromGoal(PuzzleNode goal)
	{
		PuzzleNode currentNode = goal;
		ArrayDeque<PuzzleNode> path = new ArrayDeque<PuzzleNode>();
		while(currentNode != null)
		{
			path.addFirst(currentNode);
			currentNode = currentNode.getParent();
		}
		
		return path;
	}
	
	private boolean isGoal(PuzzleNode n)
	{
		char[] puzzle = n.getPuzzle();
		int lengthOfAreaToCheck = (int)Math.ceil(puzzle.length/2.0);
		for(int i = 0; i < lengthOfAreaToCheck; i++)
		{
			if((puzzle[i]) == 'A')
			{
				return false;
			}
		}
		return true;
	}

}
