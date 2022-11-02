package Top100Question.PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number
 * is the sum of the two numbers directly above it as shown:
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> line0 = new ArrayList();
        line0.add(1);
        result.add(line0);
        if(numRows==1){
            return result;
        }

        int line = 2;
        while(line <= numRows){
            List<Integer> currLine = new ArrayList();
            currLine.add(1);
            for(int i = 0;i<result.get(result.size() - 1).size() - 1;i++){
                currLine.add(result.get(result.size() - 1).get(i) + result.get(result.size() - 1).get(i+1));
            }
            currLine.add(1);
            result.add(currLine);
            line++;
        }
        return result;
    }
}
