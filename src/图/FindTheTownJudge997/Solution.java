package 图.FindTheTownJudge997;

import java.util.ArrayList;
import java.util.List;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.


 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        List<Integer>[]  list = new List[n+1];
        List<Integer>[]  rlist = new List[n+1];
        for(int i = 0;i<list.length;i++){
            list[i] = new ArrayList<>();
            rlist[i] = new ArrayList<>();
        }

        for(int i = 0;i<trust.length;i++){
            list[trust[i][1]].add(trust[i][0]);
            rlist[trust[i][0]].add(trust[i][1]);
        }

        int count = 0;
        int result = 0;
        for(int i = 1;i<list.length;i++){
            if(list[i].size()==n-1 && rlist[i].size()==0){
                count++;
                result = i;
            }
        }
        return count==1?result:-1;
    }
}
