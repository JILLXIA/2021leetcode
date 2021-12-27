package 每日一题.适龄的朋友825;

import java.util.Arrays;
import java.util.Collections;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 */
public class Solution {
    public int numFriendRequests(int[] ages) {
        // 利用前缀和解决，只用考虑前两个条件，计算区间和
        int[] count = new int[121];
        for(int i = 0;i<ages.length;i++){
            count[ages[i]]++;
        }

        int[] pre = new int[121];
        // 利用前缀和数组来优化效率
        pre[0] = count[0];
        for(int i = 1;i<count.length;i++){
            pre[i] = pre[i-1] + count[i];
        }

        int ans = 0;
        for(int i = 15;i<count.length;i++){
            if(count[i]>0) {
                int y = (int) (i * 0.5 + 7);
                ans += (pre[i] - pre[y] - 1) * count[i];
            }
        }
        return ans;
    }
}
