package Top100Question.DecodeWays91;

import java.util.Arrays;

/**
 * A message containing letters
 * from A-Z can be encoded into numbers using the following mapping:
 */
public class Solution {
    // dfs splite character
    // memo memory
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    public int dfs(String s, int index, int[] memo){
        if(index>=s.length()){
            return 1;
        }

        if(memo[index]!=-1){
            return memo[index];
        }

        if(s.charAt(index)=='0'){
            return 0;
        }

        int result = dfs(s, index+1, memo);
        if(index < s.length() - 1 && Integer.parseInt(s.substring(index, index+2)) <= 26){
            result += dfs(s, index+2, memo);
        }
        memo[index] = result;
        return result;

    }
}
