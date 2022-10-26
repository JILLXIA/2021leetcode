package Top100Question.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;

/**
 * Given a string s,
 * find the length of the longest substring without repeating characters.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 1;
        while(right < s.length()){
            char tmpRight = s.charAt(right);
            right++;

            map.put(tmpRight,map.getOrDefault(tmpRight,0)+1);

            while(map.get(tmpRight) > 1){
                char tmpLeft = s.charAt(left);
                left++;
                map.put(tmpLeft, map.get(tmpLeft) - 1);
            }
            if(right - left > result){
                result = right - left;
            }
        }
        return result;
    }
}
