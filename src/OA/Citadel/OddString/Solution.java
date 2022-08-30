package OA.Citadel.OddString;

import java.util.List;

public class Solution {
    public String solve(int m, List<String> s){
        int countOdd  = 0;
        for(String s1:s){
            boolean seen = false; // 奇数
            for(char c:s1.toCharArray()){
                if((c-'a')%2!=0){ // 如果是偶数
                    seen = true;
                }
            }
            if(!seen){
                countOdd++;
            }
        }
        // 奇数个奇数相加
        if(countOdd % 2 != 0){
            return "ODD";
        }
        return "EVEN";
    }
}
