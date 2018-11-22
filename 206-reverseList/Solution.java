class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;

        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        Solution solution = new Solution();

        ListNode l4 = solution.reverseList(l1);

        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
    }

}


// 时间复杂度O(n) 空间复杂度O(1)

// 递归实现
/*
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

https://blog.csdn.net/FX677588/article/details/72357389
*/
