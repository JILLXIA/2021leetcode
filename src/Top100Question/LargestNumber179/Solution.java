package Top100Question.LargestNumber179;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // 30 3 or 3 30
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(int i = 0;i<nums.length;i++){
            pq.add(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
}
