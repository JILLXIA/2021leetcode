package ProgrammerCarl.ValidParentheses20;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters
 * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c=='[' || c=='{'){
                stack.push(c);
            } else {
                if(!stack.isEmpty() && map.get(c) == stack.peek()){
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
