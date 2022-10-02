package OA.TikTok.CountPrimes204;

/**
 * Given an integer n,
 * return the number of prime numbers that are
 * strictly less than n.
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] checkPrime = new boolean[n];
        int count = 0;
        for(int i = 2;i< checkPrime.length;i++){
            if(!checkPrime[i]){
                count++;
                for(int j = 2;j*i<n;j++){
                    checkPrime[j*i] = true;
                }
            }
        }
        return count;
    }
}
