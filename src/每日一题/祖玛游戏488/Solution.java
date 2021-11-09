package 每日一题.祖玛游戏488;

import java.util.HashMap;
import java.util.Map;

/**
 * 你正在参与祖玛游戏的一个变种。
 *
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 *
 * 你的目标是 清空 桌面上所有的球。每一回合：
 *
 * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 * 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * 重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 */
public class Solution {
	int INF = 6; // 如果插入次数大于6就一定不行

	public int findMinStep(String board, String hand) {
			StringBuilder sboard = new StringBuilder(board);
			char[] chand = hand.toCharArray();
			HashMap<StringBuilder,Integer> memo = new HashMap<>(); // 缓存每个board的消除次数
			int result = dfs(sboard,chand,memo);
			return  result>= INF ? -1 : result;
	}

	public int dfs(StringBuilder sboard, char[] hand, HashMap<StringBuilder,Integer> memo) {
		// 如果board全部消除完了，直接返回
		if (sboard.length() == 0) {
			return 0;
		}

		if(memo.containsKey(sboard)) {
			return memo.get(sboard);
		}

		int result = INF;

		for(int i = 0;i<hand.length;i++){
			char c = hand[i];
			if(c!= '0'){
				// 没有访问过
				for(int j = 0;j<sboard.length();j++){
					// 构造新的board，插入到旧board的任意位置
					// 如果不构建新的 不容易回溯
					StringBuilder newBoard = new StringBuilder()
							.append(sboard.substring(0, j))
							.append(c)
							.append(sboard.substring(j));
					removeArr(newBoard,j);
					hand[i] = '0';
					result = Math.min(result,dfs(newBoard,hand,memo)+1);
					memo.put(newBoard,result);
					hand[i] = 'c';
				}
			}
		}
		memo.put(sboard,result); // 记录的得是插完之后的状态
		return result;
	}

	public void removeArr(StringBuilder sb, int index){
		// 移除三个以上连续的
		if (index < 0 ) {
			return;
		}
		// 从index的位置向两边扩散
		int left = index, right = index;
		char c = sb.charAt(index);
		// 注意这里的操作
		while (--left >= 0 && sb.charAt(left) == c) ;
		while (++right < sb.length() && sb.charAt(right) == c) ;

		// 扩散完了两边的right和left位置的值都是不等于 c 的，需要减一表示 c 出现的次数
		int count = right - left - 1;
		// 大于等于3才消除
		if (count >= 3) {
			sb.delete(left + 1, right);
			// 连锁反应，比如 YYGGGY，移除了中间的G，三个Y挨一块了，也要移除
			removeArr(sb, left);
		}
	}
}
