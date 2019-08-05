package www.arithmetic.imooc.com.linkedlist;


/**
 * 链表的递归删除链表中的莫个元素
 *
 * @author: huyining
 * @since: 2019-08-04
 */
public class Solution {

    /**
     * @return
     */
    public static ListNode removeElement(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode res = removeElement(head.next, val);

        ListNode ret;
        // 如果头节点为要删除的节点的话  就返回头节点
        if (head.val == val) {
            ret = res;
        }

        // 头结点不是要删除的节点 讲res前面的节点给返回
        else {
            // 到前面一个节点
            head.next = res;
            ret = head;
        }

        return ret;
    }

    /**
     * @author: huyining
     * @since :    2019-07-25
     */
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        // 链表节点的构造函数
        // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
        public ListNode(int[] arr) {

            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");

            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = removeElement(head, 6);
        System.out.println(res);
    }
}
