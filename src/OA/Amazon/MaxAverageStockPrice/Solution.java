package OA.Amazon.MaxAverageStockPrice;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int stockPrice(int[] prices, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        if(k > prices.length){
            return -1;
        }
        int result = -1;
        int[] preSum = new int[prices.length+1];
        for(int i = 1;i<=prices.length;i++){
            preSum[i] = preSum[i-1] + prices[i-1];
        }

        for(int i = 0;i<k;i++){
            // 前k个先存起来
            map.put(prices[i],map.getOrDefault(prices[i],0)+1);
        }
        if(map.size()==k){
            result = Math.max(result, preSum[k] - preSum[0]);
        }
        for(int i = k;i<prices.length;i++){
            if(map.get(prices[i-k])==1){
                map.remove(prices[i-k]);
            } else {
                map.put(prices[i-k],map.get(prices[i-k])-1);
            }
            map.put(prices[i],map.getOrDefault(prices[i],0)+1);
            if(map.size()==k){
                result = Math.max(result, preSum[i+1] - preSum[i+1-k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.stockPrice(new int[]{1,2,7,7,4,3,6},3));
        System.out.println(s.stockPrice(new int[]{1,2,7,7,4,3},3));
        System.out.println(s.stockPrice(new int[]{1,2,1,1,4,3,6},2));
        System.out.println(s.stockPrice(new int[]{1,2,2,1,4,3,6},3));
        System.out.println(s.stockPrice(new int[]{1,1,1,1,1,1,1},4));
        System.out.println(s.stockPrice(new int[]{1,2,3,4},4));
        System.out.println(s.stockPrice(new int[]{1,2,3},4));
    }
}
