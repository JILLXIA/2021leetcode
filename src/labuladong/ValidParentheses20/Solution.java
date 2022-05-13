package labuladong.ValidParentheses20;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class Solution {
	public boolean isValid(String s) {
		// use a queue to mimic the string
		Deque<Character> deque = new LinkedList<>();
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='(' || c=='{' || c=='['){
				deque.offerLast(c);
			} else {
				char pairc = '0';
				if(!deque.isEmpty()){
					pairc = deque.pollLast();
				}
				if(c == reverseBracket(pairc)){
					continue;
				}else {
					return false;
				}
			}
		}
		return deque.isEmpty();
	}
	public Character reverseBracket(char c){
		switch (c){
			case '(':
				return ')';
			case '[':
				return ']';
			case '{':
				return '}';
		}
		return '0';
	}
}
