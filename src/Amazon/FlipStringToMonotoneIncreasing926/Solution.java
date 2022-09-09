package Amazon.FlipStringToMonotoneIncreasing926;

/**
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 *
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 *
 * Return the minimum number of flips to make s monotone increasing.
 */
public class Solution {
    public int minFlipsMonoIncr(String s) {
        // 计算任何一个点作为分界点
        // 分界点自身为0； -1～s.length()-1
        int[] leftOne = new int[s.length()+1];
        int[] rightZero = new int[s.length()+1];
        int countOne = 0;
        for(int i = 1;i<leftOne.length;i++){
            if(s.charAt(i-1)=='1'){
                countOne++;
            }
            leftOne[i] = countOne;
        }
        int countZero = 0;
        for(int i = rightZero.length-1;i >=1;i--){
            rightZero[i] = countZero;
            if(s.charAt(i-1)=='0'){
                countZero++;
            }
        }
        rightZero[0] = countZero;

        int result = Integer.MAX_VALUE;
        for(int i = 0;i<leftOne.length;i++){
            result = Math.min(result,leftOne[i]+rightZero[i]);
        }
        return result;
    }
}
