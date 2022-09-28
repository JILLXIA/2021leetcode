package Google.MaximumSplitOfPositiveEvenIntegers2178;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer finalSum.
 * Split it into a sum of a maximum number of unique positive even integers.
 *
 * For example, given finalSum = 12,
 * the following splits are valid
 * (unique positive even integers summing up to finalSum):
 * (12), (2 + 10), (2 + 4 + 6), and (4 + 8).
 * Among them, (2 + 4 + 6) contains the maximum number of integers.
 * Note that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be unique.
 * Return a list of integers that represent a valid split containing a
 * maximum number of integers.
 * If no valid split exists for finalSum, return an empty list.
 * You may return the integers in any order.
 */
public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 != 0){
            return new ArrayList<>();
        }
        List<Long> result = new ArrayList<>();
        long currEvenNumber = 2;
        while(currEvenNumber < finalSum - currEvenNumber){
            finalSum = finalSum - currEvenNumber;
            result.add(currEvenNumber);
            currEvenNumber += 2;
        }
        result.add(finalSum);
        return result;
    }
}
//
// 2 + 4 + 6 + 8 = 20
// 2, 4, 6, 16