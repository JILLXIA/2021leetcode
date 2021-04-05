package 数组.汇总区间228;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int low = 0;
        int high = 0;
        if(nums.length==0){
            return result;
        }
        while(high<nums.length){
            while(high+1<nums.length && nums[high+1]-nums[high]==1){
                high++;
            }
            String temp;
            if(high-low!=0){
                temp = nums[low] + "->" + nums[high];
            }else{
                temp = String.valueOf(nums[low]);
            }
            low = high + 1;
            high = low;
            result.add(temp);
        }
        return result;
    }
}
