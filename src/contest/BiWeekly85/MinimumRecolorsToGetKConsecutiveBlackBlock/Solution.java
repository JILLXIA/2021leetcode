package contest.BiWeekly85.MinimumRecolorsToGetKConsecutiveBlackBlock;

public class Solution {
	public int minimumRecolors(String blocks, int k) {
		int blockNum = 0;
		for(int i = 0;i<k;i++){
			if(blocks.charAt(i)=='B'){
				blockNum++;
			}
		}

		int result = k-blockNum;
		for(int i = k;i<blocks.length();i++){
			if(blocks.charAt(i)=='B'){
				blockNum++;
			}
			if(blocks.charAt(i-k)=='B'){
				blockNum--;
			}
			result = Math.min(result,k-blockNum);
		}
		return result;
	}
}
