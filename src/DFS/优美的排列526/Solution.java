package DFS.优美的排列526;

/**
 * 假设有从 1 到 N 的N个整数，
 * 如果从这N个数字中成功构造出一个数组，
 * 使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，
 * 我们就称这个数组为一个优美的排列。条件：
 *
 * 第i位的数字能被i整除
 * i 能被第 i 位上的数字整除
 */
public class Solution {
    // 很明显，这是一道回溯的问题
    int result = 0;
    public int countArrangement(int n) {
        if(n==0){
            return 0;
        }
        int[] visit = new int[n+1];
        int[] arr = new int[n+1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i;
        }
        dfs(arr, visit,n,0);
        return result;
    }
    public void dfs(int[] arr,int[] visit,int n,int index){
        if(index == n){
            result++;
            return;
        }
        for(int i = 1;i<arr.length;i++){
            if(visit[i]==0 && (arr[i]%(index+1)==0||(index+1)%arr[i]==0)){
                visit[i] = 1;
                index++;
                dfs(arr,visit,n,index);
                index--;
                visit[i] = 0;
            }
        }
    }
}
