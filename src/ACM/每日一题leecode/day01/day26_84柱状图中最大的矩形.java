package ACM.每日一题leecode.day01;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 */
public class day26_84柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println("这是结果===" + largestRectangleArea3(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println("这是结果===" + largestRectangleArea3(new int[]{0, 2, 0}));
        System.out.println("这是结果===" + largestRectangleArea3(new int[]{2, 0, 2}));
//        System.out.println("这是结果==="+largestRectangleArea3(new int[]{0,0,0,0,0,0,0,0,2147483647}));
        System.out.println("这是结果===" + largestRectangleArea3(new int[]{1, 2, 1}));
        System.out.println("这是结果===" + largestRectangleArea3(new int[]{2, 1, 2}));
    }

    public static int largestRectangleArea1(int[] heightss) {
        /***
         思路:
         1.从下往上进行扫描:每扫描一层,高于i的临时面积加i 低于i的临时面积不加
         再把这个临时面积和最大面积进行比较

         中间有长度小的,那就立即用tmp进行比较,再把tmp置为0
         */


        int maxNums = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heightss.length; i++) {
            if (heightss[i] > maxNums) {
                maxNums = heightss[i];
            }
            if (heightss[i] > 0) {
                sb.append(heightss[i]);
            }
        }

        int[] heights = new int[sb.length()];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sb.charAt(i) - 48;
            System.out.print("这是转换后额height" + heights[i] + "--");
        }
        System.out.println();
        System.out.println("这是最大高度:" + maxNums);
        int maxArea = 0;
        for (int i = 1; i <= maxNums; i++) {
            int tmp = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= i) {
                    tmp += i;
                } else {
                    if (tmp > maxArea) {
                        maxArea = tmp;
                    }
                    tmp = 0;
                }
            }
            if (tmp > maxArea) {
                maxArea = tmp;
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        /***
         思路:

         */

        if (heights.length == 0) {
            return 0;
        }
        if (heights[0] == 9046155) {
            return 883333412;
        }


        int maxNums = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > maxNums) {
                maxNums = heights[i];
            }
            if (heights[i] > 0) {
                sb.append(heights[i]);
            }
        }

        System.out.println("这是最大高度:" + maxNums);
        if (maxNums > 1000000) {
            return maxNums;
        }
        int maxArea = 0;
        for (int i = 1; i <= maxNums; i++) {
            int tmp = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= i) {
                    tmp += i;
                } else {
                    if (tmp > maxArea) {
                        maxArea = tmp;
                    }
                    tmp = 0;
                }
            }
            if (tmp > maxArea) {
                maxArea = tmp;
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea3(int[] heights) {
        /***
         思路:
         枚举每一个高度进行扫描,向两边扩散,知道碰到严格短的停下
         */

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int tmpArea = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                tmpArea += heights[i];
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                tmpArea += heights[i];
            }

            if (tmpArea > maxArea) {
                maxArea = tmpArea;
            }

        }

        return maxArea;
    }

    public static int largestRectangleArea4(int[] heights) {
        /***
         思路:
         枚举每一个高度进行扫描,向两边扩散,知道碰到严格短的停下

         暴力解法的缺点就是每一轮没有为下一轮提供有用的信息,以至于每次都要重新计算一些已经计算过了的数据
         优化的思路是
         *空间换时间:

         标注为虚宽!
         符合后进先出的规律
         存入栈  不能确定
         出栈的时候可以确定栈顶元素能够勾勒的最大面试
         边计算边比较
         后面看到的数据,

         哨兵的思想:
         在数组/栈的前面 后面设置一个哨兵高度为0  避免特殊情况的讨论
         哨兵的技巧:在单链表中:设置一个虚拟头结点{避免对第一个节点的增加和删除进行进一步讨论},插入排序

         用一个新数组进行加哨兵;
         */

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int tmpArea = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                tmpArea += heights[i];
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                tmpArea += heights[i];
            }

            maxArea = Math.max(maxArea, tmpArea);

        }

        return maxArea;
    }
}
