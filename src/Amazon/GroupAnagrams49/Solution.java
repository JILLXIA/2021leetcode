package Amazon.GroupAnagrams49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging
 * the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // anagrams 类型的题目想到排成正序的
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0;i<strs.length;i++){
            char[] cArr = strs[i].toCharArray();
            Arrays.sort(cArr);
            String newString = String.valueOf(cArr);
            if(map.containsKey(newString)){
                map.get(newString).add(strs[i]);
            } else {
                map.put(newString,new ArrayList<>());
                map.get(newString).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String s:map.keySet()){
            result.add(map.get(s));
        }
        return new ArrayList<>(map.values());
    }
}
