package 数组.存在连续三个奇数的数组;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0;i<arr.length-2;i++){
            if(arr[i]*arr[i+1]*arr[i+2]%2!=0){
                //也可以用 (arr[i]&1)!=0 ；来判断奇偶
                return true;
            }
        }
        return false;
    }
}
