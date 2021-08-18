package 图.找到小镇的法官997;

/**
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 *
 * 给定数组trust，该数组由信任对 trust[i] = [a, b]组成，
 * 表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 */

/**
 * 图的问题要么找出度入度 要么找边
 */
public class Solution {
    // 建图可以放到二维数组里面，二维数组的值就是边的权重
    // 但实际上这道题用一个以为数组记录出度和入度就够了
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n+1];
        for(int i = 0;i<trust.length;i++){
            degree[trust[i][0]]--;
            degree[trust[i][1]]++;
        }
        for(int i = 1;i<degree.length;i++){
            if(degree[i]==n-1){
                return n-1;
            }
        }
        return -1;
    }
}
