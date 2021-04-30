package 位运算.数字范围按位与201;

/**
 * 还有一个位移相关的算法叫做「Brian Kernighan 算法」，
 * 它用于清除二进制串中最右边的 1。
 *
 * Brian Kernighan 算法的关键在于我们每次对
 * number 和 number−1 之间进行按位与运算后，
 * number 中最右边的 1 会被抹去变成 0。
 */
public class Solution3 {
    public int rangeBitwiseAnd(int left, int right) {
        while(left<right){
            right = right & (right-1);
        }
        return right;
    }
}
