package Google.LongestStringChain1048;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can
 * insert exactly one letter anywhere in wordA without changing
 * the order of the other characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 */
public class Solution {
    public int longestStrChain(String[] words) {
        List<String>[] list = new List[17];
        HashMap<String, Integer> map = new HashMap<>();// string to -> longest chain

        for(int i = 0;i<words.length;i++){
            map.put(words[i],1);
            int length = words[i].length();
            if(list[length]==null){
                list[length] = new ArrayList<>();
            }
            list[length].add(words[i]);
        }
        int result = 0;

        for(int i = 1;i<list.length;i++){
            if(list[i]==null){
                continue;
            }
            for(int j = 0;j<list[i].size();j++){
                int preLength = i - 1;
                if(list[preLength]==null){
                    break;
                }
                for(int k = 0;k<list[preLength].size();k++){
                    if(isPre(list[preLength].get(k),list[i].get(j))){
                        map.put(list[i].get(j),Math.max(map.get(list[i].get(j)),map.get(list[preLength].get(k))+1));
                        result = Math.max(result,map.get(list[i].get(j)));
                    }
                }
            }
        }
        return result;
    }

    public boolean isPre(String s1, String s2){
        int pointer1 = 0;
        int pointer2 = 0;
        boolean isDiff = false;
        while(pointer1 < s1.length() && pointer2 < s2.length()){
            if(s1.charAt(pointer1)==s2.charAt(pointer2)){
                pointer1++;
                pointer2++;
            } else {
                if(isDiff){
                    return false;
                }
                isDiff = true;
                pointer2++;
            }
        }
        return true;
    }
}
