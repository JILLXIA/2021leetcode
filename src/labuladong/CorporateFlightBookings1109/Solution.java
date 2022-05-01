package labuladong.CorporateFlightBookings1109;

/**
 * There are n flights that are labeled from 1 to n.
 *
 * You are given an array of flight bookings bookings,
 * where bookings[i] = [firsti, lasti, seatsi] represents a booking for
 * flights firsti through lasti (inclusive) with seatsi seats reserved
 * for each flight in the range.
 *
 * Return an array answer of length n, where answer[i] is the total
 * number of seats reserved for flight i.
 */
public class Solution {
	public int[] corpFlightBookings(int[][] bookings, int n) {
			int[] diff = new int[n];
			for(int[] booking:bookings){
				diff[booking[0]-1] += booking[2];
				if(booking[1]<n)
					diff[booking[1]] -= booking[2];
			}
			int[] result = new int[n];
			result[0] = diff[0];
			for(int i = 1;i<n;i++){
				result[i] = result[i-1] + diff[i];
			}
			return result;
	}
}
