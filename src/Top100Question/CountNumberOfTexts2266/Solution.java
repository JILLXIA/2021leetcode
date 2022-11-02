package Top100Question.CountNumberOfTexts2266;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Alice is texting Bob using her phone.
 * The mapping of digits to letters is shown in the figure below.
 */
public class Solution {
    // HashMap
    // 1,2,3,4
    // memo
    HashMap<Character, Integer> map = new HashMap(); // Character To Count
    public int countTexts(String pressedKeys) {
        map.put('2',3);
        map.put('3',3);
        map.put('4',3);
        map.put('5',3);
        map.put('6',3);
        map.put('7',4);
        map.put('8',3);
        map.put('9',4);
        int[] memo = new int[pressedKeys.length()];
        Arrays.fill(memo,-1);
        return dfs(pressedKeys, 0,memo);
    }

    public int dfs(String s, int index, int[] memo){
        if(index >= s.length()){
            return 1;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int result = 0;
        int count = map.get(s.charAt(index));

        for(int i = 0;i<count;i++){
            if(index + i < s.length() && s.charAt(index+i)==s.charAt(index)){
                result = (result + dfs(s, index + i+1,memo)) % 1000000007;
            } else {
                break;
            }
        }
        memo[index] = result;
        return result;
    }
}
