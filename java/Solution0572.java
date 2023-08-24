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
    TreeNode subRoot;
    int top;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.subRoot = subRoot;
        this.top = subRoot.val;
        return process(root);
    }
    private boolean process(TreeNode root) {
        if(root == null) return false;
        if(root.val == top) {
            if(check(subRoot, root)) return true;
        }
        return process(root.right) || process(root.left);

    }

    /**
    Check if two tree has the same katachi
    root1 is the subject one
     */
    private boolean check(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null ) return true;
        if(root1 == null || root2 == null ) return false;
        if(root1.val == root2.val) {
            return check(root1.right, root2.right) && check(root1.left, root2.left);     
        }
        return false;
    }
}
