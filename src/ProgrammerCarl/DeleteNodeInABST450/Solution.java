package ProgrammerCarl.DeleteNodeInABST450;

import 树.TreeNode;

/**
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                TreeNode curr = root.right;
                while(curr.left!=null){
                    curr = curr.left;
                }
                root.right = deleteNode(root.right, curr.val);
                root.val = curr.val;
            }
        }
        return root;
    }
}
