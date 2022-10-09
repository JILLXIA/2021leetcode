package ByteDance.PermutationInString567;

import java.util.HashMap;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while(right < s2.length()){
            char rightc = s2.charAt(right);
            right++;
            if(map.containsKey(rightc)){
                window.put(rightc, window.getOrDefault(rightc,0)+1);
                if(window.get(rightc).equals(map.get(rightc))){
                    valid++;
                }
            }

            while(valid==map.size()){
                // 进入left优化的时候说明就找到结果了
                if(right - left==s1.length()){
                    return true;
                }
                char leftc = s2.charAt(left);
                left++;
                if(map.containsKey(leftc)){
                    if(window.get(leftc).equals(map.get(leftc))){
                        valid--;
                    }
                    window.put(leftc, window.getOrDefault(leftc,0)-1);
                }

            }
        }
        return false;
    }
}
