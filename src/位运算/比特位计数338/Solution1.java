package 位运算.比特位计数338;

/**
 * 定义正整数 x 的「最低设置位」为 x 的二进制表示中的最低的 1 所在位。
 * 例如，1010 的二进制表示是 1010_{(2)}
 * 其最低设置位为 2，对应的二进制表示是 10_{(2)}10
 * 令 y=x&(x−1)，则 y 为将 x 的最低设置位从 1 变成 0 之后的数，
 * 显然0≤y<x，bits[x]=bits[y]+1。因此对任意正整数 x，
 * 都有 bits[x]=bits[x&(x−1)]+1。
 *
 * 遍历从 1 到 num 的每个正整数 i，
 * 计算 bits 的值。最终得到的数组 bits 即为答案。
 */
public class Solution1 {
    public int[] countBits(int num) {
        //动态规划秀的头皮发麻
        int[] result = new int[num+1];
        for(int i = 1;i<result.length;i++){
            result[i] = result[i&(i-1)]+1;
        }
        return result;
    }
}
