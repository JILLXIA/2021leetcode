package Amazon.SearchSuggestionsSystem1268;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an array of strings products and a string searchWord.
 *
 * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 */
public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(3, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });
        List<List<String>> result = new ArrayList<>();

        for(int i = 0;i<searchWord.length();i++){
            for(int j = 0;j<products.length;j++){
                if(products[j].startsWith(searchWord.substring(0,i+1))){
                    pq.add(products[j]);
                }
            }

            List<String> tmp = new ArrayList<>();
            while(!pq.isEmpty()){
                if(tmp.size() >=3){
                    break;
                }
                tmp.add(pq.poll());
            }
            pq.clear();
            result.add(tmp);
        }
        return result;
    }
}
