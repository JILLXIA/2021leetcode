package OA.Amazon.NineButton;

import java.util.*;

public class Solution {
    public List<String> keyPadNew(String s){
        int[] arr = new int[26];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1]==o1[1]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            }
        });

        for(int i = 0;i<arr.length;i++){
            pq.add(new int[]{i,arr[i]});
        }
        StringBuilder[] sb = new StringBuilder[9];
        for(int i = 0;i<9;i++){
            sb[i] = new StringBuilder();
        }
        int count = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            sb[count].append((char)(tmp[0]+'a'));
            if(count==8){
                count = 0;
            }else {
                count++;
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0;i<9;i++){
            list.add(sb[i].toString());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.keyPadNew("abacadefghibj");
        for(String ss:result){
            System.out.println(ss);
        }
    }
    public int nineKeyPad(String s){
        int[] arr = new int[26];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        int result = 0;
        int count = 9;
        int tapNumber = 1;

        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                break; // 有按键的已经按完了
            }
            if(count==0){
                count = 9;
                tapNumber++;
            }
            result += tapNumber;
            count--;
        }
        return result;
    }
}
