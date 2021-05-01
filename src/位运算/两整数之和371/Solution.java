package 位运算.两整数之和371;

/**
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 */
public class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carr = 0;
        int tmpa  = 0;
        int tmpb  = 0;
        for(int i = 0;i<32;i++){
            tmpa = a & 1;
            tmpb = b & 1;
            //取a,b的个位（当前相加位）

            result = result | ((tmpa ^ tmpb ^ carr)<<i);
            if(tmpa==1 && tmpb==1){
                carr = 1;//进位
            }else if(tmpa==1 && carr==1){
                carr = 1;
            }else if(tmpb==1 && carr==1){
                carr = 1;
            }else{
                carr = 0;
            }
            a = a>>1;
            b = b>>1;
        }
        return result;
    }
}
