package Amazon.ReorderDatainLogFiles937;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int index1 = s1.indexOf(" ");// 找到的是第一个空格的index
                int index2 = s2.indexOf(" ");

                if(Character.isDigit(s1.charAt(index1+1))){
                    if(!Character.isDigit(s2.charAt(index2+1))){
                        return 1;
                    } else {
                        return 0;
                    }
                }

                if(Character.isDigit(s2.charAt(index2+1))){
                    return -1;
                }

                int compareContent = s1.substring(index1).compareTo(s2.substring(index2));
                if(compareContent==0){
                    return s1.substring(0,index1).compareTo(s2.substring(0,index2));
                }
                return compareContent;
            }
        });
        return logs;
    }
}
