package DFS.单词拆分139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0;i<dp.length-1;i++){
            for(int j = i+1;j<dp.length;j++){
                if(dp[i]==1&&wordDict.contains(s.substring(i,j))){
                    dp[j] = 1;
                }
            }
            if(dp[s.length()]==1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        String[] sarr = {"leet","code"};
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(sarr));
        s.wordBreak("leetcode", arr);
    }
}
