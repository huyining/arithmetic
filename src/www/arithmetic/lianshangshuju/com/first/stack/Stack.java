package www.arithmetic.lianshangshuju.com.first.stack;


import www.arithmetic.lianshangshuju.com.first.base.List;

/**
 * @author : huyining
 * @since :  2020/4/12
 */
public class Stack<E> {

    List<E> list = new ArrayList<E>();


    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }
}
