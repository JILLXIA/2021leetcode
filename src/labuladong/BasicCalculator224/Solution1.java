package labuladong.BasicCalculator224;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public int calculate(String s) {
        // 因为只有加减乘除，所以可以用栈来解决
        // 原来的方法是用递归，但是递归的时候，需要记录（）下一个开始的位置，所以用栈来解决
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            deque.offerLast(s.charAt(i));
        }
        return realCalculate(deque);
    }

    public int realCalculate(Deque<Character> deque) {
        char sign = '+';
        int num = 0;
        Deque<Integer> result = new LinkedList<>();

        while(!deque.isEmpty()) {
            char c = deque.pollFirst();
            if(c == '(') {
                num = realCalculate(deque);
            }
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }


//" "要和符号判断写到一起
            if(!Character.isDigit(c) && c != ' ' || deque.isEmpty()){
                switch(sign){
                    case '+':
                        result.offerLast(num);
                        break;
                    case '-':
                        result.offerLast(-num);
                        break;
                    case '*':
                        result.offerLast(result.pollLast() * num);
                        break;
                    case '/':
                        result.offerLast(result.pollLast() / num);
                        break;
                }
                num = 0;
                sign = c;
            }

            if(c == ')') {
                break;
            }
        }

        int res = 0;
        while(!result.isEmpty()) {
            res += result.pollFirst();
        }
        return res;
    }

//    public int[] realCalculate(String s, int index) {
//        Deque<Integer> deque = new LinkedList<>();
//
//
//        // 只有加减的时候，相当于分离一个个数字加起来
//        char sign = '+';
//        int num = 0;
//        int i = index;
//        for(i = index; i < s.length(); i++) {
//            if(s.charAt(i) == '(') {
//                int[] brace = realCalculate(s, i + 1);
//                //下面的从哪开始，可以需要一个visited数组，但是会重复便利，不如就返回）的位置
//                num = brace[0];
//                i = brace[1]; // i only used in next loop
//            }
//
//            if(Character.isDigit(s.charAt(i))) {
//                num = num * 10 + s.charAt(i) - '0';
//            }
//
//            // 遇到符号或者便利到最后一个，需要把前面的数字入栈
//            // ' '的判断只能写到这里
//            // )的时候也走这个逻辑
//            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1){
//                switch(sign){
//                    case '+':
//                        deque.offerLast(num);
//                        break;
//                    case '-':
//                        deque.offerLast(-num);
//                        break;
//                    case '*':
//                        deque.offerLast(deque.pollLast() * num);
//                        break;
//                    case '/':
//                        deque.offerLast(deque.pollLast() / num);
//                        break;
//                }
//                num = 0;
//                sign = s.charAt(i);
//            }
//
//            if(s.charAt(i) == ')') {
//                break;
//            }
//            // 需要把括号里的东西都加完
//        }
//
//        int result = 0;
//        while(!deque.isEmpty()) {
//            result += deque.pollFirst();
//        }
//        return new int[]{result, i};
//    }

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        System.out.println(s1.calculate("(1+2)+1"));
    }
}
