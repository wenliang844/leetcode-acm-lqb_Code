package ACM.leecode周赛.第52场双周赛;

import java.util.Arrays;

public class lee3_5744旋转盒子 {
    /****
     给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
     '#' 表示石头
     '*' 表示固定的障碍物
     '.' 表示空位置
     这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
     题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
     请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。
     */
    public static void printchs(char chs[][]) {
        for (int i = 0; i < chs.length; i++) {
            System.out.println(Arrays.toString(chs[i]));
        }
    }

    public static void main(String[] args) {
        printchs(rotateTheBox(new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}}));
        printchs(rotateTheBox(new char[][]{{'#','.','#'}}));
        printchs(rotateTheBox(new char[][]{{'#','.','*','.'},{'#','#','*','.'}}));
        printchs(rotateTheBox(new char[][]{{'#','#','*','.','*','.'},{'#','#','#','*','.','.'},{'#','#','#','.','#','.'}}));
    }

    //方法一:模拟法:从右向左,如果是#,向右扫描,是空继续,直到是*或到底了
    public static char[][] rotateTheBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = box[i].length - 2; j >= 0; j--) {
                if (box[i][j] == '#') {//是#则判断,下落
                    int k = j + 1;
                    while (k < box[i].length && box[i][k] == '.' ) {
                        k++;
                    }
                    box[i][j] = '.';
                    box[i][k - 1] = '#';
                }
            }
        }
        char[][] res = new char[box[0].length][box.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][box.length-1-j] = box[j][i];
            }
        }
        return res;
    }
}
