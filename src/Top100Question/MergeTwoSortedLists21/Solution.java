package Top100Question.MergeTwoSortedLists21;

import 每日一题.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy node(current node)
        // 2 pointer list1, list2
        // compare value of list1 & list2
        // list1.val < list2.val. =>  cur = list1;list1 = list1.next
        // vice versa
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 只考虑公共的部分，如果公共部分都走完了，一个pointer变成null了，直接把curr接到后面
        while(list1!=null && list2 != null){
            if(list1.val >= list2.val){
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            } else if(list1.val < list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
        }
        current.next = list1 == null ? list2:list1;
        return dummy.next;
    }
}
