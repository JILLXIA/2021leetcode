package ProgrammerCarl.HappyNumber202;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */

// 如果题目中 可能出现死循环，那么用set记录是一个很好的选择
public class Solution {
    public boolean isHappy(int n) {
        // use a hashset to record the repeated sum
        HashSet<Integer> set = new HashSet<>();
        int n_optimize = n;
        while(true){
            int curr = n_optimize;
            int sum = 0;
            while(curr != 0){
                sum += (curr % 10) * (curr % 10);
                curr = curr / 10;
            }
            if(sum == 1){
                return true;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n_optimize = sum;
        }
    }
}
