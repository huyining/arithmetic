package www.arithmetic.lianshangshuju.com.first.linklist.circle;

import www.arithmetic.lianshangshuju.com.first.linklist.base.AbstractList;

/**
 * 单向环形链表
 *
 * @author : huyining
 * @since :  2020/4/8
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder nodeStr = new StringBuilder();
            nodeStr.append(element).append("_").append(next.element);
            return nodeStr.toString();
        }
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * 获取index位置的元素
     *
     * @param index 元素位置
     * @return 返回的 元素
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     *
     * @param index   位置
     * @param element 设置的元素
     * @return 原来的元素
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    /**
     * 在inde位置插入一个元素
     *
     * @param index   位置
     * @param element 插入元素
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            // 拿到最后一个节点  判断节点是否是一个元素
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        } else {
            // 拿到当前节点的上一个节点
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }

        size++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index 位置
     * @return 返回删除的元素
     */
    @Override
    public E remove(int index) {
        /**
         * index为0?
         *    仅有一个节点
         *      first = null;
         *    有多个节点
         *      最后一个元素 拿到删除后的第一个元素 指针变换
         *
         * index不为0
         *    拿到当前索引的上一个元素
         *    指针变换
         */
        rangeCheck(index);

        Node<E> node = first;

        if (index == 0) {
            if (size == 1) {
                first = null;
            } else {
                Node<E> lastNode = node(size - 1);
                first = first.next;
                lastNode.next = first;
            }
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    /**
     * 查看元素的索引
     *
     * @param element 元素
     * @return 索引
     */
    @Override
    public int indexOf(E element) {

        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置元素
     *
     * @param index 位置
     * @return 元素信息
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
