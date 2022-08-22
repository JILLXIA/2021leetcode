package contest.BiWeekly85.ShiftingLettersII;

public class Solution {
	public String shiftingLetters(String s, int[][] shifts) {
		int[] arr = new int[s.length()];
		for(int i = 0;i<shifts.length;i++){
			for(int j = shifts[i][0];j<=shifts[i][1];j++){
				// for循环将每一个都加上，效率十分低下
				// 构造差分数组 diff[i]是nums[i]和nums[i-1]的差
				if(shifts[i][2]==1){
					arr[j]++;
				}else {
					arr[j]--;
				}
			}
		}

		char[] result = s.toCharArray();
		for(int i = 0;i< result.length;i++){
			int offset = arr[i] % 26;
			// char changedLetter = 'a';
			if(result[i] + offset > 'z'){
				result[i] = (char) ('a' + offset - 1 - ('z' - result[i]));
			} else if(result[i] + offset < 'a'){
				result[i] = (char) ('z' + offset +1 + (result[i]-'a'));
			} else{
				result[i] = (char) (result[i] + offset);
			}
			// sb.append(changedLetter);
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.shiftingLetters("b",new int[][]{{0,0,0},{0,0,0}}));
	}
}
