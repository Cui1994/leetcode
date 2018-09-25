
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (l1 != null || l2 != null) {

            if ( l2 == null || (l1!=null && l1.val < l2.val) ) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        return result.next;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(0);
        ListNode b = null;

        Solution s = new Solution();
        ListNode r = s.mergeTwoLists(b, a);

        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

    }
}
