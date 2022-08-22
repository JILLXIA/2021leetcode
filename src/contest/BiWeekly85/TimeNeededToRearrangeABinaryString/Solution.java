package contest.BiWeekly85.TimeNeededToRearrangeABinaryString;

public class Solution {
	public int secondsToRemoveOccurrences(String s) {
		// 找第一个0后面有几个1
		int index = 0;
		int result = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i)=='0'){
				index = i;
				break;
			}
		}

		int countZero = 0;
		for(int i = index;i<s.length();i++){
			if(s.charAt(i)=='1'){
				result++;
				if(countZero > 0){
					result += countZero-1;
				}
				countZero = 0;
			} else {
				countZero++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.secondsToRemoveOccurrences("11100"));
	}
}
