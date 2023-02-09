package ProgrammerCarl.FindAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and p,
 * return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }

        int valid = 0;
        HashMap<Character, Integer> sWindow = new HashMap<>();

        for(int i = 0;i < p.length();i++){
            sWindow.put(s.charAt(i), sWindow.getOrDefault(s.charAt(i),0)+1);
            if(sWindow.get(s.charAt(i)).equals(pMap.get(s.charAt(i)))){
                valid++;
            }
        }

        for(int i = p.length();i < s.length();i++){
            if(valid==pMap.size()){
                result.add(i - p.length());
            }
            sWindow.put(s.charAt(i), sWindow.getOrDefault(s.charAt(i),0)+1);
            if(sWindow.get(s.charAt(i)).equals(pMap.get(s.charAt(i)))){
                valid++;
            }
            if(sWindow.get(s.charAt(i-p.length())).equals(pMap.get(s.charAt(i-p.length())))){
                valid--;
            }
            sWindow.put(s.charAt(i-p.length()), sWindow.getOrDefault(s.charAt(i-p.length()),0)-1);

        }
        if(valid==pMap.size()){
            result.add(s.length() - p.length());
        }
        return result;

    }
}
