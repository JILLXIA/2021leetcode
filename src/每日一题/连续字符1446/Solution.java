package 每日一题.连续字符1446;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 */
public class Solution {
    public int maxPower(String s) {
        int[] result = new int[s.length()];
        int max = 0;
        result[0] = 1;
        for(int i = 1;i<s.length();i++){
            result[i]  = s.charAt(i-1) == s.charAt(i) ? result[i-1]+1 : 1;
            max = Math.max(result[i],max);
        }
        return max;
    }
}
