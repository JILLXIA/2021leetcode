package contest.WeeklyContest307.LargestPalindromicNumber;

public class Solution {
	public String largestPalindromic(String num) {
		int[] arr = new int[10];
		for(int i = 0;i<num.length();i++){
			arr[num.charAt(i)-'0']++;
		}
		StringBuilder front = new StringBuilder();
		StringBuilder back = new StringBuilder();
		boolean isCenter = false;
		for(int i = 9;i>=0;i--){
			int count = arr[i] / 2;
			int center = arr[i] % 2;
			for(int j = 0;j<count;j++){
				if(i==0 && front.length()==0){
					break;
				}
				front.append(i);
				if(isCenter){
					back.insert(1,i);
				}else{
					back.insert(0,i);
				}
			}
			if(center==1 && !isCenter){
				back.insert(0,i);
				isCenter=true;
			}
		}
		if(front.append(back).toString().equals("")){
			return "0";
		}
		return front.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.largestPalindromic("0000"));
	}
}
