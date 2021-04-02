package 数组.有序数组的平方977;

/**
 * 双指针，一个0，一个n-1
 * 利用归并排序的思想
 */
public class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int[] ans = new int[nums.length];
        int pos = ans.length-1;
        while(i<=j && pos>=0){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                ans[pos] = nums[i] * nums[i];
                i++;
            }else{
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
