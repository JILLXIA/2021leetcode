package 字符串.统计匹配检索规则的物品数量1773;

import java.util.List;

/**
 * 给你一个数组 items ，其中items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 *
 * 另给你一条由两个字符串ruleKey 和 ruleValue 表示的检索规则。
 *
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 *
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 */

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result = 0;
        int index = -1;
        switch(ruleKey){
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }
        for(int i = 0;i<items.size();i++){
            if(items.get(i).get(index).equals(ruleValue)){
                result++;
            }
        }
        return result;
    }
}
