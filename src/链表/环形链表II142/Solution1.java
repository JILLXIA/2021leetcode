package 链表.环形链表II142;

public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            slow = slow.next;//因为都是从起点出发的，所以先走一次再判断
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                return null;
            }
            if(slow==fast){
                //有环
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
