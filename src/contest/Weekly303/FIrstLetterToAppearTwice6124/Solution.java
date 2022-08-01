package contest.Weekly303.FIrstLetterToAppearTwice6124;

public class Solution {
	public char repeatedCharacter(String s) {
		int[] arr = new int[26];
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if(arr[c-'a']==0){
				arr[c-'a']++;
			} else if(arr[c-'a']==1){
				return c;
			}
		}
		return 'a';
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.repeatedCharacter("abccbaacz"));
	}
}
