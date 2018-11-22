class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode pre = head;
        ListNode cur = head;
        ListNode half = null;

        while (pre != null && pre.next != null) {
            ListNode tmp = cur;
            cur = cur.next;
            pre = pre.next;
            tmp.next = half;
            half = tmp;
            pre = pre.next;
        }

        if (pre!=null) cur = cur.next;

        while (cur != null) {
            if (half.val != cur.val) return false;
            cur = cur.next;
            half = half.next;
        }

        return true;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(l1));
    }
}



// 时间复杂度和空间复杂度均为O(n)
