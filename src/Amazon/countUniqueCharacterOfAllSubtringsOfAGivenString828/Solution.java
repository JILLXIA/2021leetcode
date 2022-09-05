package Amazon.countUniqueCharacterOfAllSubtringsOfAGivenString828;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int uniqueLetterString(String s) {
        int[] pre = new int[s.length()];
        int[] next = new int[s.length()];
        // s.charAt(i) => index
        HashMap<Character, Integer> map = new HashMap<>();

        // pre
        Arrays.fill(pre,-1);
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                pre[i] = map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i);
        }
        map.clear();
        // next
        Arrays.fill(next,s.length());
        for(int i = s.length()-1;i>=0;i--){
            if(map.containsKey(s.charAt(i))){
                next[i] = map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i);
        }

        int result = 0;
        for(int i = 0;i<s.length();i++){
            result += (i-pre[i]) * (next[i] - i);
        }
        return result;
    }
}
