package ACM.其他的算法比赛.笔试.腾讯音乐;

import java.util.Scanner;

public class code2三国鼎立 {

    static char[][] island;

    /**
     4 4
     1122
     1222
     3111
     3333
     * @param args
     */
    public static void main(String[] args) {
        //并查集 or dfs || 岛屿数量

        //dfs方法,一旦找到一个1 2 3,采用dfs(1.i.j)进行上下左右消除成-1
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        island = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = scanner.next();
            island[i] = s.toCharArray();
        }

        int count = 0;
        //遍历 dfs处理
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (island[i][j] == '1' || island[i][j]=='2' || island[i][j]=='3'){
                    dfs(island[i][j],i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(char c, int i, int j) {
        island[i][j]='0';
        if (i-1>=0 && island[i-1][j]==c){
            dfs(c,i-1,j);
        }
        if (j-1>=0 && island[i][j-1]==c){
            dfs(c,i,j-1);
        }
        if (i+1<island.length && island[i+1][j]==c){
            dfs(c,i+1,j);
        }
        if (j+1<island[0].length&& island[i][j+1]==c){
            dfs(c,i,j+1);
        }
    }
}
