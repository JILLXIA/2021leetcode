package ProgrammerCarl.IntersectionOfTwoLinkedLists160;

import 每日一题.ListNode;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != null){
            lenA++;
            curA = curA.next;
        }

        while(curB != null){
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        // we make curA become the longest
        if(lenB > lenA){
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int gap = lenA - lenB;

        while(gap > 0){
            curA = curA.next;
            gap--;
        }

        while(curA != null){
            if(curA == curB){
                return curB;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
