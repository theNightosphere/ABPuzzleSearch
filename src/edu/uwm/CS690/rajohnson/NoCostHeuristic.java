package edu.uwm.CS690.rajohnson;

public class NoCostHeuristic implements Heuristic {

	public NoCostHeuristic() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Heuristic for h (equivalent to) 0. 
	 */
	@Override
	public int calculateCost(char[] puzzleState) {
		return 0;
	}

}
