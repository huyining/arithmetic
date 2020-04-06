package www.arithmetic.lianshangshuju.com.leetcode;

/**
 * 删除链表中的节点
 *
 * @author : huyining
 * @since :  2020/4/6
 */
public class DeleteNodeinaLinkedList_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
