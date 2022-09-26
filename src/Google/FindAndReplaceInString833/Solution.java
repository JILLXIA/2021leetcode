package Google.FindAndReplaceInString833;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
 *
 * To complete the ith replacement operation:
 *
 * Check if the substring sources[i] occurs at index indices[i] in the original string s.
 * If it does not occur, do nothing.
 * Otherwise if it does occur, replace that substring with targets[i].
 * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
 *
 * All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
 *
 * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
 * Return the resulting string after performing all replacement operations on s.
 *
 * A substring is a contiguous sequence of characters in a string.
 */
public class Solution {
    class Item {
        int indice;
        String source;
        String target;
        public Item(int indice, String source, String target){
            this.indice = indice;
            this.source = source;
            this.target = target;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Item[] list = new Item[indices.length];
        for(int i = 0;i<list.length;i++){
            list[i] = new Item(indices[i],sources[i],targets[i]);
        }
        // 需要排序 所以时间复杂度是O(nlogn)
        // 用HashMap存需要改变的indices
        Arrays.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.indice - o2.indice;
            }
        });
        int index = 0;
        for(int i = 0;i<s.length();i++){
            if(index >= list.length){
                sb.append(s.charAt(i));
            } else {
                if(i != list[index].indice){
                    sb.append(s.charAt(i));
                } else {
                    if(list[index].source.equals(s.substring(i,Math.min(i+list[index].source.length(),s.length())))){
                        sb.append(list[index].target);
                        i = i + list[index].source.length() - 1;
                    } else {
                        sb.append(s.charAt(i));
                    }
                    index++;
                }
            }
        }
        return sb.toString();
    }
}
