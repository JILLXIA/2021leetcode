package OA.Amazon.RearrangeSToT;

public class Solution {
    public int rearrangeSToT(String s, String t){
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i = 0;i<s.length();i++){
            sArr[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<t.length();i++){
            tArr[t.charAt(i)-'a']++;
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0;i<tArr.length;i++){
            if(tArr[i]!=0){
                result = Math.min(result, sArr[i]/tArr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rearrangeSToT("mmmm","mm"));
    }
}
