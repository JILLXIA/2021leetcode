package 位运算.二进制手表401;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 猜答案然后反推
 */
public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for(int i = 0;i<12;i++){
            for(int j = 0;j<60;j++){
                if (count1(i) + count1(j)==turnedOn) {
                    StringBuffer s = new StringBuffer();
                    s.append(i+":");
                    if(j<10){
                        s.append("0");
                    }
                    s.append(j);
                    result.add(s.toString());
                }
            }
        }
        return result;
    }

    public int count1(int n){
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
