package labuladong.CapacityToShipPackagesWithinDDays1011;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt
 * (in the order given by weights).
 * We may not load more weight than the maximum weight
 * capacity of the ship.
 *
 * Return the least weight capacity of the ship
 * that will result in all the packages on the conveyor
 * belt being shipped within days days.
 */
public class Solution {
	public int shipWithinDays(int[] weights, int days) {
		int left = 0;
		int right = 1;
		for(int weight:weights){
			left = Math.max(left,weight);
			right += weight;
		}
		while(left < right){
			int mid = left + (right-left)/2;
			int compare = f(weights,mid);
			if(compare==days){
				right = mid;
			} else if(compare > days){
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	public int f(int[] weights, int capacity){
		int result = 0;
		int sum = 0;
		for(int weight:weights){
			sum += weight;
			if(sum > capacity){
				result++;
				sum = weight;
			} else if(sum==capacity){
				result++;
				sum = 0;
			}
		}
		return sum > 0 ? result+1:result;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.f(new int[]{1,2,3,4,5,6,7,8,9,10},11));
	}
}
