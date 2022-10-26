package Top100Question.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mapNextIndex = new HashMap<>();
        int j = 0;
        int result = 0;
        for(int i = 0;i<s.length();i++){
            if(mapNextIndex.containsKey(s.charAt(i))){
                j = Math.max(mapNextIndex.get(s.charAt(i)),j);
            }
            mapNextIndex.put(s.charAt(i),i+1);
            result = Math.max(result, i - j+1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.lengthOfLongestSubstring("abba"));
    }
}
