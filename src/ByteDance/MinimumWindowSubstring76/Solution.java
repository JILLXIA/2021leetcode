package ByteDance.MinimumWindowSubstring76;

import java.util.HashMap;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t
 * (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }

        HashMap<Character, Integer> window = new HashMap<>(); // 只存t中有的字符的数据
        int left = 0;
        int right = 0;
        int valid = 0;// 找substring是否包含所有字符
        int len = Integer.MAX_VALUE;
        int start = 0;
        while(right < s.length()){
            char rightc = s.charAt(right);
            right++;
            if(need.containsKey(rightc)){
                window.put(rightc, window.getOrDefault(rightc,0)+1);
                if((window.get(rightc).equals(need.get(rightc)))){
                    valid++;
                }
            }

            while(left < s.length() && valid==need.size()){
                // 找到了存在的解，下一步找最优解
                char leftc = s.charAt(left);
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                left++;
                if(need.containsKey(leftc)){
                    if((window.get(leftc).equals(need.get(leftc)))){
                        valid--; // 如果刚好相等 left滑走之后就不相等了
                    }
                    window.put(leftc, window.getOrDefault(leftc,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
