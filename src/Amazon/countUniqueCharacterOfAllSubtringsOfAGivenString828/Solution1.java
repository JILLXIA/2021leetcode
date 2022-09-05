package Amazon.countUniqueCharacterOfAllSubtringsOfAGivenString828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public int uniqueLetterString(String s) {
        // HashMap, Character=> List
        HashMap<Character,List<Integer>> map = new HashMap<Character, List<Integer>>();
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }
        int result = 0;
        for(List<Integer> list: map.values()){
            for(int i = 0;i<list.size();i++){
                int left = i==0 ? -1 : list.get(i-1);
                int right = i==list.size()-1 ? s.length() : list.get(i+1);
                result += (list.get(i)-left) * (right - list.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.uniqueLetterString("ABC");
    }
}
