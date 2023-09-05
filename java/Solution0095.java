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
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(new TreeNode(1));
        dp.add(null);
        dp.add(list);
        // dp start
        for(int i = 2; i <= n; i++) {
            list = new ArrayList<>();
            dp.add(list);
            // enumerating the val of the root
            for(int root = 1; root <= i; root++){

                // left tree -> [1:lRange]
                // right tree -> [root+1, i]
                // bias = root
                int lLen = root -1;
                int rLen = i - root;

                // get the child trees for inserting to new trees 
                List<TreeNode> lList = dp.get(lLen);
                List<TreeNode> rList = dp.get(rLen);

                // building new tree to add into dp[i][root]

                // 1. When there is no left tree to insert to a new tree,
                // just insert the right trees to the new tree after biasing,
                // and set the left of the new tree with null.
                if(lLen == 0){
                    for(TreeNode rTree: rList){
                        TreeNode rNode = copyTree(rTree, root);
                        TreeNode rootNode = new TreeNode(root, null, rNode);
                        list.add(rootNode);
                    }
                    continue;
                }
                // 2. When there is no right tree to insert to a new tree,
                // just insert the left trees to the new tree without biasing,
                // even without copying, then set the right of the new tree with null.
                if(rLen == 0){
                    for(TreeNode lTree: lList){
                        TreeNode rootNode = new TreeNode(root, lTree, null);
                        list.add(rootNode);
                    }
                    continue;
                }
                // 3. When there the child node shouldn't be null,
                // set the left child with the origin trees in dp,
                // and set the right child with the biased trees.
                for(TreeNode lTree: lList){
                    for(TreeNode rTree: rList){
                        TreeNode rNode = copyTree(rTree, root);
                        TreeNode rootNode = new TreeNode(root, lTree, rNode);
                        list.add(rootNode);
                    }
                }
            }
        }
        return dp.get(n);

    }

    private TreeNode copyTree(TreeNode s, int bias){
        TreeNode t = new TreeNode(s.val + bias);
        copyTree(s, t, bias);
        return t;
    }

    private void copyTree(TreeNode s, TreeNode t, int bias){
        if(s.left != null) {
            t.left = new TreeNode(s.left.val + bias);
            copyTree(s.left, t.left, bias);
        }
        if(s.right != null) {
            t.right = new TreeNode(s.right.val + bias);
            copyTree(s.right, t.right, bias);
        }
    }
}
