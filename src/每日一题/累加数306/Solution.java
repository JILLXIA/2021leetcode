package 每日一题.累加数306;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。
 * 除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字'0'-'9'的字符串，
 * 编写一个算法来判断给定输入是否是 累加数 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，
 * 所以不会出现1, 2, 03 或者1, 02, 3的情况。
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num,0,0,0,0);
    }

    public boolean dfs(String num,int index,int count,long pre1,long pre2) {
        if(index>=num.length()){
            return count > 2;
        }
        long cur = 0;// 栈内变量，生命周期在函数内
        for(int i = index;i<num.length();i++){
            char c = num.charAt(i);
            if(num.charAt(index) == '0' && i > index){
                // 首位不为0
                return false;
            }

            cur = cur * 10 + c - '0';
            if(count>=2) {
                long sum = pre1 + pre2;
                if (cur > sum) {
                    return false;
                }

                if(cur < sum) {
                    continue;
                }
            }
            // 正好等于 或者不满两个数
            if(dfs(num,i+1,count+1,pre2,cur)){
                return true;
            }
        }
        return false;
    }

}
