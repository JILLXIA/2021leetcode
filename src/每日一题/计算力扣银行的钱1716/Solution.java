package 每日一题.计算力扣银行的钱1716;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1块钱。从周二到周日，
 * 他每天都比前一天多存入 1块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1块钱。
 *
 * 给你n，请你返回在第 n天结束的时候他在力扣银行总共存了多少块钱。
 */
public class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int count = 1;
        for(int i = 1;i<=n;i++){
            if(i>1&&(i-1)%7==0){
                count = count - 6;
            }
            result += count;
            count++;
        }
        return result;
    }
}
