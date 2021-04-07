package 字符串.计算器面试题16;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1. 如果碰到数字， 则把数字入栈
 * 2. 如果碰到空格， 则继续下一步
 * 3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
 *  A.如果是'+', 下一个数字num直接入栈
 *  B.如果是'-'，-num入栈
 *  C.如果是'*', num = stack.pop() * num, 入栈
 *  D.如果是'/', num = stack.pop() / num, 入栈
 * 4. 最后，把栈里的数相加就是结果
 */
//用一个栈就好了，不需要操作符的栈
public class Solution1 {
    public int calculate(String s) {
        Deque<Integer> deque = new LinkedList<>();
        char[] c = s.toCharArray();
        int pos = 0;
        char pre = ' ';//上一个操作符是什么
        while(pos<c.length){
            if(c[pos]==' '){
                pos++;
                continue;
            }
            if(c[pos]>='0' && c[pos]<='9'){
                int value = 0;
                //value 得到下一个操作数
                while(pos<c.length &&c[pos]>='0' && c[pos]<='9'){
                    value = value * 10 + c[pos]-'0';
                    pos++;
                }
                switch (pre){
                    case '+':
                        deque.offerLast(value);
                        break;
                    case '-':
                        deque.offerLast(-value);
                        break;
                    case '*':
                        deque.offerLast(deque.pollLast()*value);
                        break;
                    case '/':
                        deque.offerLast(deque.pollLast()/value);
                        break;
                    case ' ':
                        deque.offerLast(value);
                        break;
                }

            }else{
                pre = c[pos];
                pos++;
            }
        }
        int ans = 0;
        while(!deque.isEmpty()){
            ans += deque.pollLast();
        }
        return ans;
    }

    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.calculate("3+2*2"));
    }
}
