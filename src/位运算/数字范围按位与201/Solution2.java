package 位运算.数字范围按位与201;

/**
 * 可以将问题重新定义为找最长的公共前缀
 * 用位移的办法，先将两个数右移，等到相等的时候再左移
 */
public class Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left!=right){
            left  = left>>>1;
            right = right>>>1;
            shift++;
        }
        return left<<shift;
    }
}
