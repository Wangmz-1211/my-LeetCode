/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node node = null;
        while(queue.size()!= 0){
            int size = queue.size();
            for(int i=0; i< size; i++){
                node= queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                node.next = queue.peek();
            }
            node.next = null;
        }
        return root;
    }
}
