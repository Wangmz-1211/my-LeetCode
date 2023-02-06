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

    List<String> list = new LinkedList<> ();
    public List<String> binaryTreePaths(TreeNode root) {
        // 递归，对叶节点进行遍历
        // 递归中，需要将路径信息进行传递
        // 如果有两个子节点，则会产生两个路径
        // 解决方案：放入全局变量LinkedList中
        findRoute(root, new StringBuilder());
        return list;
    }

    /**
    * 对叶节点进行遍历
    */
    public void findRoute(TreeNode root, StringBuilder sb) {
        if (!sb.isEmpty()) sb.append("->");
        sb.append(root.val);
        if (root.left == null && root.right == null){
            list.add(sb.toString());
            return;
        }
        // 这里不能直接将sb传递，因为是引用传递
        if (root.left != null){
            findRoute(root.left, new StringBuilder(sb));
        }
        if (root.right != null) {
            findRoute(root.right, new StringBuilder(sb));
        }
    }
}
