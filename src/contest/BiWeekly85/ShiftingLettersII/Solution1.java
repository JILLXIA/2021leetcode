package contest.BiWeekly85.ShiftingLettersII;

public class Solution1 {
	public String shiftingLetters(String s, int[][] shifts) {
		// set up diff metrix
		int[] diff = new int[s.length()];
		for(int i = 0;i<shifts.length;i++){
			int value = shifts[i][2]==1 ? 1 : -1;
			diff[shifts[i][0]] += value;
			if(shifts[i][1]+1 < s.length()){
				diff[shifts[i][1]+1] -= value;
			}
		}

		char[] cArray = s.toCharArray();
		int offset = 0;
		for(int i = 0;i<cArray.length;i++){
			offset += diff[i];
			int newchar = (cArray[i] - 'a' + offset) % 26; // 先变成字母index再进行计算
			if(newchar < 0){
				newchar += 26;
			}
			cArray[i] = (char) (newchar + 'a');
		}
		return String.valueOf(cArray);
	}
}
