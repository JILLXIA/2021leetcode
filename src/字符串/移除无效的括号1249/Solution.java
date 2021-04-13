package 字符串.移除无效的括号1249;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，
 * 使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下任意一条要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作AB（A连接B）的字符串，其中A和B都是有效「括号字符串」
 * 可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
 */

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 用栈来匹配，计算要删除的（）的index
 * 这种要两边匹配的问题都要用栈
 *
 * 然后生成新的字符串
 *
 * 也可以正反两次遍历，一次先删除多余的）
 * 第二次反过来遍历删除多余的（
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndex = new HashSet<Integer>();
        Deque<Integer> stack = new LinkedList<>();

        char[] c = s.toCharArray();

        for(int i = 0;i<c.length;i++){
            if(c[i]=='('){
                stack.offerLast(i);
            }else if(c[i]==')' && !stack.isEmpty()){
                stack.pollLast();
            }else if(c[i]==')' && stack.isEmpty()){
                removeIndex.add(i);
            }
        }

        while(!stack.isEmpty()){
            removeIndex.add(stack.pollLast());
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0;i<c.length;i++){
            if(!removeIndex.contains(i)){
               result.append(c[i]);
            }
        }

        return result.toString();
    }
}
