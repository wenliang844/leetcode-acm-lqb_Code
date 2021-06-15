package 蓝桥杯.lan真题训练.lan2020省赛javaB组;


import java.util.Scanner;

public class G外卖店优先级 {
/*
“饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
一个优先级，初始时 (0 时刻) 优先级都为 0。
每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
优先级小于等于 3，则会被清除出优先缓存。
给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
先缓存中。
【输入格式】
第一行包含 3 个整数 N、 M 和 T。
以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
一个订单。
【输出格式】
输出一个整数代表答案。
【样例输入】
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
试题G: 外卖店优先级 10第十届蓝桥杯大赛软件类省赛 Java 大学 B 组
【样例输出】
1
【样例解释】
6 时刻时， 1 号店优先级降到 3，被移除出优先缓存； 2 号店优先级升到 6，
加入优先缓存。所以是有 1 家店 (2 号) 在优先缓存中。
【评测用例规模与约定】
对于 80% 的评测用例， 1 ≤ N; M; T ≤ 10000。
对于所有评测用例， 1 ≤ N; M; T ≤ 100000， 1 ≤ ts ≤ T， 1 ≤ id ≤ N。
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 2;//几家店 1 2
        int M = 6;//几条订单
        int T = 6;//几个时刻

        int[][] tsid = new int[M][2];//ts时刻  的id店铺订单一条
        int[] dian = new int[N];//N家店铺  当前时刻的订单
        int[] score = new int[N];//i个店铺的积分
        int[] count = new int[N];//店铺是否在优先队列 >5进入   <=3退出
        for (int i = 0; i < N; i++) {
            dian[i]=0;
            score[i]=0;
            count[i]=0;
        }
        tsid[0][0] = 1;
        tsid[0][1] = 1;
        tsid[1][0] = 5;
        tsid[1][1] = 2;
        tsid[2][0] = 3;
        tsid[2][1] = 1;

        tsid[3][0] = 6;
        tsid[3][1] = 2;
        tsid[4][0] = 2;
        tsid[4][1] = 1;
        tsid[5][0] = 6;
        tsid[5][1] = 2;


        printNums(tsid);
        //第5节_排序
        System.out.println("-----------");
        sort(tsid);
        printNums(tsid);


        //进行时间调度: 从1开始 1时刻   M是几条订单   T是几个时刻 用T
        //int count = 0;//优先队列 >5进入   <=3退出

        //int k = 1;//这是M条单子
        for (int i = 1; i <= T; i++) {//这是T个时刻  就是时刻从1开始
            System.out.println("这是第几个时刻"+i);

            for (int j = 0; j < M; j++) {//这是M个单子

                if (tsid[j][0] == i) {//第j个单子是时刻i
                    for (int l = 0; l < dian.length; l++) {//对店铺进行遍历
                        if (tsid[j][1] == l + 1) {//第j个单子是dian[i]家的
                            System.out.println("这是第几个时刻 第几个订单是哪个家的" + "-" + i + "-" + j + "-" + (l + 1));
                            dian[l]++;
                            continue;
                        }
                    }
                }
            }
                //else {//不是时刻i 那就是i+1啊 要往前走 处理i时刻的订单   score进行赋值
                    for (int l = 0; l < dian.length; l++) {//对店铺进行遍历
                        System.out.println("当前的店铺订单 积分 是否在缓存"+dian[l]+"-"+score[l]+"-"+count[l]);
                        if (dian[l]==0) {//当这家店铺在i时刻没有订单的时候 积分减一
                            System.out.println("执行了-分");

                            if (score[l] > 0) {
                                //boolean flag1 = false;
                                score[l]--;
                                if (score[l] <= 3 && count[l] == 1) {//当店铺从4掉下成3积分的时候 缓存剪1
                                    count[l] = 0;
                                    System.out.println("店铺离开缓存---" + l);
                                }
                            }
                        }
                        if (dian[l]>0){
                            //if (score[l]>=1){//i时刻大于1个订单   积分加i*2
                            System.out.println("执行了加分");

                                score[l] += dian[l]*2;
                                if (score[l]>5 && count[l]==0){
                                    count[l]=1;
                                    System.out.println("店铺进入了缓存---"+l);
                                }

                            //}
                        }
                    }
                   // break;

                //}


            //}
            for (int n = 0; n < dian.length; n++) {//这个时刻完成后  这个店铺的订单变成0
                dian[n]=0;
            }

        }

        int count2 = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]==1){
                count2++;
            }
        }
        System.out.println("这是结果1==="+count2);


    }

    static void sort(int[][] nums){
        //方法一 i的大小进行冒泡排序
        //int maxNum = 0;
        int len = nums.length;
        System.out.println(len);
        for (int i = 0; i < len-1 ; i++) {
            for (int j = i+1; j < len ; j++) {
                if (nums[i][0]>nums[j][0]){
                    System.out.println(i+"---"+j);
                    int temp = nums[i][0];
                    int temp2 = nums[i][1];
                    nums[i][0]=nums[j][0];
                    nums[i][1]=nums[j][1];
                    nums[j][0] = temp;
                    nums[j][1] = temp2;
                }
            }

            System.out.println("===="+i);
            printNums(nums);
        }

    }

    static void printNums(int[][] tsid){
        for (int i = 0; i < tsid.length; i++) {
            for (int j = 0; j < tsid[i].length; j++) {
                System.out.print(tsid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
