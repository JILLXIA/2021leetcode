package 链表.有序链表转换二叉搜索树109;

/**
 * 链表打印的顺序恰好是中序遍历的顺序
 * 先利用中序遍历构造树，然后再填上值
 */
public class Solution2 {
    ListNode globel;
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while(tmp!=null){
            length++;
            tmp = tmp.next;
        }
        globel = head;
        return buildTree(1,length);
    }

    public TreeNode buildTree(int left,int right){
        if(left==right){
            return new TreeNode();
        }
        if(left>right){
            return null;
        }
        int mid = (left+right+1)/2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left,mid-1);
        root.val = globel.val;
        globel = globel.next;
        root.right = buildTree(mid+1,right);
        return root;
    }
}
