package 数组.删除最短的子数组使剩余数组有序1574;

/**
 * 给你一个整数数组 arr，请你删除一个子数组（可以为空），
 * 使得 arr中剩下的元素是 非递减 的。
 * 一个子数组指的是原数组中连续的一个子序列。
 * 请你返回满足题目要求的最短子数组的长度。
 */

/**
 * 可能选择：
 * 移除数组覆盖左边
 * 移除数组覆盖右边
 * 移除数组在中间
 *
 * 而这种解法没有考虑到移除的数组在右边的情况
 * 所以应该先确定两端有序区间，然后再试着合并2端的有序区间
 */
public class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int lowMax = Integer.MIN_VALUE;
        int highMin = Integer.MAX_VALUE;

        while(low<=high){
            if(low==high){
                return 1;
            }
            if(arr[low]<=highMin && arr[low]<=arr[low+1]){
                lowMax = arr[low];
                low++;
            }else if(arr[high]>=lowMax && arr[high]>=arr[high-1]){
                highMin = arr[high];
                high--;
            }else{
                if(high-low==arr.length-1)
                    return high-low;
                else{
                    return high-low+1;
                }
            }
        }
        return 0;
    }
}
