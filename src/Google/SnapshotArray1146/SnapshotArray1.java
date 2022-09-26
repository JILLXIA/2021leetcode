package Google.SnapshotArray1146;

import java.util.TreeMap;

public class SnapshotArray1 {
    // treeMap存每一个item的历史记录
    // snap_id -> value
    TreeMap<Integer,Integer>[] map;
    int snap_id = 0;
    public SnapshotArray1(int length) {
        map = new TreeMap[length];
        for(int i = 0;i<length;i++){
            map[i] = new TreeMap<>();
            map[i].put(0,0);
        }
    }

    public void set(int index, int val) {
        map[index].put(snap_id,val);
    }

    public int snap() {
        snap_id++;
        return snap_id - 1;
    }



    // floorEntry -- floorKey
    // ceilingEntry -- ceilingKey
    // lowerEntry -- lowerKey
    // higherEntry -- higherKey
    public int get(int index, int snap_id) {
        // 找到小于等于snap_id的一项
        return map[index].floorEntry(snap_id).getValue();
    }
}
