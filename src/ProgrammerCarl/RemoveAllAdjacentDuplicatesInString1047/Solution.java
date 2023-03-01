package ProgrammerCarl.RemoveAllAdjacentDuplicatesInString1047;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters
 * and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 */
public class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(!deque.isEmpty() && s.charAt(i) == deque.peekLast()){
                deque.pollLast();
            } else {
                deque.offerLast(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
