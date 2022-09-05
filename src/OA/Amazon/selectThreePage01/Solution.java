package OA.Amazon.selectThreePage01;

import java.util.ArrayList;

public class Solution {
    public int selectThreePage(String s){
        if(s.length() < 3){
            return 0;
        }
        int type = s.charAt(0)-'0';
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i = 1;i<s.length();i++){
            if(i==s.length()-1 || s.charAt(i) - '0'!=type){
                list.add(count);
                type = s.charAt(i) - '0';
                count = 1;
            } else if(s.charAt(i) - '0'==type){
                count++;
            }
        }
        list.add(count);
        int result = 0;
        if(list.size() < 3){
            return 0;
        }
        for(int i = 2;i<list.size();i++){
            result += list.get(i) * list.get(i-1) * list.get(i-2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.selectThreePage("010011"));
    }
}
