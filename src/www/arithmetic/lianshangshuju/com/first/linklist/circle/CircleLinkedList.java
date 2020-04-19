package www.arithmetic.lianshangshuju.com.first.linklist.circle;

import www.arithmetic.lianshangshuju.com.first.linklist.base.AbstractList;

/**
 * 环形链表处理约瑟夫问题
 *
 * @author : huyining
 * @since :  2020/4/10
 */
public class CircleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder circleBuilder = new StringBuilder();
            if (prev != null) {
                circleBuilder.append(prev.element);
            } else {
                circleBuilder.append("null");
            }

            circleBuilder.append("_").append(element);

            if (next != null) {
                circleBuilder.append(next.element);
            } else {
                circleBuilder.append("null");
            }

            return circleBuilder.toString();
        }
    }

    public void reset() {
        current = first;
    }

    public E next() {
        if (current == null) {
            return null;
        }

        current = current.next;
        return current.element;
    }

    /**
     * @return 删除的节点元素
     */
    public E remove() {

        /**
         * 删除current节点并将current节点的指针往后移动一位
         */
        if (current == null) {
            return null;
        }

        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0) {
            current = null;
        } else {
            current = next;
        }
        return element;
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
     * 设置index位置的元素
     *
     * @param index   位置
     * @param element 设置的元素
     * @return 原来的元素
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
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

        // 往最后面添加元素
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<E>(element, oldLast, first);
            if (oldLast == null) {
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }

        } else {

            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<E>(element, prev, next);
            next.prev = node;
            prev.next = node;
            if (next == first) { // index == 0
                first = node;
            }
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
        rangeCheck(index);
        return remove(node(index));
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

    /**
     * 删除元素
     *
     * @param node 节点
     * @return 返回元素数据
     */
    private E remove(Node<E> node) {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            // 前后节点的处理index == 0
            if (node == first) {
                first = next;
            }

            // index == size - 1
            if (node == last) {
                last = prev;
            }
        }

        size--;

        return node.element;
    }


    /**
     * 获取index位置元素
     *
     * @param index 元素位置
     * @return 节点数据
     */
    private Node<E> node(int index) {
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


}
