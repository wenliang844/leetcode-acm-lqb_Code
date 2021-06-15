package ACM.tag刷题.算法.排序算法;

import sun.security.krb5.internal.crypto.Aes128;

import java.lang.reflect.Array;
import java.util.*;

/***
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 示例 1：
 输入：intervals = [[1,3}, {2,6}, {8,10}, {15,18]]
 输出：[[1,6}, {8,10}, {15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：
 输入：intervals = [[1,4}, {4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class sort_56合并区间 {

    //打印二维数组
    public static void printNums(int nums[][]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }

    //加入数组有序,直接比较每次的交界处
    public static int[][] merge(int[][] intervals) {
        //将交叉的数组加入list
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1) >= intervals[i][0]) {
                //合并
                if (list.get(list.size() - 1) < intervals[i][1]) {
                    list.remove(list.size() - 1);
                    list.add(intervals[i][1]);
                }
            } else {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            }
        }

        //System.out.println(list);
        int[][] newNums = new int[list.size() / 2][2];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i][0] = list.get(i * 2);
            newNums[i][1] = list.get(i * 2 + 1);
        }

        return newNums;
    }

    //无序的数组,两两比较,谁大取谁 or 先排序
    public static int[][] merge2(int[][] intervals) {
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        printNums(intervals);
        System.out.println("");

        //将交叉的数组加入list
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1) >= intervals[i][0]) {//有交叉
                //合并
                if (list.get(list.size() - 1) < intervals[i][1]) {//是交叉而不是包含,包含不用处理
                    list.remove(list.size() - 1);
                    list.add(intervals[i][1]);
                }
            } else {//无交叉


                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            }
        }

        //System.out.println(list);
        int[][] newNums = new int[list.size() / 2][2];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i][0] = list.get(i * 2);
            newNums[i][1] = list.get(i * 2 + 1);
        }

        return newNums;
    }

    public static void main(String[] args) {
        printNums(merge2(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));//[[1,6],[8,10],[15,18]]
        System.out.println("---");
        printNums(merge2(new int[][]{{1, 4}, {4, 5}}));//[[1,6],[8,10],[15,18]]
        System.out.println("---");
        printNums(merge2(new int[][]{{1, 4}, {0, 4}}));//[[1,6],[8,10],[15,18]]
        System.out.println("---");

    }
}
