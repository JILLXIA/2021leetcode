package contest.Weekly304.MaximumNumberOfGroupsEnteringACompetition;

import java.util.Arrays;

public class Solution {
	public int maximumGroups(int[] grades) {
		int result = 0;
		int left = 0;
		int right = 0;
		int countPre = 0;
		int sum  = 0;
		int sumPre  = 0;
		Arrays.sort(grades);
		while(right < grades.length){
			while(right < grades.length
					&& (right - left <= countPre
			|| sum <= sumPre)){
				sum += grades[right];
				right++;
			}
			if(countPre < right - left && sumPre < sum){
				result++;
			}
			countPre = right-left;
			sumPre = sum;
			sum = 0;
			left = right;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.maximumGroups(new int[]{10,6,12,7,3,5}));
	}
}
