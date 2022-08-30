package contest.Weekly308.RemovingStarsFromAString;

public class Solution {
	public String removeStars(String s) {
		StringBuilder sb = new StringBuilder();
		int countStar = 0;
		for(int i = s.length()-1;i>=0;i--){
			if(s.charAt(i)=='*'){
				countStar++;
			} else{
				if(countStar==0){
					sb.insert(0,s.charAt(i));
				} else {
					countStar--;
				}
			}
		}
		return sb.toString();
	}
}
