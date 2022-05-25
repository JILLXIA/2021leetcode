package labuladong.BasicCalculator224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s representing a valid expression,
 * implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which
 * evaluates strings as mathematical expressions, such as eval().
 */
public class Solution {
	// 将问题拆解成一个个小问题
	// 1. 将字符串变成数字
	// 2. 处理加减法
	// 3. 处理乘除法
	// 4. 处理空格
	// 5. 处理括号
	public int calculate(String s) {
		return realCalculate(s,0)[0];
	}
	public int[] realCalculate(String s, int beginIndex) {
		char sign = '+';
		int num = 0;
		Deque<Integer> deque = new LinkedList<>();
		int i = beginIndex;
		for(i = beginIndex; i < s.length(); i++){
			char tmp = s.charAt(i);
			if(tmp=='('){
				int[] arr = realCalculate(s,i+1);
				num = arr[0];
				i = arr[1];
			}

			if (Character.isDigit(tmp)) {
				// 如果遍历到的是数字，则需要将数字累加起来
				num = num * 10 + (tmp - '0');
			}
			if ((!Character.isDigit(tmp) && tmp !=' ') || i == s.length() - 1) {
				// 如果遇到的是字母则需要将前一个数字入栈
				switch (sign) {
					case '+':
						deque.offerLast(num);
						break;
					case '-':
						deque.offerLast(-num);
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
				// 先放到栈里面再弹出
				break;
			}
		}
//		}

		int result = 0;
		while(!deque.isEmpty()){
			result += deque.pollFirst();
		}
		return new int[]{result, i};
	}
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.calculate("(3)+1"));
	}
}
// "(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"