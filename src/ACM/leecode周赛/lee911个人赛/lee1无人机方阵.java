package ACM.leecode周赛.lee911个人赛;

import java.util.HashMap;
import java.util.Map;

public class lee1无人机方阵 {

    public static void main(String[] args) {
        System.out.println(minimumSwitchingTimes(new int[][]{{1, 3}, {5, 4}}, new int[][]{{3, 1}, {6, 5}}));
        System.out.println(minimumSwitchingTimes(new int[][]{{1, 2,3}, {3,4, 5}}, new int[][]{{ 1,3,5}, {2, 3,4}}));
    }
    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                countMap.put(source[i][j],countMap.getOrDefault(source[i][j],0)+1);
            }
        }
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                    countMap.put(target[i][j],countMap.getOrDefault(target[i][j],0)-1);
            }
        }

        int count = 0;
        for (Integer value : countMap.values()) {
            if (value>0){
                count += value;
            }
        }

        return count;
    }
}
