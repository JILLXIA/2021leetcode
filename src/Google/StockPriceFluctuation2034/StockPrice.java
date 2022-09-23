package Google.StockPriceFluctuation2034;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.
 *
 * Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.
 *
 * Design an algorithm that:
 *
 * Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
 * Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
 * Finds the maximum price the stock has been based on the current records.
 * Finds the minimum price the stock has been based on the current records.
 * Implement the StockPrice class:
 *
 * StockPrice() Initializes the object with no price records.
 * void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
 * int current() Returns the latest price of the stock.
 * int maximum() Returns the maximum price of the stock.
 * int minimum() Returns the minimum price of the stock.
 */
public class StockPrice {
    // 最大堆，最小堆
    PriorityQueue<int[]> maxHeap;
    PriorityQueue<int[]> minHeap;
    // 实时数据
    HashMap<Integer, Integer> timestampToPrice;

    int latestTime = 0;
    int latestPrice = 0;
    // HashMap
    public StockPrice() {
        maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });
        minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        timestampToPrice = new HashMap<>();

    }

    public void update(int timestamp, int price) {
        timestampToPrice.put(timestamp,price);
        int[] arr = new int[]{timestamp,price};
        maxHeap.add(arr);
        minHeap.add(arr);
        if(timestamp >= this.latestTime){
            this.latestTime = timestamp;
            this.latestPrice = price;
        }
    }

    public int current() {
        return this.latestPrice;
    }

    public int maximum() {
        int[] tmp;
        while(true){
            tmp = maxHeap.peek();
            if(timestampToPrice.get(tmp[0])!=tmp[1]){
                maxHeap.poll();// poll出已经过时的
            } else {
                break;
            }
        }
        return tmp[1];
    }

    public int minimum() {
        int[] tmp;
        while(true){
            tmp = minHeap.peek();
            if(timestampToPrice.get(tmp[0])!=tmp[1]){
                minHeap.poll();// poll出已经过时的
            } else {
                break;
            }
        }
        return tmp[1];
    }
}
