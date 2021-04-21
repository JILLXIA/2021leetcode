package 链表.回文链表234;

/**
 * 请判断一个链表是否为回文链表。
 */

/**
 * 先找到中点，找的时候把前半部分的链表反转，反转之后再比较
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode dumpNode = new ListNode(-1);
        ListNode pre = dumpNode;

        dumpNode.next = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;//根据fast和fast.next判断哪个是中点
            //反转链表
            //注意因为链表被反转了，所以fast要先走
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;


            if(fast!=null && fast.next==null){
                slow = slow.next;
            }
        }
        //pre是前半部分的链表头
        //slow可能是中点，也可能是后半部分的链表头

        while(pre!=null && slow!=null){
            if(pre.val!= slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(s.isPalindrome(n1));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}