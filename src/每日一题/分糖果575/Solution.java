package 每日一题.分糖果575;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 *
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。
 * Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 *
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 */
public class Solution {
	public int distributeCandies(int[] candyType) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<candyType.length;i++){
			if(!set.contains(candyType[i])){
				set.add(candyType[i]);
			}
			if(set.size() == candyType.length/2){
				return set.size();
			}
		}
		return set.size();
	}
}
