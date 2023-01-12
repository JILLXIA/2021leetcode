package ProgrammerCarl.FruitIntoBaskets904;

import java.util.HashMap;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        // monotony
        // subarray

        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> typeToCount = new HashMap<>();

        int result = 0;

        // time: O(n), space: O(1)
        // space complexity is O(1), because the maximum capacity of hashMap typeToCount is 2.
        while(right < fruits.length){
            typeToCount.put(fruits[right], typeToCount.getOrDefault(fruits[right],0) + 1);
            right++;

            if(typeToCount.size() <= 2){
                result = Math.max(result, right - left);
            }

            while(typeToCount.size() > 2){
                int leftItem = fruits[left];
                if(typeToCount.get(leftItem) == 1){
                    typeToCount.remove(leftItem);
                } else {
                    typeToCount.put(leftItem, typeToCount.get(leftItem) - 1);
                }

                left++;
            }
        }
        return result;
    }
}
