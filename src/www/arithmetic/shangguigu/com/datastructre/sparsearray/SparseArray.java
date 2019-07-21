package www.arithmetic.shangguigu.com.datastructre.sparsearray;

/**
 * 稀疏数组
 *
 * @author: huyining
 * @since :    2019-06-14
 */
public class SparseArray {

    /**
     * 应用:
     * 使用稀疏数组来保存类似, 二维数组, 棋盘, 地图等先关数据
     * 能够将稀疏数组存盘, 并且能够重新恢复原来的二维数组(NIO实现)
     */
    public static void main(String[] args) {
        /**
         * 创建一个二维数组
         *   11 * 11
         *   0表示空白 1表示黑子 2表示蓝子
         */
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 3;

        System.out.println("输出原始的二维数组");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 二维数组转化成稀疏数组
         *  1: 遍历二维数组, 得到非0的个数,
         *  2: 创建对应的稀疏数组
         *  3: 遍历二维数组, 将非零的数值放入稀疏数组中去
         */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("得到的稀疏数组为:....");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        /**
         * 稀疏数组转化为二维数组
         *   1: 先读取稀疏数组的第一行数据, 根据第一行的数据来创建原始的二维数组
         *   2: 读取稀疏数组的后几行数据, 然后赋值给原始的二维数组
         */

        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println(); System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
