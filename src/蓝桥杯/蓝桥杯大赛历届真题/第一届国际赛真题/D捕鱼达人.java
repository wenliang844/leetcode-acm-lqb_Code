package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class D捕鱼达人 {
    /***
     若干条鱼{点},撒网最少次数
     不用也行//一个map节点1 和坐标x,y的对应关系
     一个邻接矩阵,一个visited,一个二维数组对应关系和能访问的排序
     */
    public static int getNum(int n, int r, int[][] fishPoint) {
        boolean[][] map = new boolean[n][n];
        boolean[] visited = new boolean[n];
        Integer[][] captureSum = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                //判断i 和j两个点能不能一起被访问,被capture
                int a = fishPoint[i][0] - fishPoint[j][0];
                int b = fishPoint[i][1] - fishPoint[j][1];
                int temp = (int) Math.sqrt((a * a) + b * b);
                if (temp <= r) {//不超过的鱼是可以互相访问的
                    //可以互相访问的,设为true
                    map[i][j] = true;
                    sum++;//0加一个可访问
                }/*else {
                    //不能访问false  默认是false不需要动
                }*/
            }
            captureSum[i][0] = i;
            captureSum[i][1] = sum;//i能访问的个数
        }
        printNums(map);
        printNums(captureSum);
        System.out.println(Arrays.toString(visited));

        //进行对captrue的排序
        Arrays.sort(captureSum, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] integers, Integer[] t1) {
                return t1[1]-integers[1];//降序
            }
        });
        printNums(captureSum);

        //进行根据captrue的循序进行访问
        int count = 0;//访问次数
        for (int i = 0; i < captureSum.length; i++) {
            int view = captureSum[i][0];//要访问的
            if (!visited[view]){//如果view这个节点还没有被访问的话
                count++;
                visited[view]=true;
                for (int j = 0; j < map[0].length; j++) {
                    if (map[view][j]){//如果view和哪个节点是可达的,那我直接访问了你
                        visited[j]=true;
                    }
                }
            }
        }

        return count;
    }

    private static void printNums(boolean[][] map) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void printNums(Integer[][] map) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(getNum(7, 4, new int[][]{{0, 0}, {2, 3}, {-5, -3},{1,1},{100,100},{50,50},{2,1}}));
    }

}
