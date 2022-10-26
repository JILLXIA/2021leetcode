package Top100Question.RomanToInteger13;

import java.util.HashMap;

public class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int result = 0;
        int index = 0;
        while(index < s.length()){
            if(index < s.length()-1){
                String twostring = s.substring(index,index + 2);
                if(map.containsKey(twostring)){
                    result += map.get(twostring);
                    index = index + 2;
                    continue;
                }
            }
            result += map.get(s.substring(index,index + 1));
            index = index + 1;

        }
        return result;
    }
}
