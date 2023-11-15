/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode p = root;
        while(true) {
            ListNode before = p;
            for(int i = 0 ; i < k; i ++) {
                if(p.next != null) {
                    p = p.next;
                    stack.push(p);
                } else return root.next;;
            }
            ListNode after = p.next;
            for(int i = 0 ; i < k ; i ++) {
                p = stack.pop();
                before.next = p;
                before = p;    
            }
            p.next = after;
        }
        // return root.next;
    }
}
