package 图.MinimumJumpsToReachHome1654;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

/**
 * A certain bug's home is on the x-axis at position x.
 * Help them get there from position 0.
 *
 * The bug jumps according to the following rules:
 *
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * The bug may jump forward beyond its home, but it cannot jump to positions
 * numbered with negative integers.
 *
 * Given an array of integers forbidden, where forbidden[i] means that the bug
 * cannot jump to the position forbidden[i], and integers a, b, and x,
 * return the minimum number of jumps needed for the bug to reach its home.
 * If there is no possible sequence of jumps that lands the bug on position x,
 * return -1.
 */
public class Solution {
	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0;i < forbidden.length; i++){
			set.add(forbidden[i]);
		}
		Deque<Truple> deque = new LinkedList<>();
		deque.offerLast(new Truple(0,0));
		Set<Integer> visited = new HashSet<>();
		visited.add(0);

		if(x==0){
			// edge cases
			return 0;
		}

		while(!deque.isEmpty()){
			Truple tmpTruple = deque.pollFirst();
			int nextForward = tmpTruple.index + a;
			int nextForwardBackward = tmpTruple.index + a - b;

			if(nextForward >= 0 && nextForward <= 6000 && !set.contains(nextForward) && !visited.contains(nextForward)){
				if(nextForward==x){
					return tmpTruple.cost+1;
				}
				deque.offerLast(new Truple(nextForward,tmpTruple.cost+1));

				// 关键点在于左跳的点不应该加入visited
				/**
				 * 引用@CaptainTec的话：set中不能加入左移时遍历到的数据，原因是因为左移后退回cur-b处时，无法覆盖前进到cur-b再后退到cur-2b的情况。
				 * 通俗解释：前进去过的地方，后退就没必要再去了，因为前进去过的地方，既可以前进又可以后退。但是后退去过的地方因为只能前进，所以前进还得再去搜索一下，看后退符不符合条件。
				 * 或者说，放入set的条件是这个点的下一步跳跃的所有可能性均已加入后续的遍历中，但如果向左跳至某点，这点的再往左跳这一可能性没有加入后续的遍历中，因此不能把向左跳的点放入set中
				 */
				if(nextForwardBackward >= 0 && nextForwardBackward <= 6000
						&& !set.contains(nextForwardBackward)
						&& !visited.contains(nextForwardBackward)){
					if(nextForwardBackward==x){
						return tmpTruple.cost+2;
					}
					deque.offerLast(new Truple(nextForwardBackward,tmpTruple.cost+2));
					// visited.add(nextForwardBackward);
				}
				visited.add(nextForward);
			}
		}
		return -1;
	}
}

class Truple{
	int index;
	int cost;
	public Truple(int index, int cost){
		this.index = index;
		this.cost = cost;
	}
}