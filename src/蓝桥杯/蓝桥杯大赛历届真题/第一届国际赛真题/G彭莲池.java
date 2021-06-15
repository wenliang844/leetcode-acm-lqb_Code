package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class G彭莲池 {
    /***
     范围内的点的汉哈顿距离之和
     先用一个n*n的点的个数的灵界矩阵把距离存起来
     然后调用的时候直接将ans+起来
     */
    public static void main(String[] args) {
        /**
         5 3
         1 1
         3 3
         2 2
         1 3
         3 1
         2 2
         2 4
         1 5

         answer
         0 6 24
         */
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//个数
        int m=scanner.nextInt();//询问的个数

        int[][] distance = new int[n][n];
        //接收n个点
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        //对每两个点之间的距离进行计算:并加入邻接矩阵中,后期不用计算直接调用空间换时间
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int x = Math.abs(points[i][0]-points[j][0]);
                int y = Math.abs(points[i][1]-points[j][1]);
                distance[i][j] = x+y;
            }
        }
        //对区间内的点进行计算sum
        while (m-- >0){//执行m次询问
            //接收当前的区间
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            //遍历每一个点,把符合条件在区间中的点加入list中
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {//遍历每一个点
                if (points[i][0]>=left && points[i][1]<=right){
                    list.add(i);
                }
            }

            System.out.println("这是当前的点list="+list);
            //遍历list,对list中每两个点之间的距离进行测算,结果加到sum中并输出
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i+1; j < list.size(); j++) {
                    sum += distance[list.get(i)][list.get(j)];
                }
            }

            System.out.println("这是m的趋势="+m+"这次的结果是="+sum);

        }


    }
}
