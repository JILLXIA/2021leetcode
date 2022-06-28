package labuladong.LongestConsecutiveSequence128;

import java.util.HashMap;

public class Solution1 {
	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		UF uf = new UF(nums.length);
		for(int i = 0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				continue;
			}
			if(map.containsKey(nums[i]+1)){
				uf.union(i,map.get(nums[i]+1));
			}
			if(map.containsKey(nums[i]-1)){
				uf.union(i,map.get(nums[i]-1));
			}
			map.put(nums[i],i);
		}
		return uf.getLarestSet();
	}
}

class UF{
	int[] parents;
	int[] size;
	public UF(int n){
		parents = new int[n];
		size = new int[n];
		for(int i = 0;i<n;i++){
			parents[i] = i;
			size[i] = 1;
		}
	}

	public int find(int p){
		if(parents[p]!=p){
			parents[p] = find(parents[p]);
		}
		return parents[p];
	}

	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot==qRoot){
			return;
		}
		parents[pRoot] = qRoot;
		size[qRoot] += size[pRoot];
	}

	public int getLarestSet(){
		int n = parents.length;
		int result = 0;
		for(int i = 0;i<n;i++){
			result = Math.max(result,size[i]);
		}
		return result;
	}
}