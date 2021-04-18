package 链表.移除链表元素203;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            if(cur.val==val){
                next = cur.next;
                pre.next = next;
                cur = next;
            }else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dump.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}