package www.arithmetic.lianshangshuju.com.leetcode;

/**
 * 链表翻转
 *
 * @author : huyining
 * @since :  2020/4/6
 */
public class ReverseLinkedList_206 {

    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
