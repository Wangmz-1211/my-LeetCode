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

    public TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.root = new TreeNode(nums[nums.length/2]);
        handleSort(nums, 0, nums.length/2);
        handleSort(nums, nums.length/2+1, nums.length);
        return root;
    }
    public void handleSort(int[] nums, int head, int tail) {
        if (head == tail) return;
        int half = (tail - head)/2;
        insert(nums[head+ half], root);
        if (half == 0) return;
        handleSort(nums, head, head+ half);
        handleSort(nums, head + half + 1, tail);
    }
    public void insert(int val, TreeNode node) {
        if (val < node.val) {
            if (node. left == null) node.left = new TreeNode( val);
            else insert(val, node.left );
        } else {
            if (node. right == null) node.right = new TreeNode (val);
            else insert(val, node.right);
        }
    }
}
