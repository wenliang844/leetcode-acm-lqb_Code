package ACM.leecode周赛.lee41;


import java.util.Arrays;
import java.util.Comparator;

/*
Alice 和 Bob 轮流玩一个游戏，Alice 先手。

一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。

给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。

所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。

请你推断游戏的结果，用如下的方式表示：

如果 Alice 赢，返回 1 。
如果 Bob 赢，返回 -1 。
如果游戏平局，返回 0 。
 

示例 1：

输入：aliceValues = [1,3], bobValues = [2,1]
输出：1
解释：
如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
Bob 只能选择石子 0 ，得到 2 分。
Alice 获胜。
示例 2：

输入：aliceValues = [1,2], bobValues = [3,1]
输出：0
解释：
Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
打平。
示例 3：

输入：aliceValues = [2,4,3], bobValues = [1,6,7]
输出：-1
解释：
不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
Bob 会获胜。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/stone-game-vi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lee_5611石子游戏VI {

    public static void main(String[] args) {

        int[] ali = {2,4,3};
        int[] bob = {1,6,7};
        System.out.println("这是结果==="+stoneGameVI2(ali, bob));

        int[] ali2 = {1,3};
        int[] bob2 = {2,1};
        System.out.println("这是结果==="+stoneGameVI2(ali2, bob2));
    }

    //最优决策=我拿到的 + 你失去的最大
    //很德式的 损人不利己的游戏了
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int sum[] = new int[aliceValues.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = aliceValues[i] + bobValues[i];
        }

        for (int i = 0; i < sum.length-1; i++) {
            for (int j = i+1; j < sum.length; j++) {
                if (sum[j]>sum[i]){
                    swap(i,j,sum);
                    swap(i,j,aliceValues);
                    swap(i,j,bobValues);
                }
            }
        }
        print(sum);
        print(aliceValues);
        print(bobValues);

        int aliSum=0,bobSum=0;
        for (int i = 0; i < aliceValues.length; i++) {
            if (i%2==0){
                aliSum += aliceValues[i];
                System.out.println("这是ali==="+aliceValues[i]);
            }else {
                bobSum += bobValues[i];
                System.out.println("这是bob==="+bobValues[i]);
            }
        }

        return aliSum>=bobSum?aliSum==bobSum?0:1:-1;

    }

    public static void print(int[] a){
        for (int i : a) {
            System.out.print(i+"\t");
        }
        System.out.println("---");
    }

    static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int stoneGameVI2(int[] aliceValues, int[] bobValues) {
        int sum[][] = new int[aliceValues.length][2];
        for (int i = 0; i < sum.length; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = i;//保存下标

        }

        Arrays.sort(sum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return 0;
                return o1[0]>o2[0]?-1:1;
            }
        });

        int aliSum=0,bobSum=0;
        for (int i = 0; i < aliceValues.length; i++) {
            if (i%2==0){
                aliSum += aliceValues[sum[i][1]];
                //System.out.println("这是ali==="+aliceValues[sum[i][1]]);
            }else {
                bobSum += bobValues[sum[i][1]];
                //System.out.println("这是bob==="+bobValues[sum[i][1]]);
            }
        }

        System.out.println(aliSum+"-"+bobSum);
        return aliSum>=bobSum?aliSum==bobSum?0:1:-1;

    }

    //来源网络
    public static int stoneGameVI3(int[] aliceValues, int[] bobValues) {
        int suma = 0;
        int sumb = 0;
        //第一个是和，第二个是下标。
        int[][] d = new int[aliceValues.length][2];
        for(int i = 0;i<aliceValues.length;i++) {
            d[i][0] = aliceValues[i]+bobValues[i];
            d[i][1] = i;
        }
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return 0;
                return o1[0]>o2[0]?-1:1;
            }
        });
        int n = 0;
        while(n<aliceValues.length) {
            if(n%2 == 0) {
                suma += aliceValues[d[n][1]];
            }else {
                sumb += bobValues[d[n][1]];
            }
            n++;
        }
        if(suma==sumb) return 0;
        return suma>sumb?1:-1;
    }

}
