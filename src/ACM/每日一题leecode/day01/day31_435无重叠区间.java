package ACM.每日一题leecode.day01;

public class day31_435无重叠区间 {

    public static void printNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sortByI(int[][] intervals) {

        for (int i = 1; i < intervals.length; i++) {
            int temp = intervals[i][0];//临时变量 保存num[i]的值
            int temp2 = intervals[i][1];//保存1这边的值

            int j = i;//从已经排序的序列最右边开始比较 找到小的值
            //将这个数后移
            while (j > 0 && temp < intervals[j - 1][0]) {
                intervals[j][0] = intervals[j - 1][0];
                intervals[j][1] = intervals[j - 1][1];
                j--;
            }

            //存在更小的值 插入
            //如果不存在 就不插入
            if (j != i) {//加不加判断都一样  若是没找到,j就不会一定
                intervals[j][0] = temp;
                intervals[j][1] = temp2;
            }

            //System.out.println("第"+i+"轮插入后=");
            //printNums(nums);
        }
    }

    public static void sortByJ_shengxu(int[][] intervals) {

        for (int i = 1; i < intervals.length; i++) {
            int temp = intervals[i][1];//临时变量 保存num[i]的值
            int temp2 = intervals[i][0];//保存1这边的值

            int j = i;//从已经排序的序列最右边开始比较 找到小的值
            //将这个数后移
            while (j > 0 && temp < intervals[j - 1][1]) {
                intervals[j][1] = intervals[j - 1][1];
                intervals[j][0] = intervals[j - 1][0];
                j--;
            }

            //存在更小的值 插入
            //如果不存在 就不插入
            if (j != i) {//加不加判断都一样  若是没找到,j就不会一定
                intervals[j][1] = temp;
                intervals[j][0] = temp2;
            }

            //System.out.println("第"+i+"轮插入后=");
            //printNums(nums);
        }
    }

    public static void sortByJ(int[][] intervals) {

        boolean flag = false;
        for (int i = 0; i < intervals.length; ) {
            int j = i + 1;
            while (j < intervals.length) {
                if (intervals[j][0] == intervals[i][0]) {
                    j++;
                    flag = true;
                } else {
                    if (flag) {
                        sortByJpart(intervals, i, j - 1);
                    }
                    break;
                }
            }
            i = j;
            flag = false;
        }
    }

    public static void sortByJpart(int[][] intervals, int start, int end) {

        for (int i = start; i <= end - 1; i++) {
            for (int j = start + 1; j <= end; j++) {
                if (intervals[j][1] < intervals[i][1]) {
                    //可交换
                    int temp = intervals[i][0];
                    int temp2 = intervals[i][1];
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = temp;
                    intervals[j][1] = temp2;

                }
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println("这是结果==============="+eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        //System.out.println("这是结果============="+eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        //System.out.println("这是结果=============="+eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        //System.out.println("这是结果=============="+eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println("这是结果==============" + eraseOverlapIntervals_2(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
        System.out.println("这是结果==============" + eraseOverlapIntervals_2(new int[][]{{-100, -87}, {-99, -44}, {-98, -19}, {-97, -33}, {-96, -60}}));
        System.out.println("这是结果==============" + eraseOverlapIntervals_2(new int[][]{{1,2}}));
        System.out.println("这是结果==============" + eraseOverlapIntervals_2(new int[][]{}));
        System.out.println("这是结果==============---" + eraseOverlapIntervals_2(new int[][]{{1,2},{1,2},{1,2}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        printNums(intervals);
        System.out.println("i排序后---");
        sortByI(intervals);
        printNums(intervals);
        System.out.println("j排序后---");
        sortByJ(intervals);
        printNums(intervals);

        int count = 0;
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[j][0] < intervals[i][1]) {
                count++;
                j++;
            } else {
                i = j;
                j++;
                //break;
            }
        }
        return count;

    }

    public static int eraseOverlapIntervals_2(int[][] intervals) {
        /***
         贪心策略，先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。

         在每次选择中，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。

         按区间的结尾进行升序排序，每次选择结尾最小，并且和前一个区间不重叠的区间。

         在对数组进行排序的时候也可以使用 lambda 表示式来创建 Comparator ，不过算法运行时间会比较长点。
         */
        if(intervals.length == 0){
            return 0;
        }

        printNums(intervals);
        //System.out.println("i排序后---");
        //sortByI(intervals);
        //printNums(intervals);
        System.out.println("j排序后---");
        sortByJ_shengxu(intervals);
        printNums(intervals);

        int count = 1;
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[j][0] >= intervals[i][1]) {
                count++;
                i = j;
                j++;
            } else {
                //i = j;
                j++;
                //break;
            }
        }
        return intervals.length-count;

    }

}
