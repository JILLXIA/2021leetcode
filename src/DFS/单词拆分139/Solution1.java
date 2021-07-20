package DFS.单词拆分139;

import java.util.HashSet;
import java.util.List;

public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict,0,new HashSet<>());
    }

    public boolean dfs(String s, List<String> wordDict, int index, HashSet<Integer> set){
        if(index==s.length()){
            return true;
        }

        for(int i = index+1;i<=s.length();i++){
            if(set.contains(i)){
                continue;
                //set存储着后半部分不是在字典中的index
            }

            if(wordDict.contains(s.substring(index,i))){
                if(dfs(s,wordDict,i,set)){
                    return true;
                }
                set.add(i);
            }
        }
        return false;
    }
}
