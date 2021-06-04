package DFS.全排列II47;

import java.util.*;

public class Solution {
    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0){
            return result;
        }
        int[] isused  = new int[nums.length];//排列问题用数组代替index
        Arrays.sort(nums);
        dfs(nums,isused);
        return result;
    }

    public void dfs(int[] nums,int[] isused){
        if(path.size()== nums.length){
            if(!result.contains(path)) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(isused[i]!=0){
                continue;
            }
            //剪枝的操作，先对数组进行排列，如果当前元素和前一个元素一样，并且，前一个元素没有使用到的时候进行进行剪枝
            if(i>0&&nums[i-1]==nums[i]&&isused[i-1]==0){
                continue;
            }
            path.offerLast(nums[i]);
            isused[i] = 1;
            dfs(nums,isused);
            isused[i] = 0;
            path.pollLast();
        }
    }
}
