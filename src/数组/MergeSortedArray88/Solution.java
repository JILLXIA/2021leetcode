package 数组.MergeSortedArray88;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class Solution {
    // 反向排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // log(m+n) 的方法
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        for(int i = nums1.length-1;i>=0;i--){
            if(pointer2 < 0){
                break;
            }

            if(pointer1 < 0){
                nums1[i] = nums2[pointer2];
                pointer2--;
            } else {
                if(nums1[pointer1] <= nums2[pointer2]){
                    nums1[i] = nums2[pointer2];
                    pointer2--;
                } else{
                    nums1[i] = nums1[pointer1];
                    pointer1--;
                }
            }
        }
    }
}
