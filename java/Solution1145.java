/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // no matter which node p1 choose,
        // the tree will be split into 3 parts:
        //      |   
        //      O   like this
        //     / \
        // when p2 choose a node next to the xNode,
        // it can occupy a part of the tree.
        // when the part p2 occupied is more than the other two,
        // p2 win.

        // find x node
        TreeNode xNode = findNode(root, x);
        // countNode(xNode.left, xNode.right)
        int lCount = countNode(xNode.left);
        int rCount = countNode(xNode.right);
        int fCount = n - lCount - rCount -1;
        // check if p2 could win
        if (lCount > 1 + rCount + fCount) return true;
        if (rCount > 1 + lCount + fCount) return true; 
        if (fCount > 1 + rCount + lCount) return true;
        // p2 lose 
        return false;
    }

    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return findNode(root.left,val) == null? 
        findNode(root.right,val): findNode(root.left,val);
    }

    public int countNode(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countNode(root.left) + countNode(root.right) + 1;
    }
}
