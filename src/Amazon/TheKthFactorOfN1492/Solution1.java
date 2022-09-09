package Amazon.TheKthFactorOfN1492;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int kthFactor(int n, int k) {
        List<Integer> result = new ArrayList<>();
        int count = 0;// count power before the sqart
        // 16
        // [1,2,4]
        // [16,8]
        for(int i = 1;i * i <=n;i++){
            if(n % i==0){
                count++;
                if(i * i!=n) {
                    result.add(n / i);
                }
            }
            if(count==k){
                return i;
            }
        }
        if(count + result.size() < k){
            return -1;
        }
        return result.get(result.size() - k + count);
    }
}
