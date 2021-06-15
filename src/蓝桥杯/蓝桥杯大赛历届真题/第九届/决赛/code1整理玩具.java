package 蓝桥杯.蓝桥杯大赛历届真题.第九届.决赛;

import java.util.Scanner;

public class code1整理玩具 {


    public static void main(String[] args) {
        /***
         1.遍历数组的宽,是否相同,相同的就从i,j传入dfs进行矩形消灭,如果矩形中不一样false
         2.将矩形变-1  -1就不用访问了
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                String s = sc.next();
                for (int j = 0; j < s.length(); j++) {
                    matrix[i][j] = s.charAt(j) - '0';
                }
            }
        boolean visited[] = new boolean[10];//0-9
            boolean flag = true;
            //遍力matrix
            for (int i = 0; i < row; i++) {
                //!=-1 查看row方向有多少是一样的
                int j = 0;
                while (j<col){
                    while (j<col &&matrix[i][j]==-1){
                        j++;
                    }
                    if (j>=col)break;//越界 去下一行
                    int index = j+1;
                    while (index<col && matrix[i][index]==matrix[i][j]){
                        index++;
                    }
                    index--;
                    //看看j是否没查看
                    if (visited[matrix[i][j]]){
                       flag = false;
                        break;
                    }else {
                        //将j设置为已查看查看
                        visited[matrix[i][j]]=true;
                       flag = dfs(matrix,i,j,index);
                        j=index+1;

                    }

                }

            }

            if (flag){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int[][] matrix, int i1, int j, int index) {
        //将i - index设置为i
        int num = matrix[i1][j];
        for (int i = i1; i < matrix.length; i++) {
            if (matrix[i][j]==num){
                for (int k = j; k <= index; k++) {
                    if (matrix[i][k]!=num){
                        return false;
                    }else {
                        matrix[i][k]=-1;
                    }
                }
            }
        }

        return true;
    }
}
