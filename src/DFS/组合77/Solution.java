package DFS.组合77;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，
 * 返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0||k==0){
            return result;
        }
        dfs(n,k,1);
        return result;
    }
    public void dfs(int n,int k,int index){
        if(path.size()== k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i<=n-(k-path.size())+1;i++){//剪枝的操作
            path.add(i);
            dfs(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
