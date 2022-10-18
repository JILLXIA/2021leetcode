package OA.Paypal.OneFirstShowCharacter;

import java.util.HashMap;

public class Solution {
    public int findFirstShowIndex(String s){
        // all lowercase
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findFirstShowIndex("statistics"));
    }
}
