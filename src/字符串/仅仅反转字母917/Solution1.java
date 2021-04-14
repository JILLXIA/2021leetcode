package 字符串.仅仅反转字母917;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 反向操作想到栈
 */
public class Solution1 {
    public String reverseOnlyLetters(String S) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                deque.offerLast(S.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                result.append(deque.pollLast());
            }else{
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
}
