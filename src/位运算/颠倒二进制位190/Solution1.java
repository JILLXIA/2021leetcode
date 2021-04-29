package 位运算.颠倒二进制位190;

public class Solution1 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //输入的就是二进制的形式，每次取最后一位
        int result = 0;
        int i = 0;
        while(i<32){
            int tmp = n & 1;//取最后一位
            result = result | (tmp<<31-i);//反转到前面
            n = n>>>1;
            i++;
        }
        return result;
    }
}
