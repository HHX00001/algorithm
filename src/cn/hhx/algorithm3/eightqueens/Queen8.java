package cn.hhx.algorithm3.eightqueens;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hhxStellar
 * @date 2021/10/7-17:54
 */
public class Queen8 {
    List<int[]> mapList = new ArrayList<>();

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        int[] map = new int[8];
        queen8.put(0, map);
        for (int[] mapItem : queen8.mapList) {
            for (int i = 0; i < mapItem.length; i++) {
                System.out.print(mapItem[i] + " ");
            }
            System.out.println();
        }
        System.out.println(queen8.mapList.size());
    }

    private void put(int n, int[] map) {
        if (n == 8) {
            mapList.add(map);
            return;
        }
        for (int i = 0; i < 8; i++) {
            int[] cloneMap = map.clone();
            cloneMap[n] = i;
            if (!isConflict(n, cloneMap)) {
                put(n + 1, cloneMap);
            }
        }
    }

    private boolean isConflict(int n, int[] map) {
        for (int i = 0; i < n; i++) {
            if (map[i] == map[n] || Math.abs(n - i) == Math.abs(map[i] - map[n])) {
                return true;
            }
        }
        return false;
    }
}
