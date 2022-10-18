package ByteDance.KClosestPointsToOrigin973;

import java.util.Arrays;

public class Solution1 {
    // quick selecting
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        while(true){
            int mid = partition(points,left,right);
            if(mid==k){
                break;
            } else if(mid < k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0,k);
    }

    public int partition(int[][] points, int low, int high){
        int pivot = dist(points[low]);

        int left = low + 1;
        int right = high;
        while(left <= right){
            while (left < high && dist(points[left]) <= pivot) {
                left++;
            }

            while(right > low && dist(points[right]) > pivot){
                right--;
            }
            if(left >= right){
                break;
            }
            swap(points, left, right);
        }
        swap(points, low, right);
        return right;
    }

    public void swap(int[][] points, int i, int j){
        int tmp1 = points[j][0];
        int tmp2 = points[j][1];

        points[j][0] = points[i][0];
        points[j][1] = points[i][1];

        points[i][0] = tmp1;
        points[i][1] = tmp2;
    }
    public int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
