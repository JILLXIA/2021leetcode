package OA.TikTok.LongestStringChain1048;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 */
public class Solution {
    class Item{
        String s;
        int length;

        public Item(String s, int length){
            this.s = s;
            this.length = length;
        }
    }
    public int longestStrChain(String[] words) {
        HashMap<Integer, List<Item>> map = new HashMap<Integer, List<Item>>();
        for(String word:words){
            int wordLength = word.length();
            if(!map.containsKey(wordLength)){
                map.put(wordLength,new ArrayList<>());
            }
            map.get(wordLength).add(new Item(word,1));
        }
        int result = 1;

        for(int i = 1;i<=16;i++){
            if(!map.containsKey(i)){
                continue;
            }
            if(!map.containsKey(i-1)){
                continue;
            }
            List<Item> currList = map.get(i);
            List<Item> preList = map.get(i-1);

            for(Item curr: currList){
                int refreshLength = curr.length;
                for(Item pre: preList){
                    if(checkPredecesor(pre.s,curr.s)){
                        refreshLength = Math.max(refreshLength,pre.length+1);
                    }
                }
                curr.length = refreshLength;
                result = Math.max(result, refreshLength);
            }
        }
        return result;
    }

    public boolean checkPredecesor(String s1, String s2){
        boolean flag = false;
        int index1 = 0;
        int index2 = 0;
        while(index1 < s1.length()){
            if(s1.charAt(index1)==s2.charAt(index2)){
                index1++;
                index2++;
            } else {
                if(flag){
                    return false;
                }
                flag = true;
                index2++;
            }
        }
        return true;
    }
}
