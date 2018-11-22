class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;

        while (pre != null && pre.next !=null) {
            cur = cur.next;
            pre = pre.next.next;
        }

        return cur;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        Solution solution = new Solution();

        ListNode res = solution.middleNode(l1);

        System.out.println(res.val);
    }
}


