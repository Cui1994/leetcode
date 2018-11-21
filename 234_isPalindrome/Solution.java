class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode pre = res;
        ListNode sec = res;
        ListNode half = new ListNode(0);

        if (pre.next == null || pre.next.next == null) return true;

        while (pre.next != null && pre.next.next != null) {
            pre = pre.next.next;
            sec = sec.next;
            ListNode tmp = new ListNode(sec.val);
            tmp.next = half;
            half = tmp;
        }

        if (pre.next != null) sec = sec.next;

        sec = sec.next;

        while (sec != null) {

            if (sec.val != half.val) return false;

            sec = sec.next;
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



// 时间复杂度和空间复杂度均为O(n),反转链表的部分有瑕疵，待解决。
