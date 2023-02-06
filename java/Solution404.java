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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null ) return 0;
        if (isLeftLeafVal(root.left)) {
            return sumOfLeftLeaves(root.right) + root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    public boolean isLeftLeafVal(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
