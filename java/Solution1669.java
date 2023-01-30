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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        b -=a;
        ListNode pre = list1;
        while(a > 1) {
            pre = pre.next;
            a --;
        }
        ListNode tail = pre;
        while(b >= 0) {
            tail = tail.next;
            b--;
        }
        tail = tail.next;
        pre.next = list2;
        while (list2.next!=null) list2 = list2.next;
        list2.next = tail;
        return list1;
    }
}
