package ACM.每日一题leecode.day100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class day133_1035不相交的线 {
    /*****
     在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
      nums1[i] == nums2[j]
     且绘制的直线不与任何其他连线（非水平线）相交。
     请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     以这种方法绘制线条，并返回可以绘制的最大连线数。
     示例 1：
     输入：nums1 = [1,4,2], nums2 = [1,2,4]
     输出：2
     解释：可以画出两条不交叉的线，如上图所示。
     但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
     */
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines2(new int[]{1,4,2}, new int[]{1,2,4}));//2
        System.out.println(maxUncrossedLines2(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));//3
        System.out.println(maxUncrossedLines2(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));//2
    }

    //方法一:暴力破解
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        /**思路:
         1.创建一个二维数组,fill -1,当相等的时候,将左下,上右的全部+1,自己=个数
         2.建立 (i,j) count键值对,按照count递减,取第一个count的ij,将自己置-1,左下,右上的统统置-1;
         3.直到count=0;结束,return map.count
         */
        //一个优先对列,保存ij下标,根据ij的值进行排序
        int row = nums1.length;
        int col = nums2.length;
        int[][] graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(graph[i], -1);
        }

        //能保证第一个总是最大的
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return graph[t1[0]][t1[1]] - graph[ints[0]][ints[1]];
            }
        });

        //构建graph
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nums1[i] == nums2[j]) {
                    //将ij的左下,右上+1,同时计数
                    int count = 0;
                    //左下
                    for (int k = 0; k < i; k++) {
                        for (int l = j + 1; l < col; l++) {
                            if (graph[k][l] != -1) {
                                count++;
                                graph[k][l]++;
                            }
                        }
                    }

                    //右上
                    for (int k = i + 1; k < row; k++) {
                        for (int l = 0; l < j; l++) {
                            if (graph[k][l] != -1) {
                                count++;
                                graph[k][l]++;
                            }
                        }
                    }
                    graph[i][j] = count;
                    //priorityQueue.add(new int[]{i, j});
                }
            }
        }

        //将graph不等于-1的值加入到pri中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j]!=-1){
                    priorityQueue.add(new int[]{i,j});
                }
            }
        }
        //进行排序

        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }

        for (int[] ints : priorityQueue) {
            System.out.println(ints[0] + "-" + ints[1] + "---" + graph[ints[0]][ints[1]]);
        }
        /*int[] poll1 = priorityQueue.poll();
        priorityQueue.add(poll1);*/
        //根据优先对列进行大的摘除
       /* int[] poll = priorityQueue.poll();
        System.out.println(poll[0] + "--" + poll[1] + "---" + graph[poll[0]][poll[1]]);

        int[] poll1 = priorityQueue.poll();
        System.out.println(poll1[0] + "--" + poll1[1] + "---" + graph[poll1[0]][poll1[1]]);

        int[] poll2 = priorityQueue.poll();
        System.out.println(poll2[0] + "--" + poll2[1] + "---" + graph[poll2[0]][poll2[1]]);
        int[] poll3 = priorityQueue.poll();
        System.out.println(poll3[0] + "--" + poll3[1] + "---" + graph[poll3[0]][poll3[1]]);
        int[] poll4 = priorityQueue.poll();
        System.out.println(poll4[0] + "--" + poll4[1] + "---" + graph[poll4[0]][poll4[1]]);
        int[] poll5 = priorityQueue.poll();
        System.out.println(poll5[0] + "--" + poll5[1] + "---" + graph[poll5[0]][poll5[1]]);

        int[] poll6 = priorityQueue.poll();
        System.out.println(poll6[0] + "--" + poll6[1] + "---" + graph[poll6[0]][poll6[1]]);
        int[] poll7 = priorityQueue.poll();
        System.out.println(poll7[0] + "--" + poll7[1] + "---" + graph[poll7[0]][poll7[1]]);
        int[] poll8 = priorityQueue.poll();
        System.out.println(poll8[0] + "--" + poll8[1] + "---" + graph[poll8[0]][poll8[1]]);*/
       while (true){
           //添加一个元素,再poll出去,删除添加会更新排序优先队列
           int[] ints = {0, 0};
           /*priorityQueue.add(ints);
           priorityQueue.remove(ints);*/
           //先删除,修改后添加这个;
           int[] poll = priorityQueue.poll();
           /*priorityQueue.add(poll);
           priorityQueue.poll();*/
           System.out.println(poll[0] + "-" + poll[1] + "---===" + graph[poll[0]][poll[1]]);
           int i=poll[0];
           int j = poll[1];
           if (graph[i][j]==0){
               break;
           }
           //将自己置-1;左下,右上-1
           graph[i][j]=-1;
           //左下
           for (int k = 0; k < i; k++) {
               for (int l = j + 1; l < col; l++) {
                   if (graph[k][l] != -1) {
                       graph[k][l]--;
                   }
               }
           }

           //右上
           for (int k = i + 1; k < row; k++) {
               for (int l = 0; l < j; l++) {
                   if (graph[k][l] != -1) {
                       graph[k][l]--;
                   }
               }
           }
       }


        return priorityQueue.size()+1;
    }//方法一:暴力破解
    //方法二:转化为最长公共子序列动态规划问题 97/54
    public static int maxUncrossedLines2(int[] nums1, int[] nums2) {
        /**思路:
        1.建立一个dp +1长度,哨兵思想,
         相等: dp[i]=dp[i-1][j-1]+1
            dp[i][j]=max(dp[i-1][j],dp[j][i-1]);
         */
        int row = nums1.length+1;
        int col = nums2.length+1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
       return dp[row-1][col-1];
    }

}
