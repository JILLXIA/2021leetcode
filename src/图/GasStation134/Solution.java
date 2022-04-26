package 图.GasStation134;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 */
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] arr = new int[gas.length];
		for(int i = 0;i<arr.length;i++){
			arr[i] = gas[i] - cost[i];
		}
		// 多个站点可以等效看为一个站点
		int sum_tunk = 0;
		int curr_tunk = 0;
		int index = -1;
		//So what does this means in terms of our algorithm, it means that we know if we run out of fuel say at some ith gas station. All the gas station between ith and starting point are bad starting point as well.
		for(int i = 0;i<arr.length;i++){
			sum_tunk += arr[i];
			curr_tunk += arr[i];
			if(curr_tunk < 0){
				index = i+1;
				curr_tunk = 0;
			}
		}
		return sum_tunk >= 0 ? index : -1;
	}
}
