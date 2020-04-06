package www.arithmetic.lianshangshuju.com.first.linklist.single;

import www.arithmetic.lianshangshuju.com.first.linklist.AbstractList;

/**
 * @author : huyining
 * @since :  2020/4/5
 */
public class SingleLinkList<E> extends AbstractList<E> {

    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
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
        // 获取index位置的元素
        // 将index位置的元素给替换掉
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

        if (index == 0) {
            first = new Node<>(element, first);
        } else {
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

        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
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


    private Node<E> node(int index) {
        // 元素的位置必须小于size的大小
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            // 拿到的是index位置的元素 i只能到index-1
            // node的下一个元素就是index位置的元素
            node = node.next;
        }
        return node;
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

            string.append(node.element);

            node = node.next;
        }
        string.append("]");

        return string.toString();
    }

}
