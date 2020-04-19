package www.arithmetic.lianshangshuju.com.first.base;

/**
 * 链表接口
 *
 * @author : huyining
 * @since :  2020/3/15
 */
public interface List<E> {

    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     *
     * @return 个数
     */
    int size();

    /**
     * 是否为空
     *
     * @return 判空结果
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     *
     * @param element 被包含的元素
     * @return 判断是否包含结果
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     *
     * @param elemet 添加的元素
     */
    void add(E elemet);

    /**
     * 获取index位置的元素
     *
     * @param index 元素位置
     * @return 返回的 元素
     */
    E get(int index);

    /**
     * 设置index位置的元素
     *
     * @param index   位置
     * @param element 设置的元素
     * @return 原来的元素
     */
    E set(int index, E element);

    /**
     * 在inde位置插入一个元素
     *
     * @param index   位置
     * @param element 插入元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     *
     * @param index 位置
     * @return 返回删除的元素
     */
    E remove(int index);

    /**
     * 查看元素的索引
     *
     * @param element 元素
     * @return 索引
     */
    int indexOf(E element);
}
