package www.arithmetic.lianshangshuju.com.leetcode;

/**
 * 环形链表
 *
 * @author : huyining
 * @since :  2020/4/6
 */
public class LinkedListCycle_141 {

    /**
     * 快慢指针实现
     *
     * @param head 节点
     * @return 结果
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        // 俩个节点next都不为空 走下面
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }

        return false;
    }
}
