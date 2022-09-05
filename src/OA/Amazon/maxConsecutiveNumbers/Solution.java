package OA.Amazon.maxConsecutiveNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Treat the problem as :
 * Find the longest subarray with at most K zeros.
 * Keep the index of Zeroes in the longest subarray in a list
 */
public class Solution {
    public List<Integer> maxConsecutiveNumbers(int[] nums, int k){
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();// index 0 in nums
        int left = 0;
        int right = 0;
        int count0 = 0;
        int maxLength = 0;
        while(right < nums.length){
            if(nums[right]==0){
                count0++;
                set.add(right);
            }
            while(count0 > k && left < right){
                if(nums[left]==0){
                    count0--;
                    set.remove(left);
                }
                left++;
            }
            if(maxLength < right - left +1){
                result = new ArrayList<>(set);
                maxLength = right - left + 1;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxConsecutiveNumbers(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1},2));
        System.out.println(s.maxConsecutiveNumbers(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1},1));
        System.out.println(s.maxConsecutiveNumbers(new int[]{0, 0, 0, 1},4));
    }
}
