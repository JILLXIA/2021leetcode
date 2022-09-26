package Google.FindOriginalArrayFromDoubledArray2007;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * An integer array original is transformed into a doubled array changed
 * by appending twice the value of every element in original,
 * and then randomly shuffling the resulting array.
 *
 * Given an array changed, return original
 * if changed is a doubled array.
 * If changed is not a doubled array,
 * return an empty array.
 * The elements in original may be returned in any order.
 */
public class Solution {
    public int[] findOriginalArray(int[] changed) {
        Deque<Integer> deque = new LinkedList<>();
        int[] empty = new int[0];
        if(changed.length % 2 != 0){
            return empty;
        }
        int[] result = new int[changed.length/2];
        Arrays.sort(changed);
        int index = 0;
        for(int i = 0;i< changed.length;i++){
            if(!deque.isEmpty() && deque.peekFirst() * 2==changed[i]){
                result[index] = deque.pollFirst();
                index++;
            } else {
                deque.offerLast(changed[i]);
            }
        }
        return deque.isEmpty() ? result : new int[]{};

    }
}
