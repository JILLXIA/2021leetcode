package 位运算.最大单词长度乘积318;

/**
 * 先把位运算的值算好，存到数组里面
 *
 * 预处理
 *
 * 实际上就是在比较有没有相同字母的时候用了位运算
 */
public class Solution1 {
    public int maxProduct(String[] words) {
        int result = 0;
        int[] mask = new int[words.length];
        int[] len = new int[words.length];
        //数组的存取速度是很快的
        for(int i = 0;i< words.length;i++){
            mask[i] = cal(words[i]);
            len[i] = words[i].length();
        }

        for(int i = 0;i<words.length;i++){
            for(int j = i+1;j< words.length;j++){
                if((mask[i] & mask[j])==0){
                    result = Math.max(result,len[i]*len[j]);
                }
            }
        }
        return result;
    }

    public int cal(String a){
        int resulta = 0;
        for(int i = 0;i<a.length();i++){
            resulta = resulta | 1<<(a.charAt(i)-'a');
        }
        return resulta;
    }
}
