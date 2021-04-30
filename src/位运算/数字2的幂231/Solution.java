package 位运算.数字2的幂231;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 2的幂的二进制中只有一个1，这题本质上是求1的数量
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0||n<0){
            return false;
        }
        else if((n&(n-1))==0){
            return true;
        }else{
            return false;
        }
    }
}
