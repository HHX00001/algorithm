package cn.hhx.algorithm.array;


/**
 * 稀疏数组的存取
 *
 * @author hhxStellar
 * @date 2021/9/30-23:37
 */
public class SpareArray {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];//二维数组
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][9] = 22;
        chessArray[6][6] = 1;
        System.out.println("---------原始数组为: -------------");
        for (int[] row : chessArray) {//打印二维数组
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 将二维数组转化为稀疏数组
         */
        //先计算有多少值
        int sum = 0;
        for (int[] row : chessArray) {
            for (int data : row) {
                if (data != 0)
                    sum++;
            }
        }
        System.out.println("--------总共有" + sum + "个数---------");


        //创建一个二维数组（2×3）记录原数组，用来记录原数组的信息
        //有多少个有效数（非零）就创建多少行，
        //但在第一行要加一行，用来记录原数组信息（原数组行数，列数，非零数个数）
        //剩下的普通行记录非零数信息（所在行，列，值）

        //总共非零数个数+1行，第一行记录原始数组的行列数，以及一共有多少非零数据。
        //剩下的行数记录横纵坐标以及数据的值
        int[][] spareArray = new int[sum + 1][3];
        spareArray[0][0] = 11;
        spareArray[0][1] = 11;
        spareArray[0][2] = 2;

        int count = 0;//用于记录是第几个非零数据
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("-----打印稀疏数组---");

        for (int i = 0; i < spareArray.length; i++) {
            System.out.printf("%-2d %-2d %-2d", spareArray[i][0], spareArray[i][1], spareArray[i][2]);
            System.out.println();
        }

        //稀疏数组转为正常数组
        System.out.println("-------打印还原的数组--------");
        int row = spareArray[0][0];
        int column = spareArray[0][1];
        int[][] reChessArray = new int[row][column];
        for (int i = 1; i < spareArray.length; i++) {
            int notZeroRow = spareArray[i][0];
            int notZeroColumn = spareArray[i][1];
            int data = spareArray[i][2];
            reChessArray[notZeroRow][notZeroColumn] = data;
        }

        //打印正常数组
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%-2d ", reChessArray[i][j]);
            }
            System.out.println();
        }
    }
}
