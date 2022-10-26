package Top100Question.ValidParentheses20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class Solution {
    public boolean isValid(String s) {
        // Stack
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                deque.offerLast(s.charAt(i));
            } else {
                if(s.charAt(i)==')'){
                    if(deque.isEmpty() || deque.peekLast()!='('){
                        return false;
                    }
                } else if(s.charAt(i)==']'){
                    if(deque.isEmpty() || deque.peekLast()!='['){
                        return false;
                    }
                } else if(s.charAt(i)=='}'){
                    if(deque.isEmpty() || deque.peekLast()!='{'){
                        return false;
                    }
                }
                deque.pollLast();
            }
        }
        return deque.isEmpty();
    }
}
