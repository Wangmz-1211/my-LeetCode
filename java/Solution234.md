根据计数，将原链表倒序，再进行比较 （需要多次遍历，虽然O(n) 但是常数项比较大）
~~~java
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
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null) return true;
        // count length
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count ++;
            cur = cur.next;
        }
        // find middle
        ListNode pl = head;
        for(int i = 0;i < count/2-1;i++) {
            pl = pl.next;
        }
        ListNode pr = count%2==1? pl.next.next:pl.next;
        // reverse left one
        pl.next = null;
        reverse(head);
        // check res
        while(pr != null){
            if (pr.val != pl.val) return false;
            pr = pr.next;
            pl = pl.next;
        }
        return true;
        // resume structure;
    }
    /**
    * reverse the linked list
    */
    public void reverse(ListNode head) {
        // 0 or 1 node
        if(head == null || head.next ==null) return;
        ListNode tmp = head.next;
        head.next = null;
        // 2 nodes
        if (tmp.next == null){
            tmp.next = head;
            return;
        }
        // 3+ nodes
        recursive(head, tmp, tmp.next);
    }
    public void recursive(ListNode p1, ListNode p2, ListNode p3) {
        p2.next = p1;
        if (p3.next ==null) {
            p3.next = p2;
            return;
        }
        recursive(p2, p3, p3.next);
    }
}
~~~
快慢指针，在遍历同时直接将原链表倒序，减少遍历次数
~~~java
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
    public boolean isPalindrome(ListNode head) {
        if ( head == null || head.next == null) return true;
        ListNode pf = head;
        ListNode ps = head;
        ListNode cur = null;
        ListNode pre = null;
        //first step 
        cur = ps;
        ps = ps.next;
        pf = pf.next.next;
        pre = ps;
        while (pf != null && pf.next != null) {
            pf = pf.next.next;
            ps = ps.next;
            pre.next = cur;
            cur = pre;
            pre = ps;
        }
        if (pf != null) {
            ps = ps.next;
        }    
        while (ps != null) {
            if (ps.val != cur.val) return false;
            ps = ps.next;
            cur = cur.next;
        }
        return true;
    }
}
~~~

