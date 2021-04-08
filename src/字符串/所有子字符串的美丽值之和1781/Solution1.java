package 字符串.所有子字符串的美丽值之和1781;

public class Solution1 {
    public int beautySum(String s) {
        if(s.length()<=2){
            return 0;
        }else{
            int result = 0;
            char[] c = s.toCharArray();
            for(int i = 0;i<s.length()-2;i++) {
                int[] charNum = new int[26];
                charNum[c[i]-'a']++;
                charNum[c[i+1]-'a']++;
                for (int j = i + 2; j < s.length(); j++) {
                    charNum[c[j]-'a']++;

                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;
                    for(int k = 0;k<26;k++){
                        if(charNum[k]>0){//考虑 aaaaa 这种美丽值应该为0的情况
                            min = Math.min(min,charNum[k]);
                            max = Math.max(max,charNum[k]);
                        }
                    }
                    result += (max - min);
                }
            }
            return result;
        }
    }
}
