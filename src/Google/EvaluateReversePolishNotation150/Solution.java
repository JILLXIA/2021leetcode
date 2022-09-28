package Google.EvaluateReversePolishNotation150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid.
 * That means the expression would always evaluate to a result,
 * and there will not be any division by zero operation.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i< tokens.length;i++){
           if(tokens[i].equals("+")){
               int tmp1 = deque.pollLast();
               int tmp2 = deque.pollLast();
               deque.offerLast(tmp1 + tmp2);
           } else if(tokens[i].equals("-")){
               int tmp1 = deque.pollLast();
               int tmp2 = deque.pollLast();
               deque.offerLast(tmp2 - tmp1);
           } else if(tokens[i].equals("*")){
               int tmp1 = deque.pollLast();
               int tmp2 = deque.pollLast();
               deque.offerLast(tmp1 * tmp2);
           }else if(tokens[i].equals("/")){
               int tmp1 = deque.pollLast();
               int tmp2 = deque.pollLast();
               deque.offerLast(tmp2 / tmp1);
           } else{
               deque.offerLast(Integer.parseInt(tokens[i]));
           }
        }
        return deque.peekLast();
    }
}
