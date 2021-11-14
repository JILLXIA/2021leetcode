package 每日一题.键值映射677;

import java.util.HashMap;

class MapSum {

    int[][] allNode = new int[Integer.MAX_VALUE][26]; // 存所有的字符
    int[] hash = new int[Integer.MAX_VALUE];// 存每个结尾字符的value

    int index = 0; // 用到第几个坑了
    public MapSum() {

    }

    public void insert(String key, int val) {
        int p = 0;// 是一个局部的指针
        for(int i = 0;i<key.length();i++){
            if(allNode[p][key.charAt(i) - 'a'] == 0) {
                index++;
                allNode[p][key.charAt(i) - 'a'] = index;
            }
            p = allNode[p][key.charAt(i) - 'a']; // 指向下一个字符
        }
        hash[p] = val;
    }

    public int sum(String prefix) {
        int p = 0;
        for(int i = 0;i<prefix.length();i++){
            if(allNode[p][prefix.charAt(i) - 'a'] == 0){
                return 0;
            }
            p = allNode[p][prefix.charAt(i) - 'a']; // 找下一个index
        }
        return dfs(p);
    }
    int dfs(int p){
        int ans = hash[p];
        for(int i = 0;i<26;i++){
            if(allNode[p][i] != 0) {
                ans += dfs(allNode[p][i]);
            }
        }
        return ans;
    }
}

