package Google.FindAndReplaceInString833;

import java.util.HashMap;

public class Solution1 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>(); // indices[i] -> i
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<indices.length;i++){
            if(s.substring(indices[i],Math.min(indices[i] + sources[i].length(),s.length())).equals(sources[i])){
                map.put(indices[i],i);
            }
        }

        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(i)){
                sb.append(s.charAt(i));
            } else {
                sb.append(targets[map.get(i)]);
                i = i + sources[map.get(i)].length()-1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.findReplaceString("abcd",new int[]{0,2},new String[]{"a","cd"}, new String[]{"eee","ffff"});
    }
}
