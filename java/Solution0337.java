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
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        // choose root and children's children
        int m1 = root.val;
        m1 += root.left != null ? rob(root.left.left) + rob(root.left.right): 0;
        m1 += root.right != null? rob(root.right.left) + rob(root.right.right): 0;
        // choose childres
        int m2 = rob(root.left) + rob(root.right);
        int res = Math.max(m1,m2);
        map.put(root, res );
        return res;
    } 
}
