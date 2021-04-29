package 位运算.位1的个数191;

public class Solution1 {
    public int hammingWeight(int n) {
        //n&n-1的结果可以消除最低位的1

        int count = 0;
        while(n!=0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
