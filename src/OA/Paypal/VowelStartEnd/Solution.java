package OA.Paypal.VowelStartEnd;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> vowel(String[] s, String[] index){
        int[] preSum = new int[s.length+1];
        for(int i = 1;i<preSum.length;i++){
            preSum[i] = preSum[i-1] + (checkVowel(s[i-1]) ? 1: 0);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<index.length;i++){
            String[] indexRange = index[i].split("-");
            result.add(preSum[Integer.parseInt(indexRange[1])] - preSum[Integer.parseInt(indexRange[0])-1]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.vowel(new String[]{"aba", "c", "eou", "ffo"},new String[]{"1-2","2-4","4-4"}));
    }

    public boolean checkVowel(String s){
        return (s.charAt(0)=='a' || s.charAt(0)=='e'
                || s.charAt(0)=='i'|| s.charAt(0)=='o'|| s.charAt(0)=='u')
                && (s.charAt(s.length() - 1)=='a' || s.charAt(s.length() - 1)=='e'
                || s.charAt(s.length() - 1)=='i'|| s.charAt(s.length() - 1)=='o'|| s.charAt(s.length() - 1)=='u');
    }
}
