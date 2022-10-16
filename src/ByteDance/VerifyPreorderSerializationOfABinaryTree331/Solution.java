package ByteDance.VerifyPreorderSerializationOfABinaryTree331;

import java.util.Deque;
import java.util.LinkedList;

/**
 * One way to serialize a binary tree is to use preorder traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as '#'.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        // 用stack来做
        Deque<String> stack = new LinkedList();
        // stack.offerLast()
        // sttack.pollLast()
        String[] sarr = preorder.split(",");
        for(int i = 0;i<sarr.length;i++){
            if(sarr[i].equals("#")){
                while(stack.size() >= 2 && stack.peekLast().equals("#")){
                    stack.pollLast();
                    stack.pollLast();
                    // stack.offerLast("#");
                }
                stack.offerLast("#");
                if(stack.size()==1 && i < sarr.length - 1){
                    return false;
                }
            } else {
                stack.offerLast(sarr[i]);
            }
        }
        return stack.size()==1 && stack.peekLast().equals("#");
    }
}
