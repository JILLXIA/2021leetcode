package 字符串.括号面试题0809;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * 例如，给出 n = 3，生成结果为：
 */

/**
 * dfs递归
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        List<String> result = new ArrayList<>();

        dfs(left,right,result,"");
        return result;
    }

    public static void dfs(int left, int right, List<String> result,String tmp){
        if(left==0&&right==0){
            result.add(tmp.toString());
            return ;
        }//左括号和右括号都用完了
        if(left<0){//不满足条件的直接return
            return;
        }
        if(right<left){
            return;
        }
        dfs(left-1,right,result,tmp+"(");//选左括号，改变放在参数里累加
        dfs(left,right-1,result,tmp+")");//选右括号

    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(2));
    }
}

