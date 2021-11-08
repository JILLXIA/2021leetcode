package 每日一题.猜数字游戏299;

public class Solution1 {
	public String getHint(String secret, String guess) {
	  //代码可以简洁一点 bulls 第一次就判断出来了
		int bulls = 0,cows = 0;

		// 由于是有限的hash可以直接用数组
		int[] secretHash = new int[10];
		int[] guessHash = new int[10];
		for(int i = 0;i<secret.length();i++){
			if(secret.charAt(i)==guess.charAt(i)){
				bulls++;
			}else{
				secretHash[secret.charAt(i)-'0']++;
				guessHash[guess.charAt(i)-'0']++;
			}
		}

		for(int i = 0;i<10;i++){
			cows += Math.min(secretHash[i],guessHash[i]);
		}
		StringBuilder result = new StringBuilder();
		result.append(bulls);
		result.append('A');
		result.append(cows);
		result.append('B');
		return result.toString();
	}
}
