package ProgrammerCarl.AssignCookies455;

import java.util.Arrays;

/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 */

// 全局最优就是局部最优，并且想不出反例
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int pointerg = g.length - 1;
        int pointers = s.length - 1;

        int result = 0;
        while(pointerg >= 0 && pointers >= 0) {
            if(s[pointers] >= g[pointerg]) {
                result++;
                pointerg--;
                pointers--;
            } else {
                pointerg--;
            }
        }
        return result;
    }
}
