package 数组.找出数组游戏的赢家1535;

import java.util.ArrayList;

/**
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
 * 较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * 返回赢得比赛的整数。
 *
 * 题目数据 保证 游戏存在赢家。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 此方法的时间复杂度比较高，原因是移动了数组
 */
public class Solution {
    public int getWinner(int[] arr, int k) {
        int length = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<length;i++){
            list.add(arr[i]);
        }
        int count = 0;
        for(int i = 0;i<length-1;i++){
            int temp;
            if(list.get(0)>=list.get(1)){
                temp = list.get(1);
                list.remove(1);
                count++;
            }else{
                temp = list.get(0);
                list.remove(0);
                count = 1;//pk赢了之后初始应该就算1回合了
            }
            list.add(temp);

            if(count==k){
                return list.get(0);
            }
        }
        return list.get(0);
    }
}
