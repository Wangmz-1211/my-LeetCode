/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int num = 0;
        ListNode p1 = headA;
        while(p1.next != null) {
            num ++;
            p1 = p1.next;
        }
        ListNode p2 = headB;
        while(p2.next != null) {
            num --;
            p2 = p2.next;
        }
        if (p1 != p2) return null; 
        if (num > 0) {
            while(num >0) {
                num--;
                headA = headA.next;
            }
        } else if (num< 0) {
            while (num< 0) {
                num++;
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}
