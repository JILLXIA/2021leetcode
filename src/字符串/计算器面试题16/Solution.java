package 字符串.计算器面试题16;

import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 *
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 */

/**
 * 如果下一个操作符比栈顶操作符的优先级高，就先弹出来计算
 */
public class Solution {
    public int calculate(String s) {
        s = s.replace(" ","");
        char[] c = s.toCharArray();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int pos = 0;
        int tempNum = 0;
        while(pos<c.length){
            if(c[pos] <= '9' && c[pos] >= '0') {
                while (pos<c.length && c[pos] <= '9' && c[pos] >= '0') {
                    tempNum = tempNum * 10 + c[pos]-'0';
                    pos++;
                }
                stack1.push(tempNum);
                tempNum = 0;
            }else{
                while(!stack2.isEmpty() && isPriority(stack2,c[pos])){
                    //弹出来计算
                    int tempResult = cal(stack1,stack2.pop());
                    stack1.push(tempResult);
                }
                stack2.push(c[pos]);

                pos++;
            }

        }

        while(!stack2.isEmpty()){
            int val = cal(stack1,stack2.pop());
            stack1.push(val);
        }
        return stack1.peek();
    }

    public static int cal(Stack<Integer> s,char c){
        int num1 = s.pop();
        int num2 = s.pop();
        int result = 0;
        switch (c){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }

    public static boolean isPriority(Stack<Character> s,char opor){
        if((s.peek()=='+'||s.peek()=='-') && (opor == '*'||opor == '/')){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
