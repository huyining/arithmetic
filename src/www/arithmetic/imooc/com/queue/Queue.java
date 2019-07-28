package www.arithmetic.imooc.com.queue;

/**
 * @author: huyining
 * @since: 2019-07-28
 */
public interface Queue<E> {

    /**
     * 获取队列的大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素到队尾
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 获取尾节点
     *
     * @return
     */
    E dequeue();

    /**
     * 获取头节点元素
     *
     * @return
     */
    E getFront();
}
