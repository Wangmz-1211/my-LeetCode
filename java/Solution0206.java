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
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = null;
        if( tmp.next == null) {
            tmp.next = head;
            return tmp;
        }
        return recursive(head, tmp, tmp.next);
    }
    /**
    this method can be used only when p1 p2 p3 != null
    original :  <-(p1)  (p2)->(p3)->(p4)
    reversed :  <-(p1)<-(p2)  (p3)->(p4)
    edge     :  <-(p1)<-(p2)<-(p3)
    */
    public ListNode recursive(ListNode p1, ListNode p2, ListNode p3){
        p2.next = p1;
        if( p3.next == null) {
            p3.next = p2;
            return p3;
        }
        return recursive(p2,p3,p3.next);
    }
}
