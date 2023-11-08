/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fp = head;
        ListNode sp = head;
        while( fp != null) {
            if (fp.next == null) return false;
            fp = fp.next.next;
            sp = sp.next;
            if(fp == sp) return true;
        }
        return false;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode pf = head, ps = head;
        while(pf != null && ps != null) {
            pf = pf.next;
            if(pf == null) return false;
            else pf = pf.next;
            if(pf == null) return false;
            ps = ps.next;
            if(ps == null) return false;
            if(pf == ps ) return true;
        }
        return false;
    }
}
