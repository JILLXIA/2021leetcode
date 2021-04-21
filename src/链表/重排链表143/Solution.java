package 链表.重排链表143;

public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode next2;
        while(head2!=null){
            next2 = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = next2;
        }
        head2 = pre;
        ListNode head1 = head;
        while(head1!=null && head2!=null){
            ListNode tmpNext1 = head1.next;
            ListNode tmpNext2 = head2.next;
            head1.next = head2;
            head2.next = tmpNext1;
            head1 = tmpNext1;
            head2 = tmpNext2;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}