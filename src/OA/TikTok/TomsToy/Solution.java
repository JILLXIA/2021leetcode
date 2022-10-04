package OA.TikTok.TomsToy;

import java.util.Arrays;

public class Solution {
    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGCD(b, a % b);
    }

    public String tt(int[] arr){
        Arrays.sort(arr);
        int tmp = Integer.MAX_VALUE;
        for(int i= 0;i<arr.length-1;i++){
            tmp = Math.min(tmp, getGCD(arr[0],arr[1]));
        }
        StringBuilder sb = new StringBuilder();
        int num1 = arr[0]/tmp;
        int num2 = arr[1]/tmp;
        sb.append(num2);
        sb.append('/');
        sb.append(num1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tt(new int[]{1250,200,32}));
    }
}
