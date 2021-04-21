package 链表.移除重复节点面试题0201;

import java.util.HashSet;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        if(head==null || head.next==null){
            return head;
        }
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode cur = head;
        ListNode pre = dumpNode;
        while(cur!=null){
            if(!set.contains(cur.val)){
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }else{
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}