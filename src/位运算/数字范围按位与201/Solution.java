package 位运算.数字范围按位与201;

/**
 * 给你两个整数 left 和 right ，
 * 表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */

/**
 * 这个方法容易超时
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        int pos = left;
        while(pos<right){
            pos++;
            result = result & pos;
            if(result==0){
                return 0;
            }
        }
        return result;
    }
}
