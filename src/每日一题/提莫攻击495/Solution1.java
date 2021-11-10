package 每日一题.提莫攻击495;

public class Solution1 {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int right = timeSeries[0];
		int result = 0;

		for(int i = 1;i<timeSeries.length;i++){
				if(right + duration >= timeSeries[i]){
					result += timeSeries[i] - timeSeries[i-1];
				} else {
					result += duration;
				}
			right = timeSeries[i];
		}
		return result + duration;
	}
}
