package Amazon.WordBreakII140;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences in any order.
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
    // need to record the failure DFS
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Trie();
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
        dfs(s,0);
        return result;
    }

    public void dfs(String s, int index){
        if(index==s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<path.size();i++){
                sb.append(path.get(i));
                if(i!=path.size()-1){
                    sb.append(' ');
                }
            }
            result.add(sb.toString());
            return;
        }
        Trie curr = root;
        for(int i = index;i<s.length();i++){
            if(curr.next[s.charAt(i)-'a']==null){
                break;
            } else {
                curr = curr.next[s.charAt(i)-'a'];
                if(curr.isEnd){
                    path.add(s.substring(index,i+1));
                    dfs(s,i+1);
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        s.wordBreak("catsanddog",list);
    }
}
