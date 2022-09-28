package Amazon.GroupAnagrams49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // anagrams 类型的题目想到排成正序的
        HashMap<String, List<String>> map = new HashMap<>();
        // 一开始的思路错了，总想count每个字母的数量，应该想到排序的
        // 每个anagram都可以用一个已经排好序的字符串来当作key判断
        for(int i = 0;i<strs.length;i++){
            char[] cArr = new char[26];
            for(int j = 0;j<strs[i].length();j++){
                cArr[strs[i].charAt(j) - 'a']++;
            }
            String newString = String.valueOf(cArr);
            if(map.containsKey(newString)){
                map.get(newString).add(strs[i]);
            } else {
                map.put(newString,new ArrayList<>());
                map.get(newString).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
