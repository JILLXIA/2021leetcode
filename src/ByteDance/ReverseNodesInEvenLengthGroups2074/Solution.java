package ByteDance.ReverseNodesInEvenLengthGroups2074;

import 每日一题.ListNode;

/**
 * You are given the head of a linked list.
 *
 * The nodes in the linked list are sequentially assigned to non-empty groups whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the number of nodes assigned to it. In other words,
 *
 * The 1st node is assigned to the first group.
 * The 2nd and the 3rd nodes are assigned to the second group.
 * The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
 * Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
 *
 * Reverse the nodes in each group with an even length, and return the head of the modified linked list.
 */
public class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupSize = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        ListNode preP1 = dummy;
        ListNode nextP2 = dummy;
        int count = 1; // group的长度
        while(pointer2 != null){
            while(pointer2.next!=null && count < groupSize){
                pointer2 = pointer2.next;
                count++;
            }
            if(count % 2!=0){
                preP1 = pointer2;
                // 长度奇数的时候不需要反转
                pointer2 = pointer2.next;
                pointer1 = pointer2;
                groupSize++;
                count = 1;
                continue;
            }
            ListNode pre = null;
            ListNode cur = pointer1;
            nextP2 = pointer2.next;
            while(cur != nextP2){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            preP1.next = pre;
            preP1 = pointer1;
            pointer1.next = nextP2;
            pointer2 = nextP2;
            pointer1 = pointer2;
            groupSize++;
            count = 1;
        }
        return dummy.next;
    }
}
