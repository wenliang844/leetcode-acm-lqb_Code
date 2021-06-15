package ACM.每日一题leecode.day01;

public class day24_135分发糖果 {

    public static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(candy(nums));

        System.out.println("===========");
        int[] nums1 = {1, 2, 2};
        System.out.println(candy(nums1));

        System.out.println("-------");
        int[] nums2 = {11, 10, 11, 12, 11, 10, 9, 3, 4, 3, 2, 1};
        System.out.println(candy(nums2));

        System.out.println("-------");
        int[] nums3 = {0};
        System.out.println(candy(nums3));

        System.out.println("-------");
        int[] nums4 = {11, 10};
        System.out.println(candy(nums4));
    }


    /*初始化一个新数组candy {0}
    1.找谷底 找到谷底置为1
        1.找到每一个谷底向两边进行搜索
        大的就加1  碰到小的数就退出循环
        如果加1后还比本身小 就维持本身 也退出循环

     */
    public static int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int[] candy = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candy[i] = 0;
        }
        for (int i = 0; i < ratings.length; i++) {

            if (i == 0 && ratings[i] <= ratings[i + 1]) {
                candy[i] = 1;

                //从i=0开始 从右遍历  一直大就一直加1
                for (int j = i + 1; j < ratings.length; j++) {
                    if (ratings[j - 1] < ratings[j] && candy[j - 1] + 1 > candy[j]) {
                        candy[j] = candy[j - 1] + 1;
                    } else {
                        break;
                    }
                }

            } else if (i == ratings.length - 1 && ratings[i] <= ratings[i - 1]) {
                candy[i] = 1;

                //从i=len-1开始 从左遍历  一直大就一直加1
                for (int j = i - 1; j >= 0; j--) {
                    if (ratings[j] > ratings[j + 1] && candy[j + 1] + 1 > candy[j]) {
                        //System.out.println("==="+ratings[j+1]+" "+ratings[j]+" "+candy[j+1]+" "+candy[j]);
                        candy[j] = candy[j + 1] + 1;
                    } else {
                        break;
                    }
                }

            } else if (i > 0 && i < ratings.length - 1 && ratings[i] <= ratings[i + 1] && ratings[i] <= ratings[i - 1]) {
                candy[i] = 1;

                //从i=0开始 从右遍历  一直大就一直加1
                for (int j = i + 1; j < ratings.length; j++) {
                    if (ratings[j - 1] < ratings[j] && candy[j - 1] + 1 > candy[j]) {
                        candy[j] = candy[j - 1] + 1;
                    } else {
                        break;
                    }
                }

                //从i=len-1开始 从左遍历  一直大就一直加1
                for (int j = i - 1; j >= 0; j--) {
                    if (ratings[j] > ratings[j + 1] && candy[j + 1] + 1 > candy[j]) {
                        //System.out.println("==="+ratings[j+1]+" "+ratings[j]+" "+candy[j+1]+" "+candy[j]);
                        candy[j] = candy[j + 1] + 1;
                    } else {
                        break;
                    }
                }

            }
        }
        //printNums(candy);

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candy[i];
        }

        return sum;
    }

    /**
     *两趟：从前向后  从后向前的方法
     *


     这道题目一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑就会顾此失彼。

     本题贪心贪在哪里呢？

     先确定每个孩子左边的情况（也就是从前向后遍历）

     如果ratings[i] > ratings[i - 1] 那么[i]的糖 一定要比[i - 1]的糖多一个，所以贪心：candyVec[i] = candyVec[i - 1] + 1

     代码如下：

     // 从前向后
     for (int i = 1; i < ratings.size(); i++) {
     if (ratings[i] > ratings[i - 1]) candyVec[i] = candyVec[i - 1] + 1;
     }
     如图：

     !135.分发糖果

     再确定每个孩子右边的情况（从后向前遍历）

     遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？

     因为如果从前向后遍历，根据 ratings[i + 1] 来确定 ratings[i] 对应的糖果，那么每次都不能利用上前一次的比较结果了。 **所以确定每个孩子右边的情况一定要从后向前遍历！**

     此时又要开始贪心，如果 ratings[i] > ratings[i + 1]，就取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，**因为candyVec[i]只有取最大的才能既保持对左边candyVec[i - 1]的糖果多，也比右边candyVec[i + 1]的糖果多**。

     如图：

     !135.分发糖果1

     所以代码如下：

     // 从后向前
     for (int i = ratings.size() - 2; i >= 0; i--) {
     if (ratings[i] > ratings[i + 1] ) {
     candyVec[i] = max(candyVec[i], candyVec[i + 1] + 1);
     }
     }
     整体代码如下：

     class Solution {
     public:
     int candy(vector<int>& ratings) {
     vector<int> candyVec(ratings.size(), 1);
     // 从前向后
     for (int i = 1; i < ratings.size(); i++) {
     if (ratings[i] > ratings[i - 1]) candyVec[i] = candyVec[i - 1] + 1;
     }
     // 从后向前
     for (int i = ratings.size() - 2; i >= 0; i--) {
     if (ratings[i] > ratings[i + 1] ) {
     candyVec[i] = max(candyVec[i], candyVec[i + 1] + 1);
     }
     }
     // 统计结果
     int result = 0;
     for (int i = 0; i < candyVec.size(); i++) result += candyVec[i];
     return result;
     }
     };
     > 循序渐进学算法，就在公众号「代码随想录」，关注后就会发现相见恨晚！

     如果感觉对你有帮助，不要吝啬给一个👍吧！
     */
}
