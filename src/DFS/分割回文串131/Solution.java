package DFS.分割回文串131;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，
 * 使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0){
            return result;
        }
        dfs(s,0);
        return result;
    }

    public void dfs(String s, int index){
        if(index==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index;i<s.length();i++){
            if(!isHuiwen(s,index,i)){
                continue;
            }
            path.add(s.substring(index,i+1));
            dfs(s,i+1);
            path.remove(path.size()-1);
        }
    }

    public boolean isHuiwen(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.partition("aab"));
    }
}
