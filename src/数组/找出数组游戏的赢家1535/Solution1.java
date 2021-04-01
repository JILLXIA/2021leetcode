package 数组.找出数组游戏的赢家1535;

/**
 * 其实可以不用移动数组，用模拟的方法
 * 在第一回合游戏之后，无论 {arr}[0]arr[0] 和 {arr}[1]arr[1] 当中谁取得胜利，
 * 第二回合游戏的另一个整数一定是 {arr}arr 中的下一个整数。推广到一般的情况，
 * 当2≤i<arr.length 时，第 i 回合游戏一定在第 i-1 回合游戏中取得胜利的整数和
 * {arr}[i]arr[i] 之间进行。
 *
 */
public class Solution1 {
    public int getWinner(int[] arr, int k) {
        int prev = arr[0];
        int consecutive = 0;
        for(int i = 1;i<arr.length;i++){
            if(prev>=arr[i]){
                consecutive++;
            }else{
                prev = arr[i];
                consecutive = 1;
            }
            if(consecutive == k){
                return prev;
            }
        }
        return prev;
    }
}
