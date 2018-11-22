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
        ListNode pre = head;
        ListNode cur = head;

        while (pre!= null && pre.next != null) {
            cur = cur.next;
            pre = pre.next.next;

            if (cur == pre) return true;
        }

        return false;
    }
}
