package Amazon.SearchSuggestionsSystem1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // add the products into Trie Tree
        // set up an Trie Node
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        for(int i = 0;i<products.length;i++){
            for(int j = 0;j<products[i].length();j++){
                if(curr.trieMap[products[i].charAt(j)-'a']==null){
                    curr.trieMap[products[i].charAt(j)-'a'] = new TrieNode();
                }
                curr = curr.trieMap[products[i].charAt(j)-'a'];
                if(curr.list.size()<3){
                    curr.list.add(products[i]);
                }
            }
            curr = root;
        }
        curr = root;
        List<List<String>> result = new ArrayList<>();
        for(int i = 0;i<searchWord.length();i++){
            if(curr.trieMap[searchWord.charAt(i)-'a']==null){
                for(int j = i;j<searchWord.length();j++){
                    result.add(new ArrayList<>());
                }
                break;
            }
            curr = curr.trieMap[searchWord.charAt(i)-'a'];
            result.add(curr.list);
        }
        return result;
    }
}

// implement Trie Tree
class TrieNode{
    boolean isEnd;
    TrieNode[] trieMap = new TrieNode[26];
    List<String> list = new ArrayList<>();// 满足当前节点条件的string
    // HashMap<Character, TrieNode> map; // 子节点，每次只会找其中的一个
}
