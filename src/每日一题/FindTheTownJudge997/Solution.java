package 每日一题.FindTheTownJudge997;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        // indegree
        // outdegree
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int i = 0;i < trust.length;i++){
            indegree[trust[i][1]]++;
            outdegree[trust[i][0]]++;
        }

        int result = -1;
        for(int i = 1;i < n+1;i++){
            if(result == -1 && indegree[i] == n && outdegree[i] == 0){
                result = i;
            }
        }
        return result;
    }
}
