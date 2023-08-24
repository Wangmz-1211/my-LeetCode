class Solution {
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        int depth = 0;
        queue.offer(root);
        while( true) {
            depth ++;
            int size = queue.size();
            for (int i=0; i< size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return  depth;
                if (node.left!= null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }
}

