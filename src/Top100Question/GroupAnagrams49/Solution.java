package Top100Question.GroupAnagrams49;

import java.util.ArrayList;
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
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            char[] arr = new char[26];
            for(int j = 0;j<strs[i].length();j++){
                arr[strs[i].charAt(j)-'a']++;
            }
            String key = String.valueOf(arr);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            } else {
                map.put(key,new ArrayList());
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
