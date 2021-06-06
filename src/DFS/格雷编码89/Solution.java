package DFS.格雷编码89;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，
 * 两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，
 * 打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 */

/**
 * 动态规划找到规律
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i = 0;i<n;i++){
            int size = result.size();
            int tmp = 1<<i;
            for(int j = 0;j<size;j++){
                result.add(tmp+result.get(size-1-j));
            }
        }
        return result;
    }
}
