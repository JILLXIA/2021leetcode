package DFS.组合总和II40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0||target<=0){
            return result;
        }
        Arrays.sort(candidates);
        int[] isVisit = new int[candidates.length];
        dfs(candidates,target,0,isVisit);
        return result;
    }

    public void dfs(int[] candidates,int target, int index,int[] isVisit){
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&isVisit[i-1] == 0){
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];
            isVisit[i] = 1;
            dfs(candidates,target,i+1,isVisit);
            sum -= candidates[i];
            path.remove(path.size()-1);
            isVisit[i] = 0;
        }
    }
}
