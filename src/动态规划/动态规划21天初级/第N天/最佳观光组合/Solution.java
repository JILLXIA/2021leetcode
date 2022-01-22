package 动态规划.动态规划21天初级.第N天.最佳观光组合;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        int num1 = values[0]+0;
        for(int i = 1;i< values.length;i++){
            result = Math.max(result,num1+values[i]-i);
            num1 = Math.max(num1,values[i]+i);
        }
        return result;
    }
}
