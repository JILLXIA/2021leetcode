package Top100Question.LongestCommonPrefix14;

/**
 * Write a function to find the longest common prefix
 * string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int index = 0;
        boolean flag = true;
        while(true){
            for(int i = 0;i<strs.length - 1;i++){
                if(strs[i].length() > index && strs[i+1].length() > index && strs[i].charAt(index)==strs[i+1].charAt(index)){
                    continue;
                } else{
                    return strs[0].substring(0,index);
                }
            }
            index++;
        }
    }
}
