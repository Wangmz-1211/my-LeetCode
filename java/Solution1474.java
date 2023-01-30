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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while(cur != null) {
            for ( i = 1; i< m; i++){
                if( cur == null) break;
                cur = cur.next;
            }
            if( cur == null) break;
            pre = cur;
            for ( i = 0; i<= n; i++) {
                if( cur == null) break;
                cur = cur.next;
            }
            pre.next = cur;
            pre = null;
        }
        if (pre != null) pre.next = null;
        return head;
    }
}
