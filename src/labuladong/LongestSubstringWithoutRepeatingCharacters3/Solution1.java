package labuladong.LongestSubstringWithoutRepeatingCharacters3;

public class Solution1 {
	public int lengthOfLongestSubstring(String s) {
		// 判断是否有相同的字符得想到数组，hashMap反而会变慢
		int left = 0;
		int right = 0;
		int result = 0;
		int[] arr = new int[200];
		while(right < s.length()){
			char rightc = s.charAt(right);
			right++;
			arr[rightc]++;
			while(arr[rightc] > 1){
				char leftc = s.charAt(left);
				left++;
				arr[leftc]--;
			}
			result = Math.max(right-left,result);
		}
		return result;
	}
}
