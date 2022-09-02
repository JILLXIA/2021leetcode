package OA.Amazon.MaximumElementAfterDecreasingAndRearranging;

import java.util.Arrays;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            if(i==0){
                arr[i] = 1;
            } else {
                if(arr[i] > arr[i-1] + 1){
                    arr[i] = arr[i-1] + 1;
                }
            }
        }
        return arr[arr.length-1];
    }
}
