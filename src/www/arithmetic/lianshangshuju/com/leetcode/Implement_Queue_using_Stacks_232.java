package www.arithmetic.lianshangshuju.com.leetcode;


import java.util.Stack;

/**
 * 使用俩个栈实现队列
 *
 * @author : huyining
 * @since :  2020/4/19
 */
public class Implement_Queue_using_Stacks_232 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public Implement_Queue_using_Stacks_232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        checkOutStackEmpty();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        checkOutStackEmpty();
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 判断
     */
    private void checkOutStackEmpty() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

}
