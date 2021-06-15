package ACM.leecode周赛.第239场周赛;

import java.util.Arrays;

public class lee4_5748包含每个查询的最小区间 {

    /***
     给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
     再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
     以数组形式返回对应查询的所有答案。
     示例 1：
     输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
     输出：[3,3,1,4]
     解释：查询处理如下：
     - Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
     - Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
     - Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
     - Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minInterval2(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
    }

    //暴力手段:按照长度进行排序,一个一个查询,再用数组装起来返回 预计超时 34/42
    public static int[] minInterval(int[][] intervals, int[] queries) {

        //创建一个数组保存interver的所有的大小长度,然后进行冒泡排序
        int len = intervals.length;
        int helper[] = new int[len];
        for (int i = 0; i < len; i++) {
            helper[i] = intervals[i][1] - intervals[i][0] + 1;
        }

        for (int i = 0; i < len; i++) {
            //每次选一个最小的进行交换
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (helper[j] < helper[min]) {
                    min = j;
                }
            }
            if (min != i) {
                //交换
                int temp = helper[min];
                helper[min] = helper[i];
                helper[i] = temp;

                //交换interver
                int temp1 = intervals[min][0];
                int temp2 = intervals[min][1];
                intervals[min][0] = intervals[i][0];
                intervals[min][1] = intervals[i][1];
                intervals[i][0] = temp1;
                intervals[i][1] = temp2;
            }
        }

        //System.out.println(Arrays.toString(helper));
        /*for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }*/

        int answer[] = new int[queries.length];
        //进行遍历暴力
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            answer[i] = -1;
            //在interver中对query进行查询
            for (int j = 0; j < len; j++) {
                if (intervals[j][0] <= query && intervals[j][1] >= query) {
                    answer[i] = helper[j];
                    break;
                }
            }
        }

        //System.out.println("answer is==" + Arrays.toString(answer));

        return answer;
    }

    //方法二:不排序,直接暴力扫描,保存最小的min长度 34/42
    public static int[] minInterval2(int[][] intervals, int[] queries) {

        int answer[] = new int[queries.length];
        //进行遍历暴力
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int query = queries[i];
            answer[i] = -1;
            //在interver中对query进行查询
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] <= query && intervals[j][1] >= query) {
                    min = Math.min(intervals[j][1] - intervals[j][0] + 1, min);
                }
            }
            if (min == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = min;
            }
        }

        //System.out.println("answer is==" + Arrays.toString(answer));

        return answer;
    }
}
