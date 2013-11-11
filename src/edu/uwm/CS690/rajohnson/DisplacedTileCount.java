package edu.uwm.CS690.rajohnson;

import java.util.TreeSet;

public class DisplacedTileCount implements Heuristic {

	@Override
	public int calculateHeuristic(char[] puzzleState) {
		int sum = 0;
		TreeSet<Integer> spacesMoved = new TreeSet<Integer>();
		for(int i = 0; i < 6; i++)
		{
			if( puzzleState[i] == 'A')
			{
				if(i-4 < 0)//A tile needs to be moved
				{
					int x = 4;
					//Find the first viable space to move tile at puzzleState[i] and the cost
					while((puzzleState[x] == 'A') || (spacesMoved.contains(x) && x <= 6))
					{
						x++;
					}
					if(x < 7)
					{
						sum += x - i;
						spacesMoved.add(x);
					}
				}
			}
			else if( puzzleState[i] == 'B' )
			{
				if(i-4 > 0)
				{
					int x = 4;
					while((puzzleState[x] == 'B') || (spacesMoved.contains(x) && x >= 0))
					{
						x++;
					}
					if(x > 0)
					{
						sum += i - x;
						spacesMoved.add(x);
					}
				}
			}
		}
		return sum;
	}

}
