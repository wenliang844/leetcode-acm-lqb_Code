package 蓝桥杯.蓝桥杯大赛历届真题.十一届;

public class D七段码 {

    static boolean visited[] = new boolean[7];
    static int[][] maze;
    static int count = 0;

    public static void main(String[] args) {
        maze = new int[7][7];
        maze[0][1] = 1;
        maze[1][2] = 1;
        maze[2][4] = 1;
        maze[4][5] = 1;
        maze[5][6] = 1;
        maze[6][0] = 1;
        maze[1][3] = 1;
        maze[2][3] = 1;
        maze[5][3] = 1;
        maze[6][3] = 1;

        maze[1][0] = 1;
        maze[2][1] = 1;
        maze[4][2] = 1;
        maze[5][4] = 1;
        maze[6][5] = 1;
        maze[0][6] = 1;
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[3][5] = 1;
        maze[3][6] = 1;

        for (int i = 0; i < 7; i++) {
            dfs(i);//从i节点开始
            count++;
        }

        System.out.println(count);

    }

    private static void dfs(int i) {
        visited[i]=true;
        for (int j = 0; j < 7; j++) {
            if (maze[i][j]==1&&!visited[j]){





            }
        }
    }
}
