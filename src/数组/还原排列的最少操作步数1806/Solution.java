package 数组.还原排列的最少操作步数1806;

/**
 * 给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
 *
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 *
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr 赋值给 perm 。
 *
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 */
public class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] perm_new = new int[n];
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            perm[i] = i;
            perm_new[i] = i;
            arr[i] = i;
        }
        int count = 0;
        while(true){
            count++;
            if(count % 2==0) {
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        perm_new[i] = arr[i/2];
                    }else{
                        perm_new[i] = arr[n / 2 + (i - 1) / 2];
                    }
                }
                if(check(perm_new,perm)){
                    return count;
                }
            }else{
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        arr[i] = perm_new[i / 2];
                    } else {
                        arr[i] = perm_new[n / 2 + (i - 1) / 2];
                    }
                }
                if(check(arr,perm)){
                    return count;
                }
            }
            //count++;
        }
        //return count;
    }

    public static boolean check(int[] a,int[] b){
        if(a.length!=b.length){
            return false;
        }else{
            for(int i = 0;i<a.length;i++){
                if(a[i]!=b[i]){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.reinitializePermutation(4));
    }
}
