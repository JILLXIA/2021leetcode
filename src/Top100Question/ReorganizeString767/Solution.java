package Top100Question.ReorganizeString767;

/**
 * Given a string s, rearrange the characters of s
 * so that any two adjacent characters are not the same.
 *
 * Return any possible rearrangement of s or return "" if not possible.
 */
public class Solution {
    public String reorganizeString(String s) {
        // 思考在什么情况下是找不到的 如果出现最多的字符的频率大于 s.length()+1 / 2就找不到
        int[] hash = new int[26];
        // 1. 统计每个出现的频率
        for(int i = 0;i < s.length();i++){
            hash[s.charAt(i) - 'a']++;
        }

        // 2. 找到出现次数组最多的，判断频率是否大于s.length()+1 / 2
        int letter = 0;
        int maxCount = 0;
        for(int i = 0;i<hash.length;i++){
            if(hash[i] > maxCount){
                maxCount = hash[i];
                letter = i;
            }
        }
        // 3. 从出现次数最多的开始插，先插偶数下标，插完了再插奇数下标
        if(maxCount > (s.length() + 1) / 2){
            return "";
        }

        int idx = 0;
        char[] result = new char[s.length()];
        while(maxCount > 0){
            result[idx] = (char)(letter + 'a');
            idx = idx + 2;
            maxCount--;
        }

        for(int i = 0;i<hash.length;i++){
            if(i==letter){
                continue;
            }
            int count = hash[i];
            while(count > 0){
                if(idx >= s.length()){
                    idx = 1;
                }
                result[idx] = (char)(i + 'a');
                idx = idx + 2;
                count--;
            }
        }
        return String.valueOf(result);
    }
}
