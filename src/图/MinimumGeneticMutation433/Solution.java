package 图.MinimumGeneticMutation433;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */
public class Solution {
	public int minMutation(String start, String end, String[] bank) {
		int startBit = buildBitInteger(start);
		int endBit = 0;
		int[] bankBitArr = new int[bank.length];
		boolean flag = false;
		for(int i = 0;i < bank.length; i++){
			if(end.equals(bank[i])){
				flag = true;
				endBit = buildBitInteger(end);
			}
			bankBitArr[i] = buildBitInteger(bank[i]);
		}
		if(!flag){
			return -1;
		}

		Set<Integer> set = new HashSet<>();
		for(int i = 0;i<16;i++){
			set.add(1<<i);
			if(i % 2 == 1){
				set.add((1<<i) + (1<<(i-1)));
			}
		}

		boolean[] visited = new boolean[bank.length];
		Deque<Integer> deque = new LinkedList<>();
		deque.offerLast(startBit);
		int count = -1;
		while(!deque.isEmpty()){
			int size = deque.size();
			count++;
			while(!deque.isEmpty() && size > 0){
				int tmp = deque.pollFirst();
				if(tmp == endBit){
					return count;
				}
				for(int i = 0;i<bankBitArr.length;i++){
					if(!visited[i] && set.contains(tmp^bankBitArr[i])){
						visited[i] = true;
						deque.offerLast(bankBitArr[i]);
					}
				}
				size--;
			}
		}
		return -1;
	}

	public int buildBitInteger(String s){
		int result = 0;
		// bit mask A: 0, C:1, G:2, T:3
		int[] charBit = new int[]{0,1,2,3};
		for(int i = 0;i < s.length();i++){
			switch (s.charAt(i)){
				case 'A':
					result = (result << 2) + charBit[0];
					break;
				case 'C':
					result = (result << 2) + charBit[1];
					break;
				case 'G':
					result = (result << 2) + charBit[2];
					break;
				case 'T':
					result = (result << 2) + charBit[3];
					break;
			}
		}
		return result;
	}
//	public static void main(String[] args){
//		Solution s = new Solution();
//		s.minMutation("AACCGGTT","AACCGGTA",new String[]{"AACCGGTA"});
//		// s.minMutation("AAAAACCC","AACCCCCC",new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"});
//	}
}
