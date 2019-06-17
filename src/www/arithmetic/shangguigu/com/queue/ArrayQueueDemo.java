package www.arithmetic.shangguigu.com.queue;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 数组实现的队列
 *
 * @author: huyining
 * @since :    2019-06-17
 */
public class ArrayQueueDemo {

    class ArrayQueue {

        private int maxSize;

        private int front;

        private int rear;

        private int[] arr;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            this.front = -1;
            this.rear = -1;
            arr = new int[maxSize];
        }

        /**
         * 判断队列是不是已经满
         *
         * @return
         */
        public Boolean isFull() {
            return rear == maxSize - 1;
        }

        /**
         * 判断队列是不是空
         *
         * @return
         */
        public Boolean isEmpty() {
            return front == rear;
        }

        /**
         * 想队列中添加元素
         *
         * @param n
         */
        public void addQueue(int n) {

            if (isFull()) {
                System.out.println("队列已满, 不能够再去添加元素....");
                return;
            }

            rear++;
            arr[rear] = n;
        }

        /**
         * 从队列中获取元素
         *
         * @return
         */
        public int getQueue() {

            if (isEmpty()) {
                throw new RuntimeException("队列为空,无法获取到元素......");
            }

            front++;
            return arr[front];
        }

        /**
         * 显示队列中的所有数据
         */
        public void showQueue() {

            if (isEmpty()) {
                System.out.println("对列为空......");
            }

            for (int i = 0; i < maxSize; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        /**
         * 显示头元素
         *
         * @return
         */
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("");
            }
            return arr[front + 1];
        }
    }

}
