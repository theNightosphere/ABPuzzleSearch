package edu.uwm.CS690.rajohnson;

import java.util.TreeSet;

public class DisplacedTileCount implements Heuristic {

	@Override
	public int calculateCost(char[] puzzleState) {
		int sum = 0;
		int puzzleLength = puzzleState.length;
		int halfwayLength = (int)Math.ceil(puzzleState.length/2.0);
		TreeSet<Integer> spacesMoved = new TreeSet<Integer>();
		for(int i = 0; i < puzzleLength-1; i++)
		{
			if( puzzleState[i] == 'A')
			{
				if(i-halfwayLength < 0)//A tile needs to be moved
				{
					int x = halfwayLength;
					while((x < puzzleState.length) && (spacesMoved.contains(x)) || (puzzleState[x] == 'A'))
					{
						x++;
					}
					if(x < puzzleLength)
					{
						sum += x - i;
						spacesMoved.add(x);
					}
				}
			}
			else if( puzzleState[i] == 'B' )
			{
				if(i-halfwayLength > 0)
				{
					int x = halfwayLength;
					while((puzzleState[x] == 'B') || (spacesMoved.contains(x) && x >= 0))
					{
						x--;
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
