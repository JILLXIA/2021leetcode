package MixTest;

import java.util.*;

public class CountFreq {
    public int[] count(String s){
        System.out.println(s.length());
        System.out.println(4*2+4*2+3*4+3*4+5*1+5*1+5*1+5*1+3*5+3*6+3*6+5*1+5*2+5*2+5*2);
        int[] result = new int[27];
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                result[26]++;
            } else {
                result[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0;i<result.length;i++){
            list.add(new int[]{i,result[i]});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0;i<list.size();i++){
            System.out.println(Arrays.toString(list.get(i)));
        }

        return result;
    }

    public static void main(String[] args) {
        CountFreq cf = new CountFreq();
        System.out.println(Arrays.toString(cf.count("algorithms design and analysis is an art")));
    }
}
