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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if ( root != null) recursive(res, root);
        return res;
    }

    public void recursive(List<Integer> res, TreeNode node) {
        if (node.left != null) recursive(res, node.left);
        if (node.right != null) recursive(res, node.right);
        res.add(node.val);
    }
}
