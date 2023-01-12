package Top100Question.Permutations46;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers,
 * return all the possible permutations.
 * You can return the answer in any order.
 */
public class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();
        path = new ArrayList();
        boolean[] isVisited = new boolean[nums.length];
        dfs(nums, isVisited);
        return result;
    }

    public void dfs(int[] nums,boolean[] isVisited){
        if(path.size()==nums.length){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(isVisited[i]){
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, isVisited);
            isVisited[i] = false;
            path.remove(path.size()-1);
        }
    }
}
