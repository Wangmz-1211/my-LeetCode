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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode before = null, after = null;
        ListNode p = new ListNode(0);
        p.next = head;

        int index = 0;
        while(p!= null) {
            if(index == left-1) before = p;
            if(index == right+1) after = p; 
            index++;
            p = p.next;
        }
        if( index == right+1) after = p;
        p = before.next;

        for(int i = 0 ; i <= right - left; i++) {
            stack.push(p);
            p = p.next;
        }

        p = before;
        for(int i = 0; i <= right - left; i ++) {
            ListNode node = stack.pop();
            p.next = node;
            node.next = null;
            p = node;
        }
        p.next = after;
        if(left == 1) head = before.next;
        return head;
    }
}
