package ACM.每日一题leecode.day01;

import java.util.*;

public class day30_1046最后一块石头的重量 {

    /****
     有一堆石头，每块石头的重量都是正整数。

     每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

     如果 x == y，那么两块石头都会被完全粉碎；
     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。

      

     示例：

     输入：[2,7,4,1,8,1]
     输出：1
     解释：
     先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
     再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
     最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     */
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{1, 3}));
        System.out.println(lastStoneWeight(new int[]{3}));
        System.out.println(lastStoneWeight(new int[]{3, 7, 2}));
        System.out.println(lastStoneWeight(new int[]{3, 7, 8}));
        System.out.println(lastStoneWeight(new int[]{316, 157, 73, 106, 771, 828, 46, 212, 926, 604, 600, 992, 71, 51, 477, 869, 425, 405, 859, 924, 45, 187, 283, 590, 303, 66, 508, 982, 464, 398}));
    }

    public static int lastStoneWeight(int[] stones) {
        /***
         采用list + list插入方法
         */

        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        //1.排序
        //2.判断
        //3.while循环
        List<Integer> list = new ArrayList<>();
        Arrays.sort(stones);
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        System.out.println("这是排序后的list" + list);
        while (list.size() > 1) {
            int num1 = list.get(list.size() - 1);
            int num2 = list.get(list.size() - 2);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            if (num1 != num2) {
                //加入y-x进入list   插入排序

                //从后面开始
                int num;
                if (num1 > num2) {
                    num = num1 - num2;
                } else {
                    num = num2 - num1;
                }

                //list.add(num);
                int len = list.size() - 1;
                boolean flag = true;
                while (list.size() > 0 && len >= 0 && list.get(len) > num) {
                    //list.add(len+1,list.get(len));
                    len--;
                    flag = false;
                }

                if (flag) {
                    list.add(num);
                } else {
                   /* if (len==-1){
                        len=0;
                    }*/
                    list.add(len + 1, num);
                }

                System.out.println("这是这轮的list" + list);

            }
        }
        if (list.size() == 1) {
            return list.get(0);
        }

        return 0;
    }
}
