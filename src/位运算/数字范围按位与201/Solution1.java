package 位运算.数字范围按位与201;

/**
 * 高位往低比较
 *
 * 如果最高位的1，不在同一位 返回0
 * 如果最高位的1在同一位，往后找取相同位，直到找到不一样的位
 */
public class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {
        int tmp = 0x40000000;
        int result = 0;
        while(tmp!=0){
            if(((left & tmp)!=0 && (right & tmp)==0)
            || ((left & tmp)==0 && (right & tmp)!=0)){
                //两个最高位 不一致
                return 0;
            }else if((left & tmp)!=0 && (right & tmp)!=0){
                //最高位一样
                while((left & tmp)==(right & tmp) && tmp!=0){
                    result = result | (left & tmp);
                    tmp = tmp>>>1;
                }
                return result;
            }
            tmp = tmp>>>1;
        }
        return 0;
    }


}
