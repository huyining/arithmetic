package www.arithmetic.imooc.com.arrays.ownarray;

/**
 * @author: huyining
 * @since :    2019-07-23
 */
public class Array {

    private int[] data;

    private int size;

    // 构造函数 根据传入的大小构建数组
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造  默认大小为10
    public Array() {
        this(10);
    }

    // 获取数组大小
    public int getCapacity() {
        return data.length;
    }


    // 获取数组中元数的个数
    public int getSize() {
        return size;
    }

    // 判断数组是不是为空
    public Boolean isEmpty() {
        return size == 0;
    }
}
