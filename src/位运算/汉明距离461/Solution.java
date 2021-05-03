package 位运算.汉明距离461;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = x^y;
        int count = 0;
        while(tmp!=0){
            tmp = tmp & (tmp-1);
            count++;
        }
        return count;
    }
}
