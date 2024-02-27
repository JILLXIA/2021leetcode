package labuladong.BasicCalculator224;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int calculate(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            deque.offerLast(c);
        }
        return realCalculate(deque);
    }

    public int realCalculate(Deque<Character> deque) {
        char sign = '+';
        int result = 0;
        int num = 0;
        Deque<Integer> ansList = new LinkedList<>();
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (c == '(') {
                num = realCalculate(deque);
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if(!Character.isDigit(c) && c != ' ' || deque.isEmpty()) {
                switch (sign) {
                    case '+':
                        ansList.offerLast(num);
                        break;
                    case '-':
                        ansList.offerLast(-num);
                        break;
                    case '*':
                        ansList.offerLast(ansList.pollLast() * num);
                        break;
                    case '/':
                        ansList.offerLast(ansList.pollLast() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if(c == ')') {
                break;
            }
        }
        while (!ansList.isEmpty()) {
            result += ansList.pollFirst();
        }
        return result;
    }
}
