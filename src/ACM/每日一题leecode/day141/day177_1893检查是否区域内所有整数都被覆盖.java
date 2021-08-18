package ACM.每日一题leecode.day141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class day177_1893检查是否区域内所有整数都被覆盖 {

    public static void main(String[] args) {
//        System.out.println(isCovered(new int[][]{{1, 2},{3, 4},  {5, 6}}, 2, 5));
        System.out.println(isCovered(new int[][]{{1, 50}}, 1, 50));
        System.out.println(isCovered(new int[][]{{13, 43}, {19, 20}, {32, 38}, {26, 33}, {3, 38}, {16, 31}, {26, 48}, {27, 43}, {12, 24}}, 36, 45));
    }

    /***
     * 2021/7/23 wenliang.chen
     * @param ranges
     * @param left
     * @param right
     * @return 覆盖区间则true
     * 方法一:将区间列表排序,从left开始找,之后的不可以中断,直到覆盖了right
     */
    public static boolean isCovered(int[][] ranges, int left, int right) {
        //1.排序
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        int len = 0;
        int[][] newRange = new int[ranges.length][ranges[0].length];
        if (ranges.length==1){
            newRange = ranges;
        }
        //1.1 合并能合并的区间
        for (int i = 0; i < ranges.length - 1; i++) {
            newRange[len][0] = ranges[i][0];
            int maxRight = ranges[i][1];
            while (i<ranges.length-1 && ranges[i][1]>=ranges[i+1][0]-1) {
                i++;
                maxRight = Math.max(maxRight,ranges[i][1]);
            }
            newRange[len][1] = maxRight;
        }
        for (int i = 0; i <= len; i++) {
            System.out.println(Arrays.toString(newRange[i]));
        }
        if (left < newRange[0][0] || right > newRange[len][1]) {
            return false;
        }
        //2.从left开始找到right
        int index = 0;
        while (newRange[index][1] < left) {//找到第一个index[][1]>left
            index++;
        }
        int limit = len;
        while (newRange[limit][0] > right) {
            limit--;
        }
        //从index - limit 需要连续
        for (int i = index; i < limit; i++) {
            if (newRange[index][1] < newRange[index + 1][0] - 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最慢算法,将ranges范围内的整数放list 查找left-right区域的整数是否包含
     * @param ranges
     * @param left
     * @param right
     * @return true:表示全部的整数在range中
     * 17/47%
     */
    public static boolean isCovered2(int[][] ranges, int left, int right) {
        List<Integer> rangesList = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                rangesList.add(j);
            }
        }

        for (int i = left; i <= right; i++) {
            if (!rangesList.contains(i)){
                return false;
            }
        }

        return true;
    }
}
