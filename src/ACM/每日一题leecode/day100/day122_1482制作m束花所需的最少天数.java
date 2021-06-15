package ACM.每日一题leecode.day100;

public class day122_1482制作m束花所需的最少天数 {

    /***
     你一个整数数组 bloomDay，以及两个整数 m 和 k 。
     现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
     请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。

     示例 1：
     输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
     输出：3
     解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
     现在需要制作 3 束花，每束只需要 1 朵。
     1 天后：[x, _, _, _, _]   // 只能制作 1 束花
     2 天后：[x, _, _, _, x]   // 只能制作 2 束花
     3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
     */
    //方法一:假设法,假设i天能够完成花,用min记录 超时84/91
    public static int minDays(int[] bloomDay, int m, int k) {


        int minDay = Integer.MAX_VALUE;
        //假设在第day[i]天能够凑齐花;
        int len = bloomDay.length;

        //对明显不足的进行一个判断
        if (len < m * k) return -1;
        for (int i = 0; i < len; i++) {
            //判断第bloomDay[i]天能不能凑齐
            int tmepDay = bloomDay[i];
            int tempcount = 0;
            int count = 0;
            for (int j = 0; j < len; j++) {
                //只要小于等于tempDay的都可以tempcount++,只要连续等于k了就count++,中断了赋值0
                if (bloomDay[j] <= tmepDay) {
                    tempcount++;
                } else {
                    tempcount = 0;
                }
                if (tempcount == k) {
                    count++;
                    tempcount = 0;
                }
            }

            //将当前的blooday赋值给minday
            if (count != 0 && tmepDay < minDay && count >= m) {
                minDay = tmepDay;
            }
            //count=0;
        }

        return minDay == Integer.MAX_VALUE ? -1 : minDay;
    }

    //方法二:二分法
    public static int minDays2(int[] bloomDay, int m, int k) {


        int minDay = Integer.MAX_VALUE;
        //假设在第day[i]天能够凑齐花;
        int len = bloomDay.length;

        //对明显不足的进行一个判断
        if (len < m * k) return -1;
        for (int i = 0; i < len; i++) {
            //判断第bloomDay[i]天能不能凑齐
            int tmepDay = bloomDay[i];
            int tempcount = 0;
            int count = 0;
            for (int j = 0; j < len; j++) {
                //只要小于等于tempDay的都可以tempcount++,只要连续等于k了就count++,中断了赋值0
                if (bloomDay[j] <= tmepDay) {
                    tempcount++;
                } else {
                    tempcount = 0;
                }
                if (tempcount == k) {
                    count++;
                    tempcount = 0;
                }
            }

            //将当前的blooday赋值给minday
            if (count != 0 && tmepDay < minDay && count >= m) {
                minDay = tmepDay;
            }
            //count=0;
        }

        return minDay == Integer.MAX_VALUE ? -1 : minDay;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }
}
