package Top100Question.SortList148;

import 每日一题.ListNode;

/*
Given the head of a linked list,
return the list after sorting it in ascending order.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        // find the center point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextStart = slow.next;
        slow.next = null;
        return merge(sortList(head),sortList(nextStart));
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1==null ? list2 : list1;
        return dummy.next;
    }
}
