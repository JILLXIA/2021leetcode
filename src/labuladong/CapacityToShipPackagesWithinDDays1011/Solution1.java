package labuladong.CapacityToShipPackagesWithinDDays1011;

public class Solution1 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // find left boundary
        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int count = 1;
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (sum > capacity) {
                count++;
                sum = weight;
            }
        }
        return count <= days;
    }
}
