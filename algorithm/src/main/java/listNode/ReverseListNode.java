package listNode;
/**
 * 反转链表
 */
public class ReverseListNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode dummyHead = head;
        for (int i = 1; i < 10; i++) {
            dummyHead.next = new ListNode(i);
            dummyHead = dummyHead.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode last;
        while (cur != null) {
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }

        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
