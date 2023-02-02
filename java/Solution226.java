class Solution {
    TreeNode tmp;
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null) invert(root.left);
        if(root.right!= null) invert(root.right);
    }
}
