package ACM.每日一题leecode.网络题型;

import java.util.Random;

/****
 有一种玻璃杯质量确定但未知，需要检测。
 有一栋100层的大楼，该种玻璃杯从某一层楼扔下，刚好会碎。
 现给你两个杯子，问怎样检测出这个杯子的质量，即找到在哪一层楼刚好会碎？

 题目解析
 2 个杯子的脆弱程度是一样的

 如果杯子从 N 楼扔下来没有碎，那么它从小于 N 楼扔下来，也不会碎

 如果杯子从 N 楼扔下来碎了，那么它从大于 N 楼扔下来，也一定会碎

 一个扔出去但没有碎的杯子，可以继续被用于试验

 碎了的杯子将无法再继续试验。

 举个🌰：
 如果从 x 楼扔下，没碎，在 x+1 楼扔下，碎掉了，即证明找到了 x+1 是刚好碎掉的楼层。

 那么问题来了：怎样才能最快速的找到这个楼层？

 */
public class algorithmi_检测玻璃那层楼会碎 {
    public static void main(String[] args) {
        System.out.println("这是采用传统方法做的------------" + getCount());
        //System.out.println("这是采用二分法做的------------" + getCount2());
        System.out.println("这是采用分区做的------------" + getCount3());
    }

    //1.暴力解法 利用一个杯子
    static int getCount() {
        //100层楼 两个杯子做实验
        int floor = 100;
        Random random = new Random();
        int plax = random.nextInt(100);//会碎的楼层
        System.out.println("这是随机数" + plax);
        int count = 0;//试验次数
        for (int j = 1; j <= floor; j++) {//j是杯子 用一个
            count++;
            if (j == plax) {
                return count;
            }
        }
        return floor;
    }

    //2.二分解法 利用两个杯子

    /***
     最好情况 50-100  logn
     最坏情况0 - 50以下 50次
     * @return
     */
    static int getCount2() {
        //100层楼 两个杯子做实验
        int floor = 100;
        Random random = new Random();
        int plax = random.nextInt(100);//会碎的楼层
        System.out.println("这是随机数" + plax);
        int count = 0;//试验次数
        count = deepFloor(1, 100, plax, 0);

        return count;
    }

    static int deepFloor(int i, int floor, int plax, int count) {
        int midium = (floor + i) / 2;
        count++;
        if (midium == plax) {
            System.out.println("杯子中了=" + midium);
            return count;
        } else if (midium < plax) {
            System.out.println("杯子没碎,继续二分=" + midium);
            return deepFloor(midium, floor, plax, count);
        } else {
            System.out.println("杯子碎了开始一个一个尝试-----------------=" + midium);
            for (int j = i; j < floor; j++) {
                System.out.println("将杯子在第几层=" + j);
                count++;
                if (j == plax) {
                    return count;
                }
            }
        }
        return 0;
    }

    //方案三：分段查找区间法   10到20次  平均稳定

    /***
     100分成10个段.0-10 每个段扔一次 先扔9 19 29 39 49 59 69 79 89 99
     */
    static int getCount3() {
        //100层楼 两个杯子做实验
        int floor = 100;
        Random random = new Random();
        int plax = random.nextInt(100);//会碎的楼层
        System.out.println("这是随机数" + plax);
        int count = 0;//试验次数
        count = fenuq(9, 100, 0, plax);

        return count;
    }


    static int fenuq(int i, int floor, int count, int plax) {
        count++;
        if (i == plax) {//找到了
            System.out.println("找到了="+i);
            return count;
        } else if (i < plax){//还没碎
            System.out.println("还没碎,向上找="+i);
            return fenuq(i+10,floor,count,plax);//继续向上找
        }else {
            //在i这里碎了
            /****
             假设是9  那就是1-9
             是19   那就是10-19
             */
            System.out.println("碎了,开始在区间里找,就是i-10  到 i"+i);
            for (int j = i-9; j <i ; j++) {
                System.out.println("这是j="+j);
                count++;
                if (j==plax){
                    System.out.println("在分区里面找到了=="+plax);
                    return count;
                }
            }

        }
        return 0;
    }

    //方案4：基于数学方程的方法
    static int getCount4() {
        /***
         事实上，这算是一道趣味问题，可以从数学的角度进行分析。

         假设最少尝试次数为 x ，那么，第一个杯子必须要从第 x 层扔下，因为：如果碎了，前面还有 x - 1 层楼可以尝试，如果没碎，后面还有 x-1 次机会。

         如果没碎，第一个杯子，第二次就可以从 x +（x - 1）层进行尝试，这里加上 x - 1，是因为当此时，第一个杯子碎了，第二个杯子还有可以从 x + 1 到 （ x + (x - 1) - 1 ） 层进行尝试，有 x - 2 次机会。

         如果还没碎，那第一个杯子，第三次从 x + (x - 1) + (x - 2)层尝试。不管杯子碎或者没碎，都有 x - 3 次尝试机会，依次类推。

         那么经过 x 次的尝试可以确定最高的楼层为 x + (x - 1) + (x - 2) + … + 1 = x(x+1) / 2 。

         那反过来，当最高楼层是100层，最少需要多少次呢？即 x(x+1)/2 >= 100, 得到 x >= 14 ，最少要尝试 14 次。
         */
        return 0;
    }

    //方案5:动态规划 最优解问题
    static int getCount5() {
        /***
         先思考上面的 分段查找区间法 ，如果杯子的质量没那么好，在第 19 层就碎了，那么需要扔 11 次，这样比 99 楼刚好碎的情况要少很多次。

         那么问题来了：能否无论杯子的质量如何，不管是很好还是很差，都可以快速地找到。

         能！

         上面的分析都是从杯子的角度出发的，这样想要得到最少的尝试次数，似乎比较难。我们可以换个角度，从每个高度的楼层来看：如果，某个楼层是可以安全落下的，那么最少需要多少次尝试呢？

         事实上，这就是一个求最优解的问题了。

         而我们编程解决问题的过程中，如果遇到最优问题的时候，往往可以先尝试一下动态规划的方法。

         动态规划的一个出发点就是去 找到构成这个最优问题的最优子问题。

         我们可以将这样的问题简记为 W(n,k) ，其中 n 代表可用于测试的杯子数，k 代表被测试的楼层数。对于问题 W(2,100)， 我们可以如此考虑

         将第 1 个杯子，在第 i 层扔下（ i 可以为 1～k 的任意值），如果碎了，则我们需要用第 2 个杯子，解决从第 1 层到第 i-1 层楼的 子问题 W(1,i-1)；

         如果这个杯子没碎，则我们需要用这两个杯子，解决从 i+1 层到第 100 层的子问题 W(2,100-i)。

         解决这两个问题，可以分别得到一个尝试次数 p 与 q，我们取这两个次数中的较大者(假设是 p )，将 p 与第 1 次在 i 层执行测试的这一次相加，
         则 p+1 就是第一次将杯子扔在 i 层来解决 W(2，100) 所需的最少测试次数，将其表示为ti。

         对于这 100 层楼的问题，第一次，我们可以把杯子扔在 100 层中的任何一层，所以可以得到 100 中解决方案的测试次数 T{t1,t2,t3,……,t100} ，
         在这些结果中，我们选取最小的 ti，使得对于集合 T 中任意的值 tj(1 <= j <= 100,j != i)，都有ti <= tj，则 ti 就是这个问题的答案。

         用公式来描述就是：

         W(n, k) = 1 + min{max(W(n -1, x -1), W(n, k - x))}, x in {2, 3, ……，k}
         其中x是第一次的测试的楼层位置

         其中W(1,k) = k（相当于 1 个杯子测试 k 层楼问题），W(0,k) = 0，W(n, 0) = 0

         所以在计算 W(2,100) 之前，我们需先计算出所有 W(1,0) ,……, W(1,100) , W(2,0),……,W(2,99)这些的值。

         使用递推的方法实现，代码如下：

         unsigned int DroppingCups(unsigned int cups, unsigned int floors){

         unsigned int i, j, k, t, max;

         unsigned int temp[cups + 1][floors + 1];

         for(i = 0; i < floors + 1; ++i){
         temp[0][i] = 0;
         temp[1][i] = i;
         }

         for(i = 2; i < cups + 1; ++i){
         temp[i][0] = 0;
         temp[i][1] = 1;
         }

         for(i = 2; i < cups + 1; ++i){
         for(j = 2; j < floors + 1; ++j){
         for(k = 1, max = UINT_MAX; k < j; ++k){

         t = temp[i][j - k] > temp[i - 1][k -1] ?  temp[i][j - k] : temp[i - 1][k -1];

         if(max > t){
         max = t;
         }
         }

         temp[i][j] = max + 1;
         }
         }

         return temp[cups][floors];
         }
         */
        return 0;
    }

}
