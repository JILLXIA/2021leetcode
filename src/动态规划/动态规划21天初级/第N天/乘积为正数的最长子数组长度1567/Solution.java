package 动态规划.动态规划21天初级.第N天.乘积为正数的最长子数组长度1567;

/**
 * 给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
 *
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 *
 * 请你返回乘积为正数的最长子数组长度。
 */
public class Solution {
    /**
     * 我们考虑使用两个变量 posti 和 negati
     * 来分别表示当前数字 nums[i] 之前乘积为正数的序列长度，
     * 以及其之前 乘积为负数的序列长度。
     * @param nums
     * @return
     */
    public int getMaxLen(int[] nums) {
        int posti = 0;
        int negati = 0;
        int result = 0;
        // 以 i 为终点，看之前的长度；分类讨论
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                posti = 0;
                negati = 0;
            } else if(nums[i]>0){
                posti = posti +1;
                negati = negati > 0 ? negati +1 : 0;
            } else {
                if(posti==0 && negati==0){
                    negati = 1;
                } else if(posti == 0 && negati > 0){
                    posti = negati + 1;
                    negati = 1;
                } else if(posti > 0 && negati == 0){
                    negati = posti + 1;
                    posti = 0;
                } else if(posti > 0 && negati > 0) {
                    int tmp = negati + 1;
                    negati = posti +1;
                    posti = tmp;
                }
            }
            result = Math.max(result,posti);
        }
        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.getMaxLen(new int[]{0,1,-2,-3,-4}));
    }
}
