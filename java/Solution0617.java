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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val+ root2.val);
        mergeTrees(root, root1, root2);
        return root;
    }
    private void mergeTrees(TreeNode root, TreeNode root1, TreeNode root2){
        if(root1.left != null && root2.left!= null){
            root.left = new TreeNode(root1.left.val+root2.left.val);
            mergeTrees(root.left, root1.left, root2.left);
        } else if (root1.left == null && root2.left != null) {
            root.left = root2.left;
        } else if (root1.left != null && root2.left == null) {
            root.left = root1.left;
        }

        if(root1.right != null && root2.right!=null) {
            root.right = new TreeNode(root1.right.val + root2.right.val);
            mergeTrees(root.right, root1.right, root2.right);
        } else if( root1.right == null && root2.right!=null){
            root.right = root2.right;
        } else if (root1.right != null && root2.right == null){
            root.right = root1.right;
        }
    }
}
