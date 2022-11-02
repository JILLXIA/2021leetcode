package Top100Question.Powxn50;

/**
 * Implement pow(x, n),
 * which calculates x raised to the power n (i.e., xn).
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return fastPower(x,n);
    }

    public double fastPower(double x, int n){
        // use recursive
        if(n==0){
            return 1;
        }
        double half = fastPower(x,n/2);
        if(n%2==0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
