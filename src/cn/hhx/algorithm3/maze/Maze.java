package cn.hhx.algorithm3.maze;

/**
 * 递归找出口
 * 深度优先
 * 考虑一下广度优先
 *
 * @author hhxStellar
 * @date 2021/10/7-16:42
 */
public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        System.out.println("---------初始化地图--------");
        showMap(map);
        System.out.println("---------走过后的地图------------");
        findWap(map, 1, 1);
        showMap(map);
    }

    /**
     * @param map 传入地图
     * @param i
     * @param j   从哪个位置开始找
     * @return 找到就返回true，找不到就返回false
     */
    public static boolean findWap(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//说明找到出口了
            return true;
        } else {
            if (map[i][j] == 0) {//当前点还没走过
                map[i][j] = 2;
                if (findWap(map, i + 1, j)) {//向下
                    return true;
                } else if (findWap(map, i, j + 1)) {//向右走
                    return true;
                } else if (findWap(map, i - 1, j)) {//向上走
                    return true;
                } else if (findWap(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {//1(墙),2(走过了),3(走不通)
                return false;
            }
        }
    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
