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
    int res;
    public int closestValue(TreeNode root, double target) {
        res = root.val;
        return solve(root, target);
    }
    public int solve(TreeNode root, double target) {
        if ( root == null) return -1;
        double d1 = Math.abs(target - root.val);
        double d2 = Math.abs(target - res);
        if ( d2 > d1) res = root.val;
        TreeNode tmp;
        if ( target >= root.val ) tmp = root.right;
        else tmp = root.left;
        if (tmp == null) return res;
        return solve(tmp, target);
    }
}
