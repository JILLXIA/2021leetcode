package Google.SnapshotArray1146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implement a SnapshotArray that supports the following interface:
 *
 * SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */
public class SnapshotArray {
    List<HashMap<Integer, Integer>> list;
    HashMap<Integer, Integer> tmpMap;
    public SnapshotArray(int length) {
        list = new ArrayList<>();// index is snap_id
        tmpMap = new HashMap<>();
    }

    public void set(int index, int val) {
        tmpMap.put(index,val);
    }

    public int snap() {
        list.add(new HashMap<>(tmpMap));
        tmpMap.clear();
        return list.size() - 1;
    }

    public int get(int index, int snap_id) {
        if(snap_id >= list.size()){
            return 0;
        }

        // snap_id可能很大，不如用TreeMap的二分查找
        for(int i = snap_id;i >=0;i--){
            if(list.get(i).containsKey(index)){
                return list.get(i).get(index);
            }
        }
        return 0;
    }
}
