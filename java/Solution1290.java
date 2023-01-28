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
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while( head != null) {
            if (head.val == 0)  num<<=1;
            else {
                num<<=1;
                num++;
            }
            head = head.next;
        }
        return num;
    }
}
