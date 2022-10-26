package Top100Question.GenerateParentheses22;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 */
public class Solution {
    // dfs
    List<String> result;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        sb = new StringBuilder();
        dfs(n,n,n);
        return result;

    }
    // n,n
    // 0,0
    public void dfs(int left, int right, int n){
        if(left==0 && right==0){
            result.add(sb.toString());
            return;
        }

        if(left > n || right < left || left < 0 || right < 0){
            return;
        }
        sb.append("(");
        dfs(left - 1, right,n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        dfs(left, right - 1,n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
