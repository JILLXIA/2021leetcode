package Amazon.ReorderDatainLogFiles937;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 相当于写一个Comparator
        Arrays.sort(logs, new Comparator<String>(){ // 数组转化为ArrayList的方法
            @Override
            public int compare(String s1, String s2){
                String[] sArr1 = s1.split(" ");
                String[] sArr2 = s2.split(" ");
                int type1 = Character.isAlphabetic(sArr1[1].charAt(0)) ? 0 : 1;
                int type2 = Character.isAlphabetic(sArr2[1].charAt(0)) ? 0 : 1;
                if(type1!=type2){
                    return type1-type2;
                }else if(type1==0 && type2==0){
                    for(int i = 1;i<sArr1.length;i++){
                        if(i >= sArr2.length){
                            return 1;
                        }
                        if(sArr1[i].compareTo(sArr2[i])==0){
                            continue;
                        } else {
                            return sArr1[i].compareTo(sArr2[i]);
                        }
                    }
                    if(sArr2.length > sArr1.length){
                        return -1;
                    }
                    return sArr1[0].compareTo(sArr2[0]);
                }
                return 0;
            }
        });
        return logs;
    }
}
