package www.arithmetic.lianshangshuju.com.first.queue;


import www.arithmetic.lianshangshuju.com.first.base.LinkedList;
import www.arithmetic.lianshangshuju.com.first.base.List;

public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
