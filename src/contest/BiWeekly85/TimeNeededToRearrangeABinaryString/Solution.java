package contest.BiWeekly85.TimeNeededToRearrangeABinaryString;

public class Solution {
	public int secondsToRemoveOccurrences(String s) {
		char[] cArray = s.toCharArray();

		int result = 0;
		boolean isExist = false;
		while(true){
			for(int i = 1;i<cArray.length;i++){
				if(cArray[i]=='1' && cArray[i-1]=='0'){
					isExist = true;
					char tmp = cArray[i-1];
					cArray[i-1] = cArray[i];
					cArray[i] = tmp;
					i++;
				}
			}
			if(!isExist){
				break;
			}
			result++;
			isExist = false;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.secondsToRemoveOccurrences("0110101"));
	}
}
