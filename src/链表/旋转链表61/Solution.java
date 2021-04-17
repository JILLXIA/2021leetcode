package 链表.旋转链表61;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      /*  看错题目要求了 这个是反转链表
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextNode = cur;
        while(nextNode!=null){
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;

       */
        //本质上来讲是找到倒数第n个，然后接到前面
        //两个指针，一个先走n步
        if(head==null){
            return null;
        }else if(k==0 || head.next==null){
            return head;
        }

        ListNode n1 = head;
        ListNode n2 = head;
        ListNode n3 = head;
        for(int i = 0;i<k;i++){
            if(n2.next == null){
                n2 = head;
            }else{
                n2 = n2.next;
            }
        }
        if(n1==n2){
            return head;
        }
        while(n2.next!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        n3 = n1.next;
        n1.next = null;
        n2.next = head;
        return n3;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}