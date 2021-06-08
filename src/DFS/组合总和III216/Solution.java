package DFS.组合总和III216;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。
 * 组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k<=0||n<=0){
            return result;
        }
        dfs(k,n,1);
        return result;
    }

    public void dfs(int k,int n,int index){
        if(path.size()==k){
            if(sum==n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        if(index>n/(k-path.size())){
            return;
        }

        for(int i = index;i<=9;i++){
            path.add(i);
            sum = sum+i;
            dfs(k,n,i+1);
            sum = sum-i;
            path.remove(path.size()-1);
        }
    }
}
