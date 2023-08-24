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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode res = null;
        while (head != null){
            if (head.val != val){
                res = head;
                head = head.next;
                break;
            }
            head = head.next;
        }
        if (res == null) return null;
        ListNode tail = res;
        while( head != null) {
            if (head.val != val) {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        tail.next = null;
        return res;
    }
}
