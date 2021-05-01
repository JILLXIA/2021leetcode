package 位运算.比特位计数338;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 0;i<result.length;i++){
            result[i] = calone(i);
        }
        return result;
    }

    public int calone(int num){
        int count = 0;
        while(num!=0){
            num  = num & (num-1);
            count++;
        }
        return count;
    }
}
