package contest.Weekly303.NumberOfExcellentPairs2354;

import java.util.HashSet;

/**
 * The Inclusion-Exclusion Principle
 * bits(num1 OR num2) + bits(num1 AND num2) = bits(num1) + bits(num2)
 *
 * For all different a in nums,
 * counts its number of bits.
 *
 * Enumearte the number of bits k1 and k2,
 * if k1 + k2 >= k,
 * we accumulate count[k1] * count[k2].
 */
public class Solution1 {
	public long countExcellentPairs(int[] nums, int k) {
		long[] count = new long[30];
		long result = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0;i<nums.length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
		} // dedup the nums

		for(int tmp:set){
			count[Integer.bitCount(tmp)]++;
		}

		for(int i = 0;i<count.length;i++){
			for(int j = 0;j<count.length;j++){
				if(i+j>=k){
					result += count[i] * count[j];
				}
			}
		}
		return result;
	}
}
