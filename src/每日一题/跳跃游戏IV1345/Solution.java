package 每日一题.跳跃游戏IV1345;

import java.util.HashMap;

/**
 * 给你一个整数数组arr，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标i跳到下标：
 *
 * i + 1满足：i + 1 < arr.length
 * i - 1满足：i - 1 >= 0
 * j满足：arr[i] == arr[j]且i != j
 * 请你返回到达数组最后一个元素的下标处所需的最少操作次数。
 *
 * 注意：任何时候你都不能跳到数组外面。
 */

/**
 * 不能用动态规划，因为具有后效性，会被后面的结果干扰
 */
public class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // 到某一下标最少的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],0);
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++){
            if(i!=n-1){
                // 不是最后一个的情况
                num1 = dp[i-1]+1;

                if(map.containsKey(arr[i+1])){
                    num3 = dp[map.get(arr[i+1])]+2;
                }
                if(map.containsKey(arr[i])){
                    num2 = dp[map.get(arr[i])]+1;
                }
                dp[i] = Math.min(num1,Math.min(num2,num3));
                if(dp[i]!=num2){
                    map.put(arr[i],i);
                }
            } else {
                num1 = dp[i-1]+1;
                if(map.containsKey(arr[i])){
                    num2 = dp[map.get(arr[i])]+1;
                }
                dp[i] = Math.min(num1,num2);
            }
            num1 = Integer.MAX_VALUE;
            num2 = Integer.MAX_VALUE;
            num3 = Integer.MAX_VALUE;
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.minJumps(new int[]{25,-28,-51,61,-74,-51,-30,58,36,68,-80,-64,25,-30,-53,36,-74,61,-100,-30,-52}));
    }
}
