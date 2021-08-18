package ACM.每日一题leecode.day185;

public class day187_576出界的路径数 {

    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
    }

    static int count;
    static int x;
    static int y;

    //methodOne:深度优先搜索计数方法  mod=1000000007   超时
    //记忆化dfs。下次走到（x,y,step）时如果之前走过就return 路径数量，没走过就走下去
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        count = 0;
        x = m;
        y = n;
        dfs(startRow, startColumn, maxMove);
        return count;
    }

    private static void dfs(int startRow, int startColumn, int maxMove) {

        if (startRow < 0 || startRow >= x || startColumn < 0 || startColumn >= y) {
            count++;
            return;
        }
        if (maxMove != 0) {
            //上下左右进行尝试出界
            dfs(startRow - 1, startColumn, maxMove - 1);
            dfs(startRow + 1, startColumn, maxMove - 1);
            dfs(startRow, startColumn - 1, maxMove - 1);
            dfs(startRow, startColumn + 1, maxMove - 1);
        }

    }


}
