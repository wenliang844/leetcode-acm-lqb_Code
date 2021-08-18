package 数据结构算法教程.java数据结构算法.第10节_算法.马踏棋盘游戏问题;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/***
 马踏棋盘{骑士周游问题解决步骤&思路}_汉密尔顿通路问题
 比如6*6的网格中
 要符合规则踏遍36个格子
 1.这是一个DFS问题,需要回溯

 1.把棋盘创建8*8 chessBoard 是一个二维数组
 2.将当前这个位置设置为已经访问,根据当前位置,计算马还能走那些位置,并放入集合中lsit---count++
 3.遍历list中存放的所有位置,看看那个可以走通
 4.判断马儿是否完成任务 用计数器,走一步count++  if step和该走的步数比较,没达到失败,整个棋盘置0
 *
 *     6    7
 *   5        0
 *       马
 *   4        1
 *     3    2
 *
 *这种方法,没有优化,可以用贪心算法进行优化{策略}
 思路:使用贪心算法对原来的短发进行优化
 :需要对ps中的所有的下一步的所有集合的数目进行非递减排序,{优先选择集合中选择更少的点进行回溯,进行找到第一个解法}

 递减: 9 7 6 5 3 2 1
 非递减: 1 2 2 2 3 3 4 5 6  //可以有重复的值
 重写sort方法
 采用不同的策略,得到的解不一样
 */
 /*
 * File: KnightTravel2.cpp
 * Author: eshow
 * Date: 2007-09-10
 * Question:
    考虑国际象棋棋盘上某个位置的一只马，它是否可能只走63步，正好走过除起点外的其他63个位置各一次？如果有一种这样的走法，则称所走的这条路线为一条马的周游路线。试设计一个算法找出这样一条马的周游路线。
 * Solution:
    使用回溯法，马每一步至多有8种跳法，遍历这8种跳法，得到结果。这是一个子集树的回溯问题，每一个step[i]都在[0, 7]之间。设棋盘大小为N * N，则时间复杂度为O(8^(N * N))，当N = 8时，算法很慢。
    优化：当每准备跳一步时，设准备跳到(x, y)点，计算(x, y)这一点可能往几个方向跳（即向前看两步），将这个数目设为(x, y)点的权值，将所     有可能的(x, y)按权值排序，从最小的开始，循环遍历所有可能的(x, y)，回溯求出结果。算法可以求出所有可能的马跳棋盘路径，算出一个可行      的结果很快，但当N = 8时，要计算所有可能的结果仍然很慢，原因是结果太多了。BackTrace()函数实现了这种思想。
*/
public class HorseChessBoard {
    private static int X; //棋盘的列
    private static int Y; //棋盘的行
    //创建一个数组,标记棋盘的各个位置是否被访问过
    private static boolean visited[]; //访问标记
    //使用一个属性标记所有位置被访问
    private static boolean finished;//如果true,表示成功   默认为false


    public static void main(String[] args) {
        System.out.println("骑士周游算法开始运行------");
        //测试骑士周游算法是否正确
        X = 8;
        Y = 8;
        int row = 1; //马儿走的初始位置的行 从1开始编号 传入的时候row-1即可
        int column = 1; //马儿初始列1
        //创建这个棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y]; //记录每一个棋盘有没有访问过,访问过就是true 没访问就是false初始
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard,row-1,column-1,1);

        long end= System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"ms");

        //输出棋盘的最后情况 走通了 1-60个点都是1
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step+" ");
            }
            System.out.println();
        }


    }

    public static void traversalChessboard(int[][] chessborad, int row, int colume, int step) {

        /***
         骑士周游问题的算法:
         chessborad 棋盘
         row 当前位置行 0开始
         column 当前位置列 0开始
         step 是第几部 初始位置是第一步
         */
        //总37-1则是正确的位置
        chessborad[row][colume] = step;
        // 4 *8+column =34,个位置,按行树
        visited[row * X + colume] = true; //标记这个位置已经访问

        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(colume, row)); //colume->x列 rwo y 行
        //对ps中的元素进行非递减排序根据ps内部元素的下一次可选位置元素数量进行非递减排序
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0); //下一步可以去走的点,取出后继续传给traversalChessborad
            //判断这个点是否已经访过了
            if (!visited[p.y * X + p.x]) { //说明没有访问过  x_row行 y_colume列
                traversalChessboard(chessborad, p.y, p.x, step + 1);
            }
        }
        //判断有没有完成任务,step和该走的步数进行比较
        //如果没有达到数量,则表示没有达到完成任务,将整个棋盘置空0
        //说明 step<x*y  情况有两种
        //1.棋盘目前为止,任然没有走完,
        //2.棋盘走完了,处于一个回溯过程
        if (step < X * Y && !finished) {
            chessborad[row][colume] = 0;
            visited[row * X + colume] = false;
        } else {
            finished = true;
        }

    }

    //根据当前的位置Point对象,计算马儿还有哪些位置Point可以走,并放入一个集合中List,最多8位置
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个List 不能用if-else
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个Point
        Point p1 = new Point();
        //判断是否可以走5
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) { //马的走位 可以走左上位置
            //Point p1 = new Point();
            //ps.add(p1);
            ps.add(new Point(p1)); //需要新new一个point,因为每个point 后面的point修改会更改地址,影响list中point的值
        }
        //判断是否可以走6
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走7
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走0
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断是否可以走1
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走2
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走3
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断是否可以走4
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    //根据当前这一步的所有选择的位置进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //先获取到o1这个点的下一个点的个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1<count2){ //非递减
                    return -1;
                }else if (count1==count2){
                    return 0;
                }else{
                    return 1;
                }

                /***
                 // 从小到大 ：this‐o   整数  this大 把this放在前面
                 // 从大到小：o‐this
                 */
            }
        });
    }


}

























