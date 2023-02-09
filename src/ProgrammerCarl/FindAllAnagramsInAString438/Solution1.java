package ProgrammerCarl.FindAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()){
            return result;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }

        int valid = 0;
        HashMap<Character, Integer> sWindow = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            if(valid==pMap.size()){
                result.add(i - p.length());
            }
            sWindow.put(s.charAt(i), sWindow.getOrDefault(s.charAt(i),0)+1);
            if(sWindow.get(s.charAt(i)).equals(pMap.get(s.charAt(i)))){
                valid++;
            }

            if(i - p.length() >= 0) {
                if (sWindow.get(s.charAt(i - p.length())).equals(pMap.get(s.charAt(i - p.length())))) {
                    valid--;
                }
                sWindow.put(s.charAt(i - p.length()), sWindow.getOrDefault(s.charAt(i - p.length()), 0) - 1);
            }
        }
        if(valid==pMap.size()){
            result.add(s.length() - p.length());
        }
        return result;
    }
}
