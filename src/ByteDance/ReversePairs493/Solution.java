package ByteDance.ReversePairs493;

/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 *
 * A reverse pair is a pair (i, j) where:
 *
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 */
public class Solution {
    // 归并排序解题
    int result = 0;
    int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        sort(nums,0,nums.length - 1);

        return result;
    }

    // index
    public void sort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end){
        for(int i = start;i<=end;i++){
            tmp[i] = nums[i];
        }
        int index1 = start;
        int index2 = mid + 1;
        int index2_end = index2;
        for(int i = index1;i<=mid;i++){
            while(index2_end <= end && (long)2 * nums[index2_end] < (long)nums[i]){
                index2_end++;
            }
            result += index2_end - index2;
        }
        int curr = start;
        while(curr <= end){
            if(index1 <= mid && index2 <= end){
                if(tmp[index1] >= tmp[index2]){
                    nums[curr] = tmp[index2];
                    index2++;
                } else {
                    nums[curr] = tmp[index1];
                    index1++;
                }
            } else if(index1 <= mid){
                nums[curr] = tmp[index1];
                index1++;
            } else if(index2 <= end){
                nums[curr] = tmp[index2];
                index2++;
            }
            curr++;
        }
    }
}
