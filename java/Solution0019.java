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
