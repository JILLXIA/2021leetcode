package Amazon.AnalyzeUserWebsiteVisitPattern1152;

import java.util.*;

/**
 * You are given two string arrays username and website and an integer array timestamp. All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]] indicates that the user username[i] visited the website website[i] at time timestamp[i].
 *
 * A pattern is a list of three websites (not necessarily distinct).
 *
 * For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
 * The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.
 *
 * For example, if the pattern is ["home", "away", "love"], the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
 * Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
 * Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number of users x such that x visited "luffy" three different times at different timestamps.
 * Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.
 */
public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // user->  time,website
        HashMap<String, TreeMap<Integer,String>> allUserMap = new HashMap<>();
        for(int i = 0;i<username.length;i++){
            if(!allUserMap.containsKey(username[i])){
                allUserMap.put(username[i],new TreeMap<>());
            }
            allUserMap.get(username[i]).put(timestamp[i],website[i]); // treeset里面对timestamp自动排序
        }

        // pattern,countUser
        HashMap<String,Integer> patternMap = new HashMap<>();
        for(String user:allUserMap.keySet()){
            // 遍历allUserMap

            // 生成pattern list
            Set<String> pattern = buildUpPattern(allUserMap.get(user));
            for(String set:pattern){
                patternMap.put(set,patternMap.getOrDefault(set,0)+1);
            }
        }

        String maxPattern = "";
        int count = 0;
        for(String sp:patternMap.keySet()){
            if(patternMap.get(sp) > count){
                count = patternMap.get(sp);
                maxPattern = sp;
            } else if(patternMap.get(sp) == count){
                if(maxPattern.compareTo(sp) > 0){
                    maxPattern = sp;
                }
            }
        }

        List<String> result = Arrays.asList(maxPattern.split(";"));
        return result;
    }

    public Set<String> buildUpPattern(TreeMap<Integer,String> treeMap){
        Set<String> result = new HashSet<>();
        List<Integer> time = new ArrayList<>();
        for(int i:treeMap.keySet()){
            time.add(i);// 一定是递增的序列
        }

        for(int i = 0;i<time.size()-2;i++){
            for(int j = i+1;j<time.size()-1;j++){
                for(int k = j+1;k<time.size();k++){
                    String pattern = treeMap.get(time.get(i)) + ";" + treeMap.get(time.get(j)) + ";" + treeMap.get(time.get(k));
                    if(!result.contains(pattern)){
                        result.add(pattern);
                    }
                }
            }
        }
        return result;
    }
}
