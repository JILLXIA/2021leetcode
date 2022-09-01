package OA.Amazon.PrimeMoviweAward;

import java.util.Arrays;

public class Solution {
    public int movieAward(int[] arr, int k){
        Arrays.sort(arr);
        int result = 1;
        int maxIndex = arr[0] + k;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < maxIndex){
                continue;
            } else {
                maxIndex = arr[i] + k;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movieAward(new int[]{1,5,4,6,8,9,2},3));
    }
}
