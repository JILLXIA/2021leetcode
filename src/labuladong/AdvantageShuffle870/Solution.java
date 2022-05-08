package labuladong.AdvantageShuffle870;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 both
 * of the same length.
 * The advantage of nums1 with respect to nums2 is the number of
 * indices i for which nums1[i] > nums2[i].
 *
 * Return any permutation of nums1 that maximizes its advantage
 * with respect to nums2.
 */
public class Solution {
	public int[] advantageCount(int[] nums1, int[] nums2) {
		Arrays.sort(nums1); // 只能升序排列
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});
		for(int i = 0;i<nums2.length;i++){
			pq.add(new int[]{i,nums2[i]});
		}
		int left = 0;
		int right = nums1.length-1;
		int[] result = new int[nums1.length]; // 重新开辟一个新数组
		while(!pq.isEmpty()){
			int[] tmp = pq.poll();
			int index = tmp[0];
			int value = tmp[1];
			if(value <= nums1[right]){
				// 比得过就比
				result[index] = nums1[right];
				right--;
			} else{
				result[index] = nums1[left];
				left++;
			}
		}
		return result;
	}
}
