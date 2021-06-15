package 蓝桥杯.培训.第一次培训3_12习题2019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class lqb10_试题J扫地机器人 {

    /***
     小明公司的办公区有一条长长的走廊，由 N 个方格区域组成，如下图所
     示。
     走廊内部署了 K 台扫地机器人，其中第 i 台在第 Ai 个方格区域中。
     已知扫地机器人每分钟可以移动到左右相邻的方格中，并将该区域清扫干
     净。
     请你编写一个程序，计算每台机器人的清扫路线，使得
     1. 它们最终都返回出发方格，
     2. 每个方格区域都至少被清扫一遍，
     3. 从机器人开始行动到最后一台机器人归位花费的时间最少。
     注意多台机器人可以同时清扫同一方块区域，它们不会互相影响。
     输出最少花费的时间。
     在上图所示的例子中，最少花费时间是 6。第一台路线： 2-1-2-3-4-3-2，清
     扫了 1、 2、 3、 4 号区域。第二台路线 5-6-7-6-5，清扫了 5、 6、 7。第三台路线
     10-9-8-9-10，清扫了 8、 9 和 10。
     【输入格式】
     第一行包含两个整数 N 和 K。
     接下来 K 行，每行一个整数 Ai。
     试题 J: 扫地机器人 15第十届蓝桥杯大赛软件类省赛 Java 大学 C 组
     【输出格式】
     输出一个整数表示答案。
     【样例输入】
     10 3
     5
     2
     10
     【样例输出】
     6
     */

    /***
     思考:
     1.最小的是N / K   +1
     有特殊情况
     */

    //网络参考
    static int N;
    static int K;
    static int[] a = new int[1000000];
    static int[] b = new int[1000000];

    public static boolean check1(int first_L, int L) { //第一个区间长度为 first_L，之后区间长度都为 L
        int i, j;
        if (first_L + (K - 1) * L < N) {//第一个区间再加上，其他的机器人和*这段的长度是不是能够够到总长
            return false;
        }
        i = 1; //第 i 个区间
        j = 1; //当前查看的方格位置
        while (j <= N) {
            if (b[j] == 1) { //第 i 个区间内有机器人
                j = first_L + (i - 1) * L + 1; //j 指向下一个区间起点
                i++; //下一个区间
            } else {
                j++;//一直检查下一个方格，如果一直没有直到first_L和j相等后，表明真的没有机器人
                if (j == first_L + (i - 1) * L + 1 || j == N + 1) { //第 i 个区间内没有机器人
                    return false;        //因为L是不断变大的，first也一直变大，所以检查一直再往后扩展
                }
            }
        }
        return true;
    }

    public static boolean check(int L) {
        int first_L; //首区间的长度(取值范围：1~L)
        for (first_L = L; first_L > 0; first_L--) {//倒叙是因为，用大区间可以减少机器人的移动
            if (check1(first_L, L)) {
                return true;
            }
        }
        return false;
    }

    public static int fun() {
        int i, j, L;
        for (L = N / K; L <= N; L++) {//平均一下，
            if (check(L)) {
                return L;
            }
        }
        return L;
    }

    public static void test1() {
        int i, L;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//格子数量
        K = sc.nextInt();//机器数量
        for (i = 1; i <= K; i++) {
            a[i] = sc.nextInt();
            b[a[i]] = 1;
        }
        L = fun();
        System.out.println(2 * (L - 1));
    }

    //我的方案一:  空格数量 / 机器数量 +1   *2
    public static int test2(int[] robot,int k){
        int robotNum = robot.length - k;
        return robot.length/k==0?(robotNum/k) *2:((robotNum/k)+1)*2;

    }



//最短路径,最大公约数,动态规划,
    /***一起扫 平均
     我的方案2:
     采用分配法:
     第一个机器人固定前面的
     最后一个机器人固定后面的区域
     中间的进行循环分配:分配规则:
        用一个数组包括中间区域的数量field[2,4]
        一个数组包括机器人的分配的区域robot[1,0,0]
            每个区域只能分配给左右两个机器人,
            每次分配一个,谁小就分配给谁,知道分配完毕,退出循环
            robot[i]>robot[i+1]   fielt[i]--  robot[i]++
     */

    public static int test3(int[] robot,int k){
        int[] field = new int[k-1];//2
        int[] robots = new int[k];//3
        int i1=0;
        while (true){
            if (robot[i1]==1){
                robots[0]=i1;
                break;
            }
            i1++;
        }

        int i2=robot.length-1;
        while (true){
            if (robot[i2]==1){
                robots[k-1] = robot.length - i2-1;
                break;
            }
            i2--;
        }
        System.out.println(Arrays.toString(robots));
        System.out.println("i1="+i1 +"i2="+i2);

        //开始搞field
        int j1=i1+1;
        for (int i = 0; i < field.length; i++) {//区域的个数
            for (; j1 < i2; j1++) {
                if (robot[j1]==1){
                    break;
                }
                field[i]++;
            }
            j1++;
        }

        System.out.println(Arrays.toString(field));

        //开始分配 filed分配给robots
        boolean flag = true;
        while (flag){
            flag = false;
            for (int j = 0; j <field.length ; j++) {
                if (field[j]>0){
                    flag = true;
                    if (robots[j]<=robots[j+1]){
                        robots[j]++;
                    }else {
                        robots[j+1]++;
                    }
                    field[j]--;
                }

            }
        }
        //分配完成后robot的情况
        System.out.println("每个机器人的分配数量="+Arrays.toString(robots));



        //找出最多打扫的机器人
        int max=0;
        for (int i = 0; i < robots.length; i++) {
            max = Math.max(robots[i],max);
        }
        return max*2;
    }

    public static void main(String[] args) {
        //test1();
        System.out.println(test3(new int[]{0, 1, 0, 0, 1, 0, 0, 0, 0, 1}, 3));
        System.out.println(test3(new int[]{1,0,1,0,0,0,0,0,0,0,1}, 3));
        System.out.println(test3(new int[]{1,0,0,0,1,0,0,0,0,0,1}, 3));
        System.out.println(test3(new int[]{1,1,1,1,1,0,0,0,0,0,1}, 6));

        Set<Integer> set  = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(4);
        set.add(2);
        set.add(20);
        set.add(5);
        set.add(45);
        System.out.println(set);
    }
}
