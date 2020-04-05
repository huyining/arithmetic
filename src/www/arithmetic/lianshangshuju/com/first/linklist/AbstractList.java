package www.arithmetic.lianshangshuju.com.first.linklist;

/**
 * 集合抽象父类
 *
 * @author : huyining
 * @since :  2020/4/5
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素个数
     */
    protected int size;


    /**
     * 元素的数量
     *
     * @return 个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return 判空结果
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element 被包含的元素
     * @return 判断是否包含结果
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 在inde位置插入一个元素
     *
     * @param element 插入元素
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * 数组越界异常
     *
     * @param index 索引
     */
    protected void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 校验索引
     *
     * @param index 索引
     */
    protected void rangeCheck(int index) {
        // 数组中的索引最大为size - 1 当index为size的时候不行
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    /**
     * 添加数据时校验索引
     *
     * @param index 索引
     */
    protected void rangeCheckForAdd(int index) {
        // 添加的时候是可以往index为size地方添加
        if (index < 0 || index > size) {
            outOfBound(index);
        }
    }
}
