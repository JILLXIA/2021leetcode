package 位运算.编码验证393;

/**
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，
 * 后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 */

/**
 * 难点：不知道怎么简洁地写代码
 *
 * 这题没啥意思 不写了
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int length = data.length;
        int tmpn = 0xffffffff;
        int clear = 0x000000ff;
        if(length == 1){
            tmpn = tmpn<<8 & clear;
            if((data[0] & tmpn)==0){
                return true;
            }else{
                return false;
            }
        }else {
            tmpn = tmpn<<(8-length) & clear;
            int zero = 1<<(8-length-2);
            if((data[0] & tmpn)==0 && (data[0] & zero)==0){
                for(int i = 1;i<length;i++){
                    if((data[i]^0x00000080)>=0x00000040){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }
    }
}
