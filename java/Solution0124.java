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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathOfNode(root);
        return res;
    }

    private int maxPathOfNode(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = maxPathOfNode(root.left);
        int r = maxPathOfNode(root.right);
        // 0 node connect to root
        int c0 = root.val;
        // 1 node connect to root, get the biggest path
        int c1 = Math.max(c0 + l, c0 + r);
        // 2 node connect to root
        int c2 = c0 + l + r;
        // expose to the upper layer
        int up = Math.max(c0, c1);
        // the possible biggest path
        int rr = Math.max(up, c2);
        res = Math.max(res, rr);
        return up;
    }
}
