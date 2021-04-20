package 链表.环形链表141;

import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode ptr = head;
        while(ptr!=null){
            if(!set.contains(ptr)){
                set.add(ptr);
            }else{
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}