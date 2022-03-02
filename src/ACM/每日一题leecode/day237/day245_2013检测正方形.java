package ACM.每日一题leecode.day237;

import java.util.Arrays;

public class day245_2013检测正方形 {
    public static void main(String[] args) {
        day245_2013检测正方形 detectSquares = new day245_2013检测正方形();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));// 返回 1 。你可以选择：//   - 第一个，第二个，和第三个点

        System.out.println(detectSquares.count(new int[]{14, 8}));// 返回 0 。查询点无法与数据结构中的这些点构成正方形。        //   - 第一个，第二个，和第三个点
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        System.out.println(detectSquares.count(new int[]{11, 10}));// 返回 2 。你可以选择：        //   - 第一个，第三个，和第四个点

    }

    int[][] squares;

    public day245_2013检测正方形() {
        squares = new int[1000][1000];
    }

    public void add(int[] point) {
        printNums();
        squares[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        printNums();
        //第一个点每一个都可以 第二个点只能在同一条线上 第三条只能在同一条竖线上 第四条固定
        int count = 0;
        //第一个点
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                if (squares[i][j] != 0) {
                    //第二个点
                    for (int k = i + 1; k < squares.length; k++) {
                        if (squares[k][j] != 0) {
                            //第三个点
                            for (int l = j + 1; l < squares[0].length; l++) {
                                if (squares[i][l] != 0 && squares[k][l] != 0) { //第四个点
                                    count += squares[i][j] * squares[k][j] * squares[i][l] * squares[k][l];

                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public void printNums(){
        System.out.println("--------------------------begin print!!!");
        for (int i = 0; i < squares.length; i++) {
            System.out.println(Arrays.toString(squares[i]));
        }
    }
}
