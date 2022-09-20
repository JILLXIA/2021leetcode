package Amazon.WordBreak139;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused
 * multiple times in the segmentation.
 */
public class Solution {
    class Trie{
        Trie[] next;
        boolean isEnd;
        public Trie(){
            next = new Trie[26];
            isEnd = false;
        }
    }
    Trie root;
    int[] memo;
    // need to record the failure DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        memo = new int[301];
        for(int i = 0;i<wordDict.size();i++){
            Trie curr = root;
            for(int j = 0;j<wordDict.get(i).length();j++){
                if(curr.next[wordDict.get(i).charAt(j)-'a']==null){
                    curr.next[wordDict.get(i).charAt(j)-'a'] = new Trie();
                }
                curr = curr.next[wordDict.get(i).charAt(j)-'a'];
            }
            curr.isEnd = true;
        }
        return dfs(s,0);
    }

    public boolean dfs(String s, int index){
        if(index==s.length()){
            return true;
        }
        if(memo[index]==1){
            return false;
        }
        Trie curr = root;
        for(int i = index;i<s.length();i++){
            if(curr.next[s.charAt(i)-'a']==null){
                break;
            } else {
                curr = curr.next[s.charAt(i)-'a'];
                if(curr.isEnd && dfs(s,i+1)){
                    return true;
                }
            }
        }
        memo[index] = 1;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("go");
        list.add("goal");
        list.add("goals");
        list.add("special");
        System.out.println(s.wordBreak("goalspecial",list));
    }
}
