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

/*
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        boolean flag = true;
        while(true) {
            if (p2.next == null) return p1;

            if (flag) {
                p2 = p2.next;
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
            flag = !flag;
        }
    }
}
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pf = head;
        ListNode ps = head;
        while(pf!=null && pf.next!=null){
            pf = pf.next;
            ps = ps.next;
            pf = pf.next;
        }
        return ps;
    }
}
