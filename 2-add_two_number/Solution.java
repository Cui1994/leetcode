class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        int m, n;
        m = ((l1==null?0:l1.val) + (l2==null?0:l2.val))% 10;
        n = ((l1==null?0:l1.val) + (l2==null?0:l2.val)) / 10;
        ListNode current = new ListNode(m);
        result.next =  current;

        while (l1!=null || l2!=null) {

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;

            m = ((l1==null?0:l1.val) + (l2==null?0:l2.val) + n) % 10;
            n = ((l1==null?0:l1.val) + (l2==null?0:l2.val) + n) / 10;

            if (m!=0 || n!=0 || l1!=null || l2!=null){

            current.next = new ListNode(m);
            current = current.next;

            }

        }

        while (n!=0) {
            current.next = new ListNode(n % 10);
            n = n/10;
            current = current.next;
        }

        return result.next;
    }
}



/*
最优解：

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

*/


/*
1. 初始化过程中将current指向result，并将m n 的计算过程放入while循环中可省去中间判断末尾的if操作。
2. 不用直接计算个十位上的数字，直接将对应节点值取出并引入sum即可。
3. l1==null?null:l1.next 的写法实在智障，if (p != null) p = p.next 即可。

/*
