package Amazon.FlipStringToMonotoneIncreasing926;

public class Solution1 {
    public int minFlipsMonoIncr(String s) {
        // 计算任何一个点作为分界点
        // 分界点自身为0； -1～s.length()-1
        int[] leftOne = new int[s.length()];
        int[] rightZero = new int[s.length()];
        leftOne[0] = s.charAt(0) == '1' ? 1:0;
        rightZero[s.length()-1] = s.charAt(s.length()-1) == '0' ? 1:0;
        for(int i = 1,j = s.length()-2;i<s.length();i++,j--){
            leftOne[i] = s.charAt(i) == '1' ? leftOne[i-1] + 1:leftOne[i-1];
            rightZero[j] = s.charAt(j) == '0' ? rightZero[j+1] + 1:rightZero[j+1];
        }

        int result = Integer.MAX_VALUE;
        for(int k = -1;k<=s.length()-1;k++){
            // 0: [0, k], 1: [k+1, n-1]
            int left = k==-1?0:leftOne[k];
            int right = k==s.length()-1 ? 0:rightZero[k+1];
            result = Math.min(result, left + right);
        }
        return result;
    }
}
