package www.arithmetic.lianshangshuju.com.first.array;

import org.omg.CORBA.Object;

/**
 * 动态数组
 *
 * @author :  huyining
 * @since :   2019/11/6
 */
public class ArrayList<E> {

    /**
     * 元素的数量
     */
    private int size;
    /**
     * 元素数组
     */
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    public static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有的元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        // 或者直接让size==0 后面获取元素的时候需要做size校验
        // 所以不会拿到数据的
        size = 0;
    }

    /**
     * 获取元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 判断是否包含莫个元素(查看该元素在数组中的位置不等于-1)
     */
    public boolean contains(E element) {
        return index(element) != ELEMENT_NOT_FOUND;
    }


    /**
     * 添加元素到尾部
     */
    public void add(E element) {
        add(size, element);
    }


    /**
     * 获取index位置的元素
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }


    /**
     * 在index位置插入一个元素
     */
    public void add(int index, E element) {
        rangeCheckForAdd(size);
        ensureCapacity(size + 1);
        // 这样的话将size到index位置的元素变为了空 size+1的元素位置设置为element[size]
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     */
    public E remove(int index) {
        rangeCheck(index);

        E oldElement = elements[index];
        for (int i = index + 1; i < size; i++) {
            // 将index+1位置的元素给index  并将后面的往前移动
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return oldElement;

    }


    /**
     * 查看元素的索引
     */
    public int index(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    /**
     * 校验传入的index是否越界
     *
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBound(index);
        }
    }

    /**
     * 获取元素的时候校验index是否越界
     * 当index的位置和size大小相等的情况下
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    /**
     * 数组扩容
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {

        int oldCapacity = elements.length;
        if (oldCapacity > capacity) {
            return;
        }

        // 将数组容量扩大为远来的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为:" + newCapacity);
    }

    /**
     * 抛出数组越界异常
     *
     * @param index
     */
    private void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

}
