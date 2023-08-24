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
    public ListNode deleteDuplicates(ListNode head) {
        
        while(head != null){
            if(head == null || head.next == null) return head;
            if(head.val != head.next.val) break;
            int tmp = head.val;
            ListNode t = head;
            while(head.next != null && head.next.val == tmp) head = head.next;
            if(head != t && head.val == tmp) head = head.next;
        }
        if(head == null) return head;
        ListNode ps = head, pf =head.next;
        int tmp = 101;
        while(pf != null && pf.next != null){
            tmp = pf.val;
            if(pf.next.val == tmp){
                while( pf.next!=null && pf.next.val == tmp){
                    pf = pf.next;
                }
                pf = pf.next;
                ps.next = pf;
            } else {
                pf=pf.next;
                ps=ps.next;
            }
        }
        return head;
    }
}
