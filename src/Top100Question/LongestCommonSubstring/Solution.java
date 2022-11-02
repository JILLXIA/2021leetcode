package Top100Question.LongestCommonSubstring;

public class Solution {
    public int longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int result = 0;
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                } else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubstring("GeeksforGeeksQu","GeeksQuiz"));
    }
}
