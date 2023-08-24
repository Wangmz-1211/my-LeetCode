/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) return process(root, p, q);
        return process(root, q, p);
    }
    public TreeNode process( TreeNode root, TreeNode p, TreeNode q) {
        if (root == null
            ||
            root == p
            ||
            root == q) return root;
        // 以下两行为优化代码 当root太离谱时有一边注定找不到 『二叉搜索树』
        if (root.val < p.val ) return process(root.right, p , q);
        if (root.val > q.val ) return process(root.left, p, q);
        TreeNode l = process(root.left, p, q);
        TreeNode r = process(root.right, p, q);
        if( l != null && r != null) return root;
        return l !=null? l : r; 
    }
}
