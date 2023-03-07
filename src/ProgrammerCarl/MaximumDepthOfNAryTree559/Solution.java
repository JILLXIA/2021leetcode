package ProgrammerCarl.MaximumDepthOfNAryTree559;

import java.util.List;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level
 * order traversal, each group of children is separated
 * by the null value (See examples).
 */
public class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        int result = 1;
        for(Node child: root.children){
            result = Math.max(result, maxDepth(child) + 1);
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}