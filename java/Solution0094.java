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
    List<Integer> res = new LinkedList();
    Stack<TreeNode> stack = new Stack();
    public List<Integer> inorderTraversal(TreeNode root) {
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
        while(!stack.empty()){
            handleNode(stack.pop());
        }
        return res;
    }
    public void handleNode( TreeNode node) {
        res.add(node.val);
        if(node.right != null) handleR(node.right);
    }
    public void handleR(TreeNode node) {
        if (node.left != null) {
            stackLeft(node);
            return;
        }
        handleNode(node);
    }
    public void stackLeft(TreeNode node) {
        stack.add(node);
        while( node.left != null) {
            node = node.left;
            stack.add(node);
        }
    }
}
