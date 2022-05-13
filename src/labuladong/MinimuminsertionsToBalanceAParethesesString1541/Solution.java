package labuladong.MinimuminsertionsToBalanceAParethesesString1541;

/**
 * Given a parentheses string s containing only the characters
 * '(' and ')'. A parentheses string is balanced if:
 *
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
 *
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 *
 * Return the minimum number of insertions needed to make s balanced.
 */
public class Solution {
	public int minInsertions(String s) {
		int count = 0;
		int result = 0;
		int index = 0;
		while(index < s.length()){
			if(s.charAt(index) == '('){
				count += 1;
			} else {
				if(index + 1 < s.length() && s.charAt(index + 1)==')'){
					index++;
					count--;
				} else {
					result++;
					count--;
				}
			}

			if(count < 0){
				result -= count;
				count = 0;
			}
			index++;
		}
		return result + count * 2;
	}
}
