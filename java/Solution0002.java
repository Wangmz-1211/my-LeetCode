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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            head.val = tmp % 10;
            tmp /= 10;
            if(l1 != null || l2 != null ){
                head.next = new ListNode(0);
                head = head.next;
            }
        }
        if(tmp != 0) head.next = new ListNode(tmp);
        return res;
    }

