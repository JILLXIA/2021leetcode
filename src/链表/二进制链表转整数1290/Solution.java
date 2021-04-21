package 链表.二进制链表转整数1290;

public class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head!=null){
            result = 2*result+head.val;
            head = head.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}