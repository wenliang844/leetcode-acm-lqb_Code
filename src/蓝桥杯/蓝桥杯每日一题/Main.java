package 蓝桥杯.蓝桥杯每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //方法一,构造邻接表,进行深度优先搜索,枚举每一条路径,求出最小值
   /* public static void main(String[] args) {//int N, int M, int W, int[][] edge
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int W = sc.nextInt();
        int[][] edge = new int[N][3];
        for (int i = 0; i < M; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }
        //获取数字
        //构造邻接表
        cityLoad[] cityLoads = new cityLoad[N];//0 1 2
        for (int i = 0; i < N; i++) {
            cityLoads[i] = new cityLoad(i,0);
        }
        //edge的i-N j=3
        for (int i = 0; i < N; i++) {
            cityLoad tmp = new cityLoad(edge[i][1]-1,edge[i][2]);
            cityLoads[edge[i][0]-1].list.add(tmp);
        }
        //System.out.println(Arrays.toString(cityLoads));

        //先获取下标0的list,遍历lsit,如果重量小于限制就进行调用方法遍历,创建一个方法getminFee进行dfs,参数minFee
        int minFee = Integer.MAX_VALUE;
        for (cityLoad load : cityLoads[0].list) {
            if (W < load.maxWeight){
                //如果第一条路可以通,就继续
                minFee = Math.min(getMinFee(cityLoads,load,W,1,minFee),minFee);
            }
        }
        if (minFee == Integer.MAX_VALUE){
            System.out.println(-1);
            //return -1;
        }else {
            System.out.println(minFee);
        }
        //return minFee;
    }


    public static int getMinFee( cityLoad[] cityLoads,cityLoad load,int W,int currentFee,int minFee){
        if (load.toID == cityLoads.length-1){
            minFee = Math.min(minFee,currentFee);
            return minFee;
        }else {
            for (cityLoad cityLoad : cityLoads[load.toID].list) {
                if (W < cityLoad.maxWeight){
                    //如果第一条路可以通,就继续
                    minFee = Math.min(getMinFee(cityLoads,cityLoad,W,currentFee+1,minFee),minFee);
                }
            }
        }


        return minFee;
    }

    static class cityLoad {
        int toID;
        int maxWeight;
        List<cityLoad> list;

        cityLoad() {
        }

        cityLoad(int toID, int maxWeight) {
            this.toID = toID;
            this.maxWeight = maxWeight;
            list = new ArrayList<cityLoad>();
        }

        @Override
        public String toString() {
            return "cityLoad{" +
                    "toID=" + toID +
                    ", maxWeight=" + maxWeight +
                    ", list=" + list +
                    '}';
        }
    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int W = sc.nextInt();
        int[][] edge = new int[N][3];
        for (int i = 0; i < M; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }
        //构造邻接矩阵
        int[][] loads = new int[N][N];
        for (int i = 0; i < M; i++) {
            loads[edge[i][0] - 1][edge[i][1] - 1] = edge[i][2];
        }

        //开始dij
        int[] distance = new int[N];//0->0,1,2,3,4的距离
        //初始化距离
        for (int i = 0; i < N; i++) {
            //distance[i] = loads[0][i];
            if (W < loads[0][i]) {
                distance[i] = 1;
            }
        }
        //System.out.println("初始化的距离\n--"+ Arrays.toString(distance));
        //使用Dij算法松弛0,4之间的距离,用一个数组,for5.里面forj=i 更新0-j->节点 和0-这个节点的距离谁大
        for (int i = 1; i < N; i++) {

            //0->每一个点的距离
            for (int j = i + 1; j < N; j++) {
                if (W < loads[i][j]) {//i->j是可达的
                    if (distance[j] == 0) {//0到j是不可达的,直接赋值
                        distance[j] = distance[i] + 1;
                    } else {//之前也是可达的,就比较之前的,和0->i i->j谁小
                        if (distance[j] > distance[i] + 1) {
                            distance[j] = distance[i] + 1;
                        }
                    }

                }
            }
        }
        //System.out.println("最后的distance" + Arrays.toString(distance));

        if (distance[N - 1] == 0) {//不可达
            System.out.println(-1);
        } else{
            System.out.println(distance[N - 1]);
        }
    }
}
