package OA.Paypal.MinimumAbsoluteDifference1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr,
 * find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs),
 * each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 */
public class Solution {
    // int min = Integer.MIN_VALUE;
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;

        for(int i = 1;i<arr.length;i++){
            minDifference = Math.min(minDifference, arr[i] - arr[i-1]);
        }

        for(int i = 1;i<arr.length;i++){
            if(arr[i] - arr[i-1]==minDifference){
                List<Integer> tmp = new ArrayList();
                tmp.add(arr[i-1]);
                tmp.add(arr[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
