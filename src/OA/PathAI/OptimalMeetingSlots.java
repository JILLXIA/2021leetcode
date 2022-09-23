package OA.PathAI;

import java.util.*;

public class OptimalMeetingSlots {
    public List<String> meetingSlots(int k, List<List<String>> timeList){
      // time,人数
      HashMap<String, Integer> map = new HashMap<>();
      List<String> time = new ArrayList<>();
      int n = timeList.size();
      map.put("00:00",0);
      map.put("24:00",0);
      time.add("00:00");
      time.add("24:00");
      for(int i = 0;i<timeList.size();i++){
          for(int j = 0;j<timeList.get(i).size();j++){
              String[] timeInterval = timeList.get(i).get(j).split("-");
              if(!map.containsKey(timeInterval[0])){
                  time.add(timeInterval[0]);
              }
              if(!map.containsKey(timeInterval[1])){
                  time.add(timeInterval[1]);
              }

              // 开始时间-1
              map.put(timeInterval[0],map.getOrDefault(timeInterval[0],0) - 1);
              // 结束时间人数+1
              map.put(timeInterval[1],map.getOrDefault(timeInterval[1],0) + 1);

          }
      }
        Collections.sort(time, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] sarr1 = o1.split(":");
                String[] sarr2 = o2.split(":");
                if(sarr1[0].equals(sarr2[0])){
                    return Integer.parseInt(sarr1[1]) - Integer.parseInt(sarr2[1]);
                }
                return Integer.parseInt(sarr1[0]) - Integer.parseInt(sarr2[0]);
            }
        });
          int sumPeople = n;
          // 小丁对；amount 小-》大
          // amount一样的时候 time大的排前面
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                String[] sArr1 = o1.interval.split("-")[0].split(":");
                String[] sArr2 = o2.interval.split("-")[0].split(":");
                if(o1.amount==o2.amount){
                    if(sArr1[0].equals(sArr2[0])){
                        return Integer.parseInt(sArr2[1]) - Integer.parseInt(sArr1[1]);
                    } else {
                        return Integer.parseInt(sArr2[0]) - Integer.parseInt(sArr1[0]);
                    }
                }
                return o1.amount - o2.amount;
            }
        });
        for(int i = 0;i<time.size()-1;i++){
            sumPeople = sumPeople + map.get(time.get(i)); // 当前时间点的人数
            StringBuilder sb = new StringBuilder();
            sb.append(time.get(i));
            sb.append("-");
            sb.append(time.get(i+1));
            pq.add(new Pair(sb.toString(),sumPeople));
            if(pq.size() > k){
                pq.poll();
            }
        }
        if(pq.size()<k){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair tmp = pq.poll();
            result.add(0,tmp.interval);
        }
        return result;
    }

    public static void main(String[] args) {
        OptimalMeetingSlots s = new OptimalMeetingSlots();
        List<List<String>> list = new ArrayList<>();
        for(int i = 0;i<3;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add("00:00-05:30");
        list.get(1).add("00:00-05:00");
        list.get(1).add("08:00-22:00");
        list.get(2).add("00:00-12:30");
        System.out.println(s.meetingSlots(3,list));
    }
//    public boolean check(){
//
//    }
    class Pair{
        String interval;
        int amount;
        public Pair(String interval, int amount){
            this.interval = interval;
            this.amount = amount;
        }
    }
}
