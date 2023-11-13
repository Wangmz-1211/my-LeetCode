/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        List<Node> ori = new ArrayList<>();
        List<Node> dup = new ArrayList<>();
        Node p = head;
        while(p!= null) {
            ori.add(p);
            p = p.next;
        }
        for(Node node: ori) {
            dup.add(new Node(node.val));
        }
        for(int i = 0; i < ori.size(); i++ ) {
            Node dupNode = dup.get(i);
            // target index
            Node oriNode = ori.get(i);
            Node oriTarg = oriNode.random;
            if(oriTarg != null) {
                int index = ori.indexOf(oriTarg);
                Node dupTarg = dup.get(index);
                dupNode.random = dupTarg;
            }
            // next
            if(ori.size() - i > 1) {
                dupNode.next = dup.get(i+1);
            }
        }
        return dup.get(0);

    }
}
