package 数据结构算法教程.java数据结构算法.第4节_递归;

import java.util.Scanner;

public class MiGong迷宫_校宝在线 {

    public static void main(String[] args) {
        //先创建一个二维数组模拟这个迷宫
        Scanner sc = new Scanner(System.in);
        System.out.println("这是一个迷宫小程序:@by应聘者陈文亮,输入行和列,如迷宫1011是1行4列,从坐标(0,1)出发,找到最短的出口");
        System.out.println("请输入迷宫的行数:");
        int row = sc.nextInt();
        System.out.println("请输入迷宫的列数:");
        int col = sc.nextInt();

        int[][] map = new int[row][col];
        //1表示墙
        //0表示通路
        System.out.println("请输入完整的迷宫(格式1011,中间不要空格):");
        for (int i = 0; i < row; i++) {
            String s = sc.next();
            for (int j = 0; j < col; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }


        //输出地图
        /*for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(map[i]));
        }*/

        if(!setWay(map, 0, 0)){
            if (!setWay(map,1,1)){
                setWay(map,0,2);
            }
        }

       /*
       输出测试
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(map[i]));
        }*/
        //输出要求的坐标路径地图
        System.out.println("(0,1)");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j]==2){
                    System.out.println("("+i+","+j+")");
                }
            }
        }

    }

    //使用递归
    //
    public static boolean setWay(int[][] map, int i, int j) {
        //System.out.println("我在ij这个点" + i + "-" + j);
        if (map[i][j] == 0 &&(i==0||i==map[0].length-1||j==0||j==map.length-1)) {//停止条件  通路已经走过
            map[i][j] = 2;
            return true;
        } else {
            if (map[i][j] == 0) {//没走过,按策略走一下
                //下 右 上 左
                map[i][j] = 2;//假定这个点能通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上
                    return true;
                } else if (setWay(map, i, j - 1)) {//左
                    return true;
                } else {//走不通 标记不通
                    map[i][j] = 3;
                    return false;
                }
            } else {//i j不等于0   有可能是1墙 2走过 3死路
                return false;
            }
        }

        //return true;
    }
}
