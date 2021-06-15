package ACM.leecode周赛.力扣杯2021春;

import java.util.ArrayList;
import java.util.List;

public class lee4_变换的迷宫 {
    /***
     某解密游戏中，有一个 N*M 的迷宫，迷宫地形会随时间变化而改变，迷宫出口一直位于 (n-1,m-1) 位置。迷宫变化规律记录于 maze 中，maze[i] 表示 i 时刻迷宫的地形状态，"." 表示可通行空地，"#" 表示陷阱。
     地形图初始状态记作 maze[0]，此时小力位于起点 (0,0)。此后每一时刻可选择往上、下、左、右其一方向走一步，或者停留在原地。
     小力背包有以下两个魔法卷轴（卷轴使用一次后消失）：

     临时消除术：将指定位置在下一个时刻变为空地；
     永久消除术：将指定位置永久变为空地。

     请判断在迷宫变化结束前（含最后时刻），小力能否在不经过任意陷阱的情况下到达迷宫出口呢？
     注意： 输入数据保证起点和终点在所有时刻均为空地。
     示例 1：
     输入：maze = [[".#.","#.."],["...",".#."],[".##",".#."],["..#",".#."]]
     输出：true
     */
    //直接递归搜索法 27/59
    public static boolean outMaze(List<List<String>> maze, int xPos, int yPos, int surplusMagic,int time) {
        //现在在0位置,下一步需要向上,向左,向右,向中走,优先向右 下走
        //先判断是否到达终点
        boolean flag = false;
        if (xPos == maze.get(0).size() - 1 && yPos == maze.get(0).get(0).length() - 1) {//到达终点,直接return true;
            return true;
        }
        //如果这时候time>长度,直接return false
        if (time >= maze.size()-1){
            return false;
        }
        //向右走,case:y<maze.get(0).get(0).length() y+1
        if (yPos < maze.get(0).get(0).length()-1) {
            if (maze.get(time+1).get(xPos).charAt(yPos+1)=='.'){
                flag = outMaze(maze,xPos,yPos+1,surplusMagic,time+1);
            }else {
                if (surplusMagic>=1){
                    flag = outMaze(maze,xPos,yPos+1,surplusMagic-1,time+1);
                }
            }
            if (flag)return flag;//如果接收到true,直返回,不再留恋
        }
        //向下走,case:x<maze.get(0).size() y+1
        if (xPos < maze.get(time+1).size()-1) {
            if (maze.get(time+1).get(xPos+1).charAt(yPos)=='.'){
                flag = outMaze(maze,xPos+1,yPos,surplusMagic,time+1);
            }else {
                if (surplusMagic>=1){
                    flag = outMaze(maze,xPos+1,yPos,surplusMagic-1,time+1);
                }
            }
            if (flag)return flag;
        }
        //向左走,case:x<maze.get(0).size() y+1
        if (yPos >0) {
            if (maze.get(time+1).get(xPos).charAt(yPos-1)=='.'){
                flag = outMaze(maze,xPos,yPos-1,surplusMagic,time+1);
            }else {
                if (surplusMagic>=1){
                    flag = outMaze(maze,xPos,yPos-1,surplusMagic-1,time+1);
                }
            }
            if (flag)return flag;
        }
        //向上走,case:x<maze.get(0).size() y+1
        if (xPos >0) {
            if (maze.get(time+1).get(xPos-1).charAt(yPos)=='.'){
                flag = outMaze(maze,xPos-1,yPos,surplusMagic,time+1);
            }else {
                if (surplusMagic>=1){
                    flag = outMaze(maze,xPos-1,yPos,surplusMagic-1,time+1);
                }
            }
            if (flag)return flag;
        }
        return flag;
    }

    public static boolean escapeMaze(List<List<String>> maze) {

        return outMaze(maze, 0, 0, 2,0);//从0,0出发,两次走障碍的机会,递归遍历暴力
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add(".#.");
        list1.add("#..");
        List<String> list2 = new ArrayList<>();
        list2.add(".##");
        list2.add(".#.");
        List<String> list3 = new ArrayList<>();
        list3.add("..#");
        list3.add(".#.");
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(escapeMaze(list));

    }
}
