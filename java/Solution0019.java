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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode cur = head;
        int count = 1;
        while(cur.next!=null) {
            cur = cur.next;
            count++;
        }
        if(count == n) return head.next;
        cur = head;
        count=count - n - 1;
        while( count-->0 ){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = size(head);
        return removeNthFromStart(head, sz - n);
    }
    public int size(ListNode head) {
        int sz = 0;
        ListNode p = head;
        while(p != null ) {
            p = p.next;
            sz++;
        }
        return sz;
    }
    public ListNode removeNthFromStart(ListNode head, int n) {
        if(n == 0) return head.next;
        ListNode p = head;
        for(int i = 0 ; i < n-1 ; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
