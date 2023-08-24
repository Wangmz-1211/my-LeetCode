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
        if (root == null) return root;
        Node cur = root;
        Node dummy = new Node(0);
        Node pre = dummy;
        while(cur != null){
            if(cur.left != null){
                pre.next = cur.left;
                pre = pre.next;
            }
            if(cur.right != null){
                pre.next = cur.right;
                pre = pre.next;
            }
            if(cur.next !=null) cur = cur.next;
            else {
                cur = dummy.next;
                dummy= new Node(0);
                pre = dummy;
            }
        }
        return root;

    }
}
