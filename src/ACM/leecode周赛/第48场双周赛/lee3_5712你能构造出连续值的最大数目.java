package ACM.leecode周赛.第48场双周赛;

import java.util.*;

public class lee3_5712你能构造出连续值的最大数目 {

    /***
     给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。
     第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，
     它们的和为 x ，那么称，你可以 构造 出 x 。
     请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
     你可能有多个相同值的硬币。
     示例 1：
     输入：coins = [1,3]
     输出：2
     解释：你可以得到以下这些值：
     - 0：什么都不取 []
     - 1：取 [1]
     从 0 开始，你可以构造出 2 个连续整数。

     */

    public static int getMaximumConsecutive(int[] coins) {

        /***
         思路:遍历:
         加起来  放一个set里面
         计数 最长相同数
         */

        //所有组合数
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        for (int i = 0; i < coins.length - 1; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                //System.out.println(i+"---"+j);
                set.add(coins[i] + coins[j]);
            }
        }

        System.out.println(set);
        //list装好,再进行检测最长连续数长度
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        System.out.println(list);
        return 0;
    }

    public static int getMaximumConsecutive2(int[] coins) {

        /***
         思路:
         treeset找出所有组合数
         */
        int i = 0;
        int j = 0;
        Set<Integer> set = new TreeSet<>();


        return 0;
    }

    public static node copyNode(node node) {

        return null;
    }
    /***
     * 连续整数。
     * 网络思路:
     1.第一个结果由所有的1产生。如果有 5个1，则结果是 0-5      再看有无<=6的数

     2.接下来看有没有 2-6的数，比如有 5 ，那么结果变为 0-11
     */

    /***
     我的思路:O(n)
     1.排序coins   设置最大可表示数maxNum=0
     2.从coins[0]开始遍历,如果coins[0] <= maxNum+1   更新maxnum为+= coins[i]
     * @param coins
     * @return
     */
    public static int getMaximumConsecutive3(int[] coins) {
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));

        int maxNum= 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i]<=maxNum+1){
                maxNum += coins[i];
            }
        }


        return maxNum+1;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumConsecutive3(new int[]{1, 3}));
        System.out.println(getMaximumConsecutive3(new int[]{1, 1, 1, 4}));

        System.out.println("----------test---------");

    }
}


class node {
    int val;
    node left;
    node right;

    public node(int val) {
        this.val = val;
    }
}
