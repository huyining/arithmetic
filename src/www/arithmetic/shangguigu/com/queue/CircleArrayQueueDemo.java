package www.arithmetic.shangguigu.com.queue;

/**
 * 数组实现的队列
 *
 * @author: huyining
 * @since :    2019-06-17
 */
public class CircleArrayQueueDemo {

    class CircleArray {

        private int maxSize;

        private int front;

        private int rear;

        private int[] arr;

        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        /**
         * 判断队列是不是已经满
         *
         * @return
         */
        public Boolean isFull() {
            return (rear + 1) % maxSize == front;
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

            arr[rear] = n;
            rear = (rear + 1) % maxSize;
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

            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        /**
         * 显示队列中的所有数据
         */
        public void showQueue() {

            if (isEmpty()) {
                System.out.println("对列为空......");
            }

            for (int i = 0; i < maxSize; i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        /**
         * 获取当前对列有效数据的个数
         *
         * @return
         */
        public int size() {
            // rear = 2
            // front = 1
            // maxSize = 3
            return (rear + maxSize - front) % maxSize;
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
