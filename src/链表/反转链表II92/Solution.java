package 链表.反转链表II92;
/**
 * 给你单链表的头指针 head
 * 和两个整数left 和 right ，
 * 其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
/**
 * 记录 pre,leftpre,rightlast,last四个节点
 */

/**
 * 注意讨论特殊情况和虚拟头节点
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right){
            return head;
        }
        int pos = 0;
        ListNode dumpNode = new ListNode(-1);//可能链表的第一个节点就反转了，此时的head就不是头节点了
        dumpNode.next = head;
        ListNode pre = dumpNode;
        while(pos<left-1){
            pos++;
            pre = pre.next;
        }
        ListNode rightlast = pre.next;
        ListNode leftpre = pre.next;
        pos++;
        pre.next=null;

        while(pos<right){
            rightlast = rightlast.next;
            pos++;
        }
        ListNode last = rightlast.next;
        rightlast.next = null;

        ListNode curpre=null;
        ListNode cur = leftpre;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = curpre;
            curpre = cur;
            cur = next;
        }

        pre.next=rightlast;
        leftpre.next=last;

        return dumpNode.next;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(s.reverseBetween(head,2,4));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}