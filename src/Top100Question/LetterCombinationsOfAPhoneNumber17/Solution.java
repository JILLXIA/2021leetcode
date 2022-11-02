package Top100Question.LetterCombinationsOfAPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    List<String> result;
    StringBuilder sb;
    HashMap<Character, char[]> map;
    public List<String> letterCombinations(String digits) {

        result = new ArrayList();
        sb = new StringBuilder();
        map = new HashMap();
        if(digits.length()==0){
            return result;
        }
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        dfs(digits, 0);
        return result;
    }

    public void dfs(String digits, int index){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        char[] tmpc = map.get(c);
        for(int i = 0;i<tmpc.length;i++){
            sb.append(tmpc[i]);
            dfs(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
