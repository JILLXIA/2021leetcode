package 图.KeysAndRooms841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked
 * except for room 0. Your goal is to visit all the rooms.
 * However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys
 * that you can obtain if you visited room i, return true if you can
 * visit all the rooms, or false otherwise.
 */

/**
 * Possible followup: Why would you use BFS over DFS in this solution (except that DFS takes longer here)?
 * Ans: If input is too large, DFS might cause stack overflow.
 */

/**
 * Time Complexity: O(N + E)O(N+E), where N is the number of rooms,
 * and E is the total number of keys.
 */
public class Solution {
    Set<Integer> set = new HashSet<>(); // write down the room we have visited
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set.add(0);
        dfs(rooms,0);
        return set.size() == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, int curr) {
        if(rooms.get(curr).size()==0){
            // no keys in that room
            return;
        }

        for(int key: rooms.get(curr)){
            if(!set.contains(key)){
                set.add(key);
                dfs(rooms,key);
            }
        }
    }
}
