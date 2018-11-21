class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = res;

        for (int i=0; i<n; i++) {
            pre = pre.next;
        }

        while (pre.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        cur.next = cur.next.next;

        return res.next;

    }

    public static void main(String[] args) {
        ListNode la = new ListNode(1);
        ListNode lb = new ListNode(2);
        ListNode lc = new ListNode(3);

        la.next = lb;
        lb.next = lc;

        Solution solution = new Solution();
        solution.removeNthFromEnd(la, 2);

        while (la != null) {
            System.out.println(la.val);
            la = la.next;
        }
    }
}


// 双指针，时间复杂度O(n)，空间复杂度O(1)
