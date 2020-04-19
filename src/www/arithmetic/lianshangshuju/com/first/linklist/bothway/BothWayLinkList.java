package www.arithmetic.lianshangshuju.com.first.linklist.bothway;

import www.arithmetic.lianshangshuju.com.first.linklist.base.AbstractList;


/**
 * 双向链表
 *
 * @author : huyining
 * @since :  2020/4/6
 */
public class BothWayLinkList<E> extends AbstractList<E> {

    private Node<E> first;

    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder nodeBuilder = new StringBuilder();

            if (prev != null) {
                nodeBuilder.append(prev.element);
            } else {
                nodeBuilder.append("null");
            }

            nodeBuilder.append("_").append(element).append("_");

            if (next != null) {
                nodeBuilder.append(next.element);
            } else {
                nodeBuilder.append("null");
            }

            return nodeBuilder.toString();
        }
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
     * 设置index位置的元素  将之前的元素给替换掉
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

        // 往链表尾部添加元素
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            // 如果链表中没有节点  这就是第一个节点
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }

        } else {
            // 往链表中间添加元素
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            node.prev = node;

            // 如果index为0的话 前面就没有元素
            if (prev == null) {
                first = node;
            } else {
                prev.next = node;
            }
        }
        size ++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index 位置
     * @return 返回删除的元素
     */
    @Override
    public E remove(int index) {
        // 拿到前后节点  然后变换前后节点的指针
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        // 删除节点是第一个节点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        // 删除节点是最后一个节点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
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
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置的元素
     *
     * @param index 索引位置
     * @return 节点
     */
    private Node<E> node(int index) {

        /**
         * 1: 判断下是否越界 index不能等于size
         * 2: 判断下索引在前还是在后
         *     前: 从前往后遍历
         *     后: 从后往前遍历
         */

        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

            return node;
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
