package ACM.每日一题leecode.day100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day112_403青蛙过河 {
    /***
     一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
     给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
     开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
     如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
     示例 1
     输入：stones = [0,1,3,5,6,8,12,17]
     输出：true
     解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
     */

    public static void main(String[] args) {
        /***
         只能调用 当前步数的k k-1 k+1步
         */
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 1, 3, 6, 7}));
        System.out.println(canCross(new int[]{0, 2}));
    }

    //方法一:动态规划
    public static boolean canCross(int[] stones) {

        //第一步1 下一次选择0 1 2
        /**
         0 1 3 5 6 8    12 17
         1 2 2 1 2,3  4  5
         */
        //初始化,第一次跳的是1
        List<List<Integer>> lists = new ArrayList<>();
        if (stones[1] - stones[0] != 1) {
            return false;
        }
        lists.add(Arrays.asList(stones[1], 1));

        for (int i = 2; i < stones.length; i++) {
            //遍历list
            int len = lists.size();
            for (int j = 0; j < len; j++) {
                List<Integer> list = lists.get(j);
                if (list.get(0) + list.get(1) + 1 < stones[i]) {
                    lists.remove(j);
                    j--;
                    len--;
                    continue;
                }

                //进行add操作,如果add之后lists为null了,直接false
                if (list.get(0) + list.get(1) - 1 == stones[i]) {
                    lists.add(Arrays.asList(stones[i], list.get(1) - 1));
                }

                if (list.get(0) + list.get(1) == stones[i]) {
                    lists.add(Arrays.asList(stones[i], list.get(1)));
                }

                if (list.get(0) + list.get(1)+1 == stones[i]) {
                    lists.add(Arrays.asList(stones[i], list.get(1)+1));
                }
            }

            if (lists.size()==0){
                return false;
            }
        }


        if (lists.get(lists.size()-1).get(0)==stones[stones.length-1]){
            return true;
        }else{
            return false;
        }
    }

    //方法二:dfs 尝试,剪枝 //超时  加记忆化
    public static boolean canCross2(int[] stones) {

        /*int step = 1;
        int i = 0;*/
        //规定第一步只能跳跃一个单位

        return stones[1] - stones[0] == 1 && dfs(stones, 1, 1);
    }

    private static boolean dfs(int[] stones, int i, int step) {
        if (i == stones.length - 1) {
            return true;
        }

        //考察下一个石头有没有step能够胜任,如果下一个石头直接大于step+1;停止运行'
        boolean flag = false;
        for (int j = i + 1; j < stones.length; j++) {
            if (stones[i] + step - 1 == stones[j]) {
                flag = dfs(stones, j, step - 1);
            }
            if (flag) return flag;
            if (stones[i] + step == stones[j]) {
                flag = dfs(stones, j, step);
            }
            if (flag) return flag;
            if (stones[i] + step + 1 == stones[j]) {
                flag = dfs(stones, j, step + 1);
            }
            if (flag) return flag;

            //及时退出
            if (stones[i] + step + 1 < stones[j]) {
                break;
            }
        }

        return flag;
    }
}
