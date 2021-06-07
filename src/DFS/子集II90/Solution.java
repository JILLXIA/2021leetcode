package DFS.子集II90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<>());
        if(nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        int[] isVisit = new int[nums.length];
        dfs(nums,0,isVisit);
        return result;
    }

    public void dfs(int[] nums,int index,int[] isVisit){
        if(index==nums.length){
            return;
        }

        for(int i = index;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&isVisit[i-1]==0){
                continue;
            }
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            isVisit[i] = 1;
            dfs(nums,i+1,isVisit);
            isVisit[i] = 0;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();

        s.subsetsWithDup(new int[]{1,2,2});
    }
}
