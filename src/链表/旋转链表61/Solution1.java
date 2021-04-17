package 链表.旋转链表61;

import java.util.List;

/**
 * 闭合为环，找到指定位置断开
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }//链表的题注意特殊情况
        int n = 0;
        ListNode pos = head;
        ListNode cur = head;
        while(pos!=null){
            n++;
            if(pos.next==null){
                pos.next = head;
                break;
            }
            pos = pos.next;
        }
        //pos指向最后一个
        int count = 0;
        while(count!=n-(k%n)-1){
            cur = cur.next;
            count++;
        }
        pos = cur.next;
        cur.next = null;
        return pos;
    }
}
