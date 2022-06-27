package labuladong.SatisfiabilityOfEqualityEquations990;

/**
 * You are given an array of strings equations that represent
 * relationships between variables where each string equations[i] is
 * of length 4 and takes one of two different forms: "xi==yi"
 * or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different)
 * that represent one-letter variable names.
 *
 * Return true if it is possible to assign integers
 * to variable names so as to satisfy all the given equations,
 * or false otherwise.
 */
public class Solution {
	public boolean equationsPossible(String[] equations) {
		// UF, 先连起来，再检查是否违反了联通分量
		UF uf = new UF(26);
		for(String s:equations){
			if(s.charAt(1)=='='){
				uf.union(s.charAt(0)-'a',s.charAt(3)-'a');
			}
		}
		for(String s:equations){
			if(s.charAt(1)=='!'){
				 if(uf.isConnected(s.charAt(0)-'a',s.charAt(3)-'a')){
				 	return false;
				 }
			}
		}
		return true;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		s.equationsPossible(new String[]{"a==b","b!=a"});
	}
}

class UF{
	int count; // count of connected components
	int[] parent;
	public UF(int size){
		this.count = size;
		parent = new int[size];

		// initial the parent array
		for(int i = 0;i<size;i++){
			parent[i] = i;
		}
	}

	public void union(int p, int q){
		int pAns = find(p);
		int qAns = find(q);
		if(pAns == qAns){
			return ;
		}
		parent[pAns] = qAns;
		count--;
	}

	public boolean isConnected(int p, int q){
		return find(p) == find(q);
	}

	public int find(int p){
		if(parent[p] != p){
			parent[p] = find(parent[p]);
		}
		return parent[p];
	}

	public int getCount(){
		return count;
	}
}
