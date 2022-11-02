package Top100Question.Calculator224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s representing a valid expression,
 * implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in
 * function which evaluates strings as mathematical expressions, such as eval().
 */
public class Solution {
    public int calculate(String s) {
        return realCalculate(s,0)[0];
    }

    public int[] realCalculate(String s, int index){
        if(index >= s.length()){
            return new int[]{0,index};
        }
        Deque<Integer> deque = new LinkedList();
        char sign = '+';
        int num = 0;
        int i;
        for(i = index;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp=='('){
                int[] arr = realCalculate(s, i+1);
                i = arr[1];
                continue;
            }
            if(Character.isDigit(tmp)){
                num = num * 10 + tmp - '0';
            } else if((Character.isLetter(tmp) && tmp!=' ') || i == s.length()-1){
                switch(sign){
                    case '+':
                        deque.offerLast(num);
                        break;
                    case '-':
                        deque.offerLast(num);
                        break;
                    case '*':
                        deque.offerLast(deque.pollLast() * num);
                        break;
                    case '/':
                        deque.offerLast(deque.pollLast() / num);
                        break;
                }
                sign = tmp;
                num = 0;
            }
            if(tmp==')'){
                break;
            }

        }
        int result = 0;
        while(!deque.isEmpty()){
            result += deque.pollFirst();
        }
        return new int[]{result,i};
    }
}
