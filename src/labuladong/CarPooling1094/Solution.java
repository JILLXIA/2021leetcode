package labuladong.CarPooling1094;

/**
 * There is a car with capacity empty seats.
 * The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array
 * trips where trips[i] = [numPassengersi, fromi, toi]
 * indicates that the ith trip has numPassengersi passengers and
 * the locations to pick them up and drop them off are fromi and toi
 * respectively. The locations are given as the number of kilometers due
 * east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers
 * for all the given trips, or false otherwise.
 */
public class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		int[] diff = new int[1002];

		for(int[] trip:trips){
			diff[trip[1]] += trip[0];
			if(trip[2] + 1 < diff.length){
				diff[trip[2]+1] -= trip[0];
			}
		}
		int max = -1;
		int pre = diff[0];
		for(int i = 1;i< diff.length;i++){
			max = Math.max(max, diff[i] + pre);
			pre = diff[i] + pre;
			if(max > capacity){
				return false;
			}
		}
		return true;
	}
}
