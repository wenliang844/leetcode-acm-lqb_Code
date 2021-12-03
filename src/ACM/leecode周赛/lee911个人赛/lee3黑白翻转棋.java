package ACM.leecode周赛.lee911个人赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lee3黑白翻转棋 {
    public static void main(String[] args) {
        System.out.println(flipChess(new String[]{"....X.", "....X.", "XOOO..", "......", "......"}));
        System.out.println(flipChess(new String[]{".X.",".O.","XO."}));
        System.out.println(flipChess(new String[]{".......",".......",".......","X......",".O.....","..O....","....OOX"}));
    }

    //答案错误
    //枚举,遍历从每一个位置,能搞黑的最大值
    public static int flipChess(String[] chessboard) {
        char[][] chessboards = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; i++) {
            chessboards[i] = chessboard[i].toCharArray();
        }
        //printChessboards(chessboards);
        int sum = 0;
        for (int i = 0; i < chessboards.length; i++) {
            for (int j = 0; j < chessboards[0].length; j++) {
                if (chessboards[i][j]=='.'){
                    char[][] temp = new char[chessboard.length][chessboard[0].length()];
                    for (int k = 0; k < chessboard.length; k++) {
                        temp[k] = chessboard[k].toCharArray();
                    }
                    temp[i][j] = 'X';
                    //System.out.println("---");
                    //printChessboards(temp);
                    sum = Math.max(sum,dfs(temp,i,j));
                }

            }
        }

        return sum;
    }

    //从i,j 出发,能变黑多少个
    public static int dfs(char[][] chessboards, int i, int j) {
        //printChessboards(chessboards);
        //遍历8个角度, 有黑白白黑模式的 就可以List<int[]{i,j}> 将这些白弄黑 sum+
        List<int[]> list = new ArrayList<>();
        if (i-1>=0 && chessboards[i-1][j]=='O'){
            //System.out.println("i-1get");
            //printChessboards(chessboards);
            boolean flag = false;
            int k = i-2;
            for (; k >=0 ; k--) {//找一颗黑子
                if (chessboards[k][j]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int l = k+1; l < i; l++) {
                    list.add(new int[]{l,j});
                    chessboards[l][j] = 'X';//变黑
                }
            }
        }

        if (i+1<chessboards.length && chessboards[i+1][j]=='O'){
            boolean flag = false;
            int k = i+2;
            for (; k <chessboards.length ; k++) {//找一颗黑子
                if (chessboards[k][j]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int l = k-1; l > i; l--) {
                    list.add(new int[]{l,j});
                    chessboards[l][j] = 'X';//变黑
                }
            }
        }

        if (j-1>=0 && chessboards[i][j-1]=='O'){
            boolean flag = false;
            int k = j-2;
            for (; k >=0 ; k--) {//找一颗黑子
                if (chessboards[i][k]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int l = k+1; l < j; l++) {
                    list.add(new int[]{i,l});
                    chessboards[i][l] = 'X';//变黑
                }
            }
        }

        if (j+1<chessboards[0].length && chessboards[i][j+1]=='O'){
            boolean flag = false;
            int k = j+2;
            for (; k <chessboards[0].length ; k++) {//找一颗黑子
                if (chessboards[i][k]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int l = k-1; l > j; l--) {
                    list.add(new int[]{i,l});
                    chessboards[i][l] = 'X';//变黑
                }
            }
        }


        if (i-1>=0 && j-1>=0 && chessboards[i-1][j-1]=='O'){
            boolean flag = false;
            int k = i-2;
            int l = j-2;
            for (; k >=0 &&l>=0; k--,l--) {//找一颗黑子
                if (chessboards[k][l]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int m = k+1,n=l+1; m < i&&n<j; m++,n++) {
                    list.add(new int[]{m,n});
                    chessboards[m][n] = 'X';//变黑
                }
            }
        }

        if (i-1>=0 && j+1<chessboards[0].length && chessboards[i-1][j+1]=='O'){
            boolean flag = false;
            int k = i-2;
            int l = j+2;
            for (; k >=0 &&l<chessboards[0].length; k--,l++) {//找一颗黑子
                if (chessboards[k][l]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int m = k+1,n=l-1; m < i&&n>j; m++,n--) {
                    list.add(new int[]{m,n});
                    chessboards[m][n] = 'X';//变黑
                }
            }
        }
        if (i+1<chessboards.length && j-1>=0 && chessboards[i+1][j-1]=='O'){
            boolean flag = false;
            int k = i+2;
            int l = j-2;
            for (; k <chessboards.length &&l>=0; k++,l--) {//找一颗黑子
                if (chessboards[k][l]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int m = k-1,n=l+1; m > i&&n<j; m--,n++) {
                    list.add(new int[]{m,n});
                    chessboards[m][n] = 'X';//变黑
                }
            }
        }
        if (i+1<chessboards.length && j+1<chessboards[0].length&& chessboards[i+1][j+1]=='O'){
            boolean flag = false;
            int k = i+2;
            int l = j+2;
            for (; k <chessboards.length &&l<chessboards[0].length; k++,l++) {//找一颗黑子
                if (chessboards[k][l]=='X'){
                    flag = true;
                    break;
                }
            }
            if (flag){
                for (int m = k-1,n=l-1; m > i&&n>j; m--,n--) {
                    list.add(new int[]{m,n});
                    chessboards[m][n] = 'X';//变黑
                }
            }
        }
        //System.out.println(list);
        int sum = list.size();
        for (int[] ints : list) {
            sum += dfs(chessboards,ints[0],ints[1]);
            //System.out.println(ints[0]+"---"+ints[1]);
        }

        return sum;
    }


    public static void printChessboards(char[][] chessboards){
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < chessboards.length; i++) {
            System.out.println(Arrays.toString(chessboards[i]));
        }
    }
}
