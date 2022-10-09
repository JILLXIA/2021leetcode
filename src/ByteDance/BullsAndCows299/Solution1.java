package ByteDance.BullsAndCows299;

public class Solution1 {
    public String getHint(String secret, String guess) {
        // 用数组来标记是否访问过
        // bulls 和 cows 完全分开计算
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10]; // 相当于一个hashmap标记数组中每个元素出现的次数
        for(int i = 0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                continue;
            }
            if(nums[secret.charAt(i) - '0'] < 0){
                cows++;
            }
            if(nums[guess.charAt(i) - '0'] > 0){
                cows++;
            }
            nums[secret.charAt(i) - '0']++;
            nums[guess.charAt(i) - '0']--;
        }
        return bulls+"A"+cows+"B";
    }
}
