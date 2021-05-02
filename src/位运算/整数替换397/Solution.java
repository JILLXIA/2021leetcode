package 位运算.整数替换397;

/**
 * 给定一个正整数n ，你可以做如下操作：
 *
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 */

/**
 * 难点在于什么时候+1，什么时候-1
 *
 * 1。dfs
 * 2. 找规律
 */
public class Solution {
    int result = Integer.MAX_VALUE;
    public int integerReplacement(int n) {
        int count = 0;
        dfs(n,count);
        return result;
    }

    public void dfs(int n,int count){
        if(n==1){
            result = Math.min(result,count);
            return;
        }
        if(n%2==0){
            count++;
            dfs(n/2,count);
        }else{
            count++;
            if(n!=Integer.MAX_VALUE){
                dfs(n+1,count);
            }
            dfs(n-1,count);

        }
    }
}
