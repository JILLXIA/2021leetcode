package 每日一题.找到字符串中所有字母异位词438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *给定两个字符串s和 p，找到s中所有p的异位词的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */

public class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return result;
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];

        for(int i = 0;i<p.length();i++){
            sArr[p.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }

        // 数组有现成的APi比较方法
        if(Arrays.equals(sArr,pArr)){
            result.add(0);
        }

        for(int i = 0;i<s.length()-p.length();i++){
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i+p.length()) - 'a']++;
            if(pArr[s.charAt(i+p.length()) - 'a']==0){
                continue;
            } else if(Arrays.equals(sArr,pArr)){
                result.add(i+1);
            }
        }
        return result;
    }


}
