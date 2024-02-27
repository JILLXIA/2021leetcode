package labuladong.CorporateFlightBookings1109;

public class Solution1 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        int[] result = new int[n];
        for(int i = 0; i < bookings.length; i++) {
            diff[bookings[i][0] - 1] += bookings[i][2];
            diff[bookings[i][1]] -= bookings[i][2];
        }
        int sum = 0;
        for(int i  = 0; i < result.length; i++) {
            sum += diff[i];
            result[i] = sum;
        }
        return result;
    }
}
